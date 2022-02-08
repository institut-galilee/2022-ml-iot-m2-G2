import cv2
from PySide6.QtCore import QTimer
from PySide6.QtGui import QPixmap, QImage
from PySide6.QtWidgets import QLabel

from src.callback.recognition_callback import RecognitionCallback
from src.process import FaceRecognizer, ObjectRecognizer


class WebCameraView(QLabel, RecognitionCallback):

    def __init__(self):
        super().__init__()

        # Create a capture timer to refresh images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

        self.video_capture = cv2.VideoCapture(0)
        self.capture_timer.start(1)

        self.face_recognizer = FaceRecognizer(self)
        self.face_recognizer.start()

        self.object_recognizer = ObjectRecognizer(self)
        self.object_recognizer.start()

    def close(self):
        self.object_recognizer.is_not_stopped = False
        self.face_recognizer.is_not_stopped = False
        self.capture_timer.stop()
        self.video_capture.release()

    def on_face_recognized(self, recognized_image, known_student):
        pass

    def on_objects_recognized(self, recognized_objects):
        pass

    def on_preview_frame(self):
        ret, frame = self.video_capture.read()
        frame = cv2.resize(frame, (self.width(), self.height()))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        self.setPixmap(QPixmap.fromImage(image))
        self.object_recognizer.frame = cv2.imencode('.jpg', frame)[1].tobytes()
        self.face_recognizer.frame = frame


class PhoneCameraView(QLabel, RecognitionCallback):

    def __init__(self):
        super().__init__()
        self.frame = None

        self.object_recognizer = ObjectRecognizer(self)
        self.object_recognizer.start()

    def close(self):
        self.object_recognizer.is_not_stopped = False

    def on_objects_recognized(self, recognized_objects):
        print(recognized_objects)

    def update_frame(self, frame):
        self.object_recognizer.frame = frame
        self.frame = frame
        pixmap = QPixmap()
        pixmap.loadFromData(frame)
        self.update_image(pixmap)
        self.setPixmap(pixmap.scaledToWidth(self.width()))
