import io
import logging as logger
import threading
import time

import PIL.Image
import dlib
import numpy as np
import pyautogui
import speech_recognition as sr
from PySide6.QtCore import Qt, QPoint
from PySide6.QtGui import QImage, QPixmap, QPen, QPainter, QColor
from pyzbar.pyzbar import decode

from callback.recognition_callback import RecognitionCallback
from ml_helper import MLHelper
from monitor_client import MonitorHelper


class FaceRecognizer(threading.Thread):

    def __init__(self, face_recognition_callback: RecognitionCallback):
        threading.Thread.__init__(self)

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
            if len(self.known_persons) > 0 and self.frame is not None:
                self.recognize_face()
            time.sleep(5)

    def encode_known_student_faces(self):
        encoded_faces = []
        for known_person in self.known_persons:
            image = PIL.Image.open(io.BytesIO(known_person.profile_photo))
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

    def __init__(self, object_recognition_callback: RecognitionCallback, source):
        threading.Thread.__init__(self)

        self.object_recognition_callback = object_recognition_callback
        self.source = source

        self.frame = None
        self.is_not_stopped = True

    def run(self):
        while self.is_not_stopped:
            if self.frame is not None:
                self.recognize_objects()
            time.sleep(5)

    def recognize_objects(self):
        recognized_objects = MLHelper.recognize_object(self.frame)[0]
        self.object_recognition_callback.on_camera_objects_recognized(recognized_objects, self.source)


class SpeechRecognizer(threading.Thread):
    def __init__(self, speech_recognition_callback: RecognitionCallback):
        threading.Thread.__init__(self)

        self.speech_recognition_callback = speech_recognition_callback

        self.speech_engine = sr.Recognizer()
        self.is_recording = True

    def run(self):
        while self.is_recording:
            with sr.Microphone() as source:
                self.speech_engine.adjust_for_ambient_noise(source)
                audio_data = self.speech_engine.record(source, duration=5)
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

        self.text_recognition_callback = text_recognition_callback
        self.exam_reference = exam_reference.split()

        self.speech_engine = sr.Recognizer()
        self.is_screenshotting = True

    def run(self):
        while self.is_screenshotting:
            screenshot = pyautogui.screenshot()
            width, height = screenshot.size
            print(width, height)
            barcodes = decode(screenshot)
            references = []
            for barcode in barcodes:
                print(barcode.rect)
                references.append(barcode.data.decode("UTF-8"))
            if set(references) != set(self.exam_reference):
                extracted_text = MLHelper.recognize_text(screenshot)
                self.text_recognition_callback.on_qr_code_verification_failed(extracted_text)
                # self.text_recognition_callback.on_screenshot_text_recognized(extracted_text)
            time.sleep(5)
