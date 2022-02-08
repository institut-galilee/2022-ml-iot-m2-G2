import cv2
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QWidget, QLabel
import logging as logger

from process import Recognizer


class AuthenticationView(QLabel):
    def __init__(self):
        super().__init__()

        self.setFixedWidth(720)
        self.setFixedHeight(720)

        # Create a capture timer to refresh images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

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
        if self.known_student is None:
            ret, frame = self.video_capture.read()
            frame = frame[self.x:self.x + self.dim, self.y:self.y + self.dim]
            frame = cv2.resize(frame, (560, 560))
            frame = cv2.flip(frame, 1)
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
            pixmap = QPixmap.fromImage(image)
            self.video_view.update_image(pixmap.scaled(560, 560))
            self.recognizer.frame = frame
        else:
            self.capture_timer.stop()

    def on_face_recognized(self, recognized_image, known_student):
        self.next_button.setEnabled(True)
        self.known_student = known_student
        time.sleep(2)
        self.video_view.update_image(recognized_image.scaled(560, 560))

    def closeEvent(self, event: QCloseEvent):
        self.recognizer.is_not_recognized = False
        self.stop_recognition()

    def stop_recognition(self):
        self.capture_timer.stop()
        logger.info("Shutting down the face recognition system…")
        self.video_capture.release()