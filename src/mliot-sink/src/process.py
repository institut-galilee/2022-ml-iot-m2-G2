import io
import logging as logger
import threading
import time

import dlib
import numpy as np
import pyautogui
import speech_recognition as sr
from PySide6.QtCore import Qt, QPoint
from PySide6.QtGui import QImage, QPixmap, QPen, QPainter, QColor
from pyzbar.pyzbar import decode
from PIL import Image
from callback.recognition_callback import RecognitionCallback
from ml_helper import MLHelper
from monitor_client import MonitorHelper


class FaceRecognizer(threading.Thread):

    def __init__(self, face_recognition_callback: RecognitionCallback):
        threading.Thread.__init__(self)

        self.sleeping_timeout = 5
        self.face_recognition_callback = face_recognition_callback
        logger.info("Importing pretrained model…")
        self.face_detector = dlib.get_frontal_face_detector()
        self.pose_predictor_5_point = dlib.shape_predictor("opencv_pretrained_model/shape_predictor_5_face_landmarks.dat")
        self.pose_predictor_68_point = dlib.shape_predictor("opencv_pretrained_model/shape_predictor_68_face_landmarks.dat")
        self.face_encoder = dlib.face_recognition_model_v1("opencv_pretrained_model/dlib_face_recognition_resnet_model_v1.dat")

        self.known_persons = MonitorHelper.fetch_known_students()
        if len(self.known_persons) == 0:
            logger.info("No student found as reference")
            raise ValueError('No student found as reference')
        else:
            self.known_encoded_faces = self.encode_known_student_faces()
            logger.info("Students' faces well imported")
            logger.info("Searching for students' faces…")
            self.frame = None
            self.is_not_stopped = True

    def run(self):
        while self.is_not_stopped:
            time.sleep(self.sleeping_timeout)
            if len(self.known_persons) > 0 and self.frame is not None:
                self.recognize_face()

    def encode_known_student_faces(self):
        encoded_faces = []
        for known_person in self.known_persons:
            image = Image.open(io.BytesIO(known_person.profile_photo))
            image = np.array(image)
            encoded_faces.append(MLHelper.encode_face(image, self.face_detector, self.pose_predictor_68_point, self.face_encoder)[0][0])
        return encoded_faces

    def recognize_face(self):
        known_person, top, right, bottom, left = MLHelper.recognize_face(self.frame, self.known_persons, self.known_encoded_faces, self.face_detector, self.pose_predictor_68_point, self.face_encoder)
        if known_person is not None:
            image = QImage(self.frame, self.frame.shape[1], self.frame.shape[0], QImage.Format_RGB888)
            pixmap = QPixmap.fromImage(image)
            painter = QPainter(pixmap)
            color = QColor(255, 255, 255, 255)
            painter.setPen(QPen(color, 2, Qt.SolidLine))
            painter.drawEllipse(QPoint(int((right + left)/2), int((bottom + top) / 2)), int((2 * (right - left)) / 3), bottom - top)
            painter.drawText(15, pixmap.height() - 50, f"Nom: {known_person.last_name}")
            painter.drawText(15, pixmap.height() - 30, f"Prénom: {known_person.first_name}")
            painter.drawText(15, pixmap.height() - 10, f"N° étudiant: {known_person.card_number}")
            painter.end()
            self.face_recognition_callback.on_face_recognized(pixmap, known_person)
        else:
            self.face_recognition_callback.on_face_not_recognized()


class ObjectRecognizer(threading.Thread):

    def __init__(self, object_recognition_callback: RecognitionCallback, source, should_read_qr_code):
        threading.Thread.__init__(self)

        self.sleeping_timeout = 5
        self.object_recognition_callback = object_recognition_callback
        self.source = source
        self.should_read_qr_code = should_read_qr_code

        self.frame = None
        self.is_not_stopped = True

    def run(self):
        while self.is_not_stopped:
            time.sleep(self.sleeping_timeout)
            if self.frame is not None:
                self.recognize_objects()

    def recognize_objects(self):
        bytes_image = io.BytesIO(self.frame)
        image = Image.open(bytes_image)
        if self.should_read_qr_code:
            barcodes = decode(image)
            read_entries = []
            for barcode in barcodes:
                read_entries.append(barcode.data.decode("UTF-8"))
            self.object_recognition_callback.on_qr_code_read(read_entries)
        recognized_objects = MLHelper.recognize_object(image)[0]
        self.object_recognition_callback.on_camera_objects_recognized(recognized_objects, self.source)


class SpeechRecognizer(threading.Thread):
    def __init__(self, speech_recognition_callback: RecognitionCallback):
        threading.Thread.__init__(self)

        self.sleeping_timeout = 5
        self.speech_recognition_callback = speech_recognition_callback

        self.speech_engine = sr.Recognizer()
        self.is_recording = True

    def run(self):
        while self.is_recording:
            with sr.Microphone() as source:
                self.speech_engine.adjust_for_ambient_noise(source)
                audio_data = self.speech_engine.record(source, duration=self.sleeping_timeout)
                try:
                    extracted_text = self.speech_engine.recognize_google(audio_data, language="fr-FR")
                    self.speech_recognition_callback.on_microphone_speech_recognized(extracted_text)
                except sr.UnknownValueError:
                    pass
                except sr.RequestError:
                    pass


class ScreenshotTextRecognizer(threading.Thread):
    def __init__(self, text_recognition_callback: RecognitionCallback, exam_reference):
        threading.Thread.__init__(self)

        self.sleeping_timeout = 5
        self.text_recognition_callback = text_recognition_callback
        self.exam_reference = exam_reference.split()

        self.speech_engine = sr.Recognizer()
        self.is_screenshotting = True

    def run(self):
        while self.is_screenshotting:
            time.sleep(self.sleeping_timeout)
            screenshot = pyautogui.screenshot()
            barcodes = decode(screenshot)
            rectangles = []
            references = []
            for barcode in barcodes:
                rectangles.append([barcode.rect.left, barcode.rect.top, barcode.rect.width, barcode.rect.height])
                references.append(barcode.data.decode("UTF-8"))
            # Check whether the secret codes are detected
            if set(references).issubset(set(self.exam_reference)):
                if len(rectangles) == 4:
                    self.sort_rectangles(rectangles)
                    top_left = rectangles[0]
                    top_right = rectangles[2]
                    bottom_left = rectangles[1]
                    bottom_right = rectangles[3]
                    browser_width = max(top_right[0] + top_right[2] - top_left[0], bottom_right[0] + bottom_right[2] - bottom_left[0])
                    browser_height = max(bottom_left[1] + bottom_left[3] - top_left[1], bottom_right[1] + bottom_right[3] - top_right[1])
                    screen_width, screen_height = screenshot.size
                    # Check whether the size of browser is slightly approaching the size of the screen
                    if screen_width - browser_width > 50 or screen_height - browser_height > 150:
                        self.text_recognition_callback.on_browser_size_not_fitting_screen_size(screen_width, screen_height, browser_width, browser_height)
                else:
                    self.text_recognition_callback.on_qr_code_verification_failed(references)
            else:
                extracted_text = MLHelper.recognize_text(screenshot)
                self.text_recognition_callback.on_screenshot_text_recognized(extracted_text)

    @staticmethod
    def sort_rectangles(rectangles):
        size = len(rectangles)
        for i in range(size - 1):
            for j in range(0, size - i - 1):
                if (rectangles[j][0] + rectangles[j][1]) > (rectangles[j + 1][0] + rectangles[j + 1][1]):
                    rectangles[j], rectangles[j + 1] = rectangles[j + 1], rectangles[j]
