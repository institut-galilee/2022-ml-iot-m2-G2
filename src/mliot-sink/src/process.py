import io
import logging as logger
import threading
import time

import PIL.Image
import dlib
import numpy as np
from PySide6.QtCore import Qt, QPoint
from PySide6.QtGui import QImage, QPixmap, QPen, QPainter, QColor

from callback.face_recognition_callback import FaceRecognitionCallback
from ml_helper import MLHelper
from monitor_client import MonitorHelper


class Recognizer(threading.Thread):

    def __init__(self, recognition_callback: FaceRecognitionCallback):
        threading.Thread.__init__(self)

        self.recognition_callback = recognition_callback
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
            self.is_not_recognized = True

    def run(self):
        while self.is_not_recognized:
            if len(self.known_persons) > 0 and self.frame is not None:
                self.recognize_face()
            time.sleep(1)

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
            self.is_not_recognized = False
            known_person_name = f"{known_person.first_name} {known_person.last_name}"
            logger.info(f"{known_person_name} is recognized.")
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
            self.recognition_callback.on_face_recognized(pixmap, known_person)
