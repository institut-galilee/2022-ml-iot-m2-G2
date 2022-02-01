import io
import logging as logger
import threading
import time

import PIL.Image
import cv2
import dlib
import numpy as np
from PySide6.QtCore import QTimer, Qt, QRect, QPoint
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, QPen, QPainter, QColor, QBrush
from PySide6.QtWidgets import QWidget, QVBoxLayout, QLabel, QPushButton, QGridLayout
from imutils import face_utils

from callback.face_recognition_callback import FaceRecognitionCallback
from callback.setup_callback import SinkSetupCallback
from monitor_client import MonitorHelper
from view.video_view import VideoView


class RecognizerView(QWidget, FaceRecognitionCallback):
    def __init__(self, recognition_callback: SinkSetupCallback):
        super().__init__()

        self.recognition_callback = recognition_callback
        # Enable logging with info mode
        logger.basicConfig(level=logger.INFO)
        logger.info("Starting face recognition system…")

        header_label = QLabel("FACIAL IDENTIFICATION")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("font-size: 18px; font-weight: bold")

        self.next_button = QPushButton("NEXT")
        self.next_button.setEnabled(False)
        self.next_button.setFixedWidth(200)
        self.next_button.clicked.connect(self.next)

        self.video_view = VideoView()
        grid_layout = QGridLayout(self)
        grid_layout.addWidget(header_label, 0, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(self.video_view, 1, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(self.next_button, 2, 1)

        # Create a capture timer to refresh images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

        logger.info("Opening of web camera…")
        self.video_capture = cv2.VideoCapture(0)
        self.dim = int(min(self.video_capture.get(3), self.video_capture.get(4)))
        self.x = int((self.video_capture.get(4) - self.dim) / 2)
        self.y = int((self.video_capture.get(3) - self.dim) / 2)
        self.capture_timer.start(1)

        logger.info("Web camera well opened")
        logger.info("Starting of face detection…")
        self.recognizer = Recognizer(self)
        self.recognizer.start()

        self.known_student = None

    def next(self):
        self.stop_recognition()
        self.recognition_callback.on_student_recognized(self.known_student)

    def on_preview_frame(self):
        if self.video_capture.isOpened():
            ret, frame = self.video_capture.read()
            if frame is not None:
                frame = frame[self.x:self.x + self.dim, self.y:self.y + self.dim]
                frame = cv2.resize(frame, (720, 720))
                frame = cv2.flip(frame, 1)
                frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
                image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
                pixmap = QPixmap.fromImage(image)
                self.video_view.update_image(pixmap.scaled(560, 560))
                self.recognizer.frame = frame
            else:
                self.capture_timer.stop()

    def on_face_recognized(self, recognized_image, known_student):
        self.stop_recognition()
        self.next_button.setEnabled(True)
        self.known_student = known_student
        self.video_view.update_image(recognized_image.scaled(560, 560))

    def closeEvent(self, event: QCloseEvent):
        self.recognizer.is_not_recognized = False
        self.stop_recognition()

    def stop_recognition(self):
        #self.capture_timer.stop()
        logger.info("Shutting down the face recognition system…")
        self.video_capture.release()


class Recognizer(threading.Thread):

    def __init__(self, recognition_callback: FaceRecognitionCallback):
        threading.Thread.__init__(self)

        self.recognition_callback = recognition_callback
        logger.info("Importing pretrained model…")
        self.face_detector = dlib.get_frontal_face_detector()
        self.pose_predictor_5_point = dlib.shape_predictor("pretrained_model/shape_predictor_5_face_landmarks.dat")
        self.pose_predictor_68_point = dlib.shape_predictor("pretrained_model/shape_predictor_68_face_landmarks.dat")
        self.face_encoder = dlib.face_recognition_model_v1("pretrained_model/dlib_face_recognition_resnet_model_v1.dat")

        self.known_students = []
        self.known_encoded_faces = []

        logger.info("Searching for students' faces…")
        self.fetch_list_of_students()
        self.frame = None
        self.is_not_recognized = True

    def run(self):
        while self.is_not_recognized:
            if len(self.known_students) > 0 and self.frame is not None:
                self.recognize_face()
            time.sleep(1)

    def fetch_list_of_students(self):
        self.known_students = MonitorHelper.fetch_known_students()
        if len(self.known_students) == 0:
            raise ValueError('No student found as reference')
        for known_student in self.known_students:
            image = PIL.Image.open(io.BytesIO(known_student.profile_photo))
            image = np.array(image)
            encoded_face = self.encode_face(image)[0][0]
            self.known_encoded_faces.append(encoded_face)
        logger.info("Students' faces well imported")

    def encode_face(self, image):
        face_locations = self.face_detector(image, 1)
        face_encodings_list = []
        landmarks_list = []
        for face_location in face_locations:
            # DETECT FACES
            shape = self.pose_predictor_68_point(image, face_location)
            face_encodings_list.append(np.array(self.face_encoder.compute_face_descriptor(image, shape, num_jitters=1)))
            # GET LANDMARKS
            shape = face_utils.shape_to_np(shape)
            landmarks_list.append(shape)
        face_locations = self.transform(image, face_locations)
        return face_encodings_list, face_locations, landmarks_list

    @staticmethod
    def transform(image, face_locations):
        coord_faces = []
        for face in face_locations:
            rect = face.top(), face.right(), face.bottom(), face.left()
            coord_face = max(rect[0], 0), min(rect[1], image.shape[1]), min(rect[2], image.shape[0]), max(rect[3], 0)
            coord_faces.append(coord_face)
        return coord_faces

    def recognize_face(self):
        rgb_small_frame = self.frame[:, :, ::-1]
        # ENCODING FACE
        face_encodings_list, face_locations_list, landmarks_list = self.encode_face(rgb_small_frame)
        face_names = []
        for face_encoding in face_encodings_list:
            if len(face_encoding) == 0:
                return np.empty(0)
            # CHECK DISTANCE BETWEEN KNOWN FACES AND FACES DETECTED
            vectors = np.linalg.norm(self.known_encoded_faces - face_encoding, axis=1)
            tolerance = 0.8
            result = []
            for vector in vectors:
                if vector <= tolerance:
                    result.append(True)
                else:
                    result.append(False)
            if True in result:
                first_match_index = result.index(True)
                known_student = self.known_students[first_match_index]
                name = f"{known_student.first_name} {known_student.last_name}"
                logger.info(f"{name}'s face is recognized")
                # Trigger a callback to notify that the student identity is confirmed
                self.is_not_recognized = False
                top, right, bottom, left = list(face_locations_list[0])
                image = QImage(self.frame, self.frame.shape[1], self.frame.shape[0], QImage.Format_RGB888)
                pixmap = QPixmap.fromImage(image)
                painter = QPainter(pixmap)
                color = QColor(0, 255, 0, 255)
                painter.setPen(QPen(color, 2, Qt.SolidLine))
                painter.drawRect(left, top, right - left, bottom - top)
                painter.setPen(QPen(color, Qt.SolidLine))
                painter.fillRect(QRect(left, bottom - 30, right - left, 30), QBrush(color))
                painter.setPen(QPen(QColor(0, 0, 0, 255), Qt.SolidLine))
                painter.drawText(left + 5, bottom - 10, name)
                painter.setPen(QPen(QColor(255, 0, 255, 255), -1, Qt.SolidLine))
                for shape in landmarks_list:
                    for (a, b) in shape:
                        painter.drawEllipse(QPoint(a, b), 1, 1)
                painter.end()
                self.recognition_callback.on_face_recognized(pixmap, known_student)
                break
