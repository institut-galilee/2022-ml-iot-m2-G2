import io
import logging as logger

import PIL.Image
import cv2
import dlib
import numpy as np
import pyttsx3
from PySide6.QtCore import QTimer, Qt, QRect, QPoint
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, QPen, QPainter, QColor, QBrush
from PySide6.QtWidgets import QWidget, QLabel, QVBoxLayout
from imutils import face_utils

from monitor_client import MonitorHelper


class RecognizerView(QWidget):
    def __init__(self):
        super().__init__()

        # Enable logging with info mode
        logger.basicConfig(level=logger.INFO)

        logger.info("Starting face recognition system…")
        logger.info("Importing pretrained model…")
        self.face_detector = dlib.get_frontal_face_detector()
        self.pose_predictor_5_point = dlib.shape_predictor("pretrained_model/shape_predictor_5_face_landmarks.dat")
        self.pose_predictor_68_point = dlib.shape_predictor("pretrained_model/shape_predictor_68_face_landmarks.dat")
        self.face_encoder = dlib.face_recognition_model_v1("pretrained_model/dlib_face_recognition_resnet_model_v1.dat")

        self.video_view = QLabel()
        layout = QVBoxLayout(self)
        layout.addWidget(self.video_view)

        self.known_face_names = []
        self.known_encoded_faces = []

        logger.info("Searching for students' faces…")
        self.fetch_list_of_students()

        # Create a timer to refresh images
        self.timer = QTimer()
        self.timer.timeout.connect(self.on_preview_frame)

        logger.info("Opening of web camera…")
        self.video_capture = cv2.VideoCapture(0)
        self.video_capture.set(3, 720)
        self.video_capture.set(4, 720)
        self.timer.start(5000)
        logger.info("Web camera well opened")
        logger.info("Starting of face detection…")

    def on_preview_frame(self):
        ret, frame = self.video_capture.read()
        frame = cv2.resize(frame, (720, 720))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        pixmap = QPixmap.fromImage(image)
        self.video_view.setPixmap(pixmap)
        self.recognize_face(frame)

    def fetch_list_of_students(self):
        known_students = MonitorHelper.fetch_known_students()
        if len(known_students) == 0:
            raise ValueError('No student found as reference')
        for known_student in known_students:
            self.known_face_names.append(f"{known_student.first_name} {known_student.last_name}")
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

    def recognize_face(self, frame):
        rgb_small_frame = frame[:, :, ::-1]
        # ENCODING FACE
        face_encodings_list, face_locations_list, landmarks_list = self.encode_face(rgb_small_frame)
        face_names = []
        for face_encoding in face_encodings_list:
            if len(face_encoding) == 0:
                return np.empty(0)
            # CHECK DISTANCE BETWEEN KNOWN FACES AND FACES DETECTED
            vectors = np.linalg.norm(self.known_encoded_faces - face_encoding, axis=1)
            tolerance = 0.6
            result = []
            for vector in vectors:
                if vector <= tolerance:
                    result.append(True)
                else:
                    result.append(False)
            if True in result:
                first_match_index = result.index(True)
                name = self.known_face_names[first_match_index]
                logger.info(f"{name}'s face is recognized")
                # Make the student hear that he/she is recognized via text to speech engine
                pyttsx3.speak(f"Hello {name}, your identity is confirmed")
            else:
                name = "Unknown"
            face_names.append(name)

        for (top, right, bottom, left), name in zip(face_locations_list, face_names):
            if True in result:
                color = QColor(0, 255, 0, 255)
            else:
                color = QColor(255, 0, 255, 255)
            image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
            pixmap = QPixmap.fromImage(image)
            painter = QPainter(pixmap)
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
            self.video_view.setPixmap(pixmap)

    def closeEvent(self, event: QCloseEvent):
        self.timer.stop()
        logger.info("Shutting down the face recognition system…")
        self.video_capture.release()
