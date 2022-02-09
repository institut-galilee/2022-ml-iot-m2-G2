import cv2
from PySide6.QtCore import QTimer
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, Qt
from PySide6.QtWidgets import QWidget, QHBoxLayout, QVBoxLayout, QLabel

from acceleration_view import AccelerationView
from callback.recognition_callback import RecognitionCallback
from src.process import SpeechRecognizer, TextRecognizer, FaceRecognizer, ObjectRecognizer


class MainView(QWidget, RecognitionCallback):
    def __init__(self):
        super().__init__()

        self.setFixedWidth(1080)
        self.setFixedHeight(780)

        # Setup Phone Camera View
        self.phone_camera_view = QLabel()
        self.phone_camera_view.setFixedWidth(240)
        self.phone_camera_view.setFixedHeight(405)
        self.phone_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Computer Camera View
        self.web_camera_view = QLabel()
        self.web_camera_view.setFixedWidth(720)
        self.web_camera_view.setFixedHeight(405)
        self.web_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()
        self.acceleration_view.setFixedWidth(1080)
        self.acceleration_view.setFixedHeight(300)
        self.acceleration_view.setStyleSheet("QWidget {border: 5px solid #396EB0; border-radius: 3px;}")

        h_layout = QHBoxLayout()
        h_layout.addWidget(self.phone_camera_view, alignment=Qt.AlignLeft)
        h_layout.addWidget(self.web_camera_view, alignment=Qt.AlignTop)

        layout = QVBoxLayout(self)
        layout.addLayout(h_layout)
        layout.addWidget(self.acceleration_view, alignment=Qt.AlignBottom)

        # Create a capture timer to refresh web camera images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

        # Open web camera and start previewing
        self.web_camera = cv2.VideoCapture(0)
        self.capture_timer.start(1)

        # Start Face Recognition process
        self.face_recognizer = FaceRecognizer(self)
        self.face_recognizer.start()

        # Start Phone Camera Object Recognition process
        self.phone_camera_object_recognizer = ObjectRecognizer(self, "phone_camera")
        self.phone_camera_object_recognizer.start()

        # Start Web Camera Object Recognition process
        self.web_camera_object_recognizer = ObjectRecognizer(self, "web_camera")
        self.web_camera_object_recognizer.start()

        # Start Speech to Text process
        self.speech_recognizer = SpeechRecognizer(self)
        self.speech_recognizer.start()

        # Start OCR process
        self.text_recognizer = TextRecognizer(self)
        self.text_recognizer.start()

    def on_speech_recognized(self, extracted_text):
        pass

    def on_text_recognized(self, extracted_text):
        pass

    def on_face_recognized(self, recognized_image, known_student):
        pass

    def on_objects_recognized(self, recognized_objects, source):
        pass

    def closeEvent(self, event: QCloseEvent):
        # Stop all processes before closing the window
        self.speech_recognizer.is_recording = False
        self.face_recognizer.is_not_stopped = False
        self.text_recognizer.is_screenshotting = False
        self.web_camera_object_recognizer.is_not_stopped = False
        self.phone_camera_object_recognizer.is_not_stopped = False
        # Stop camera before closing the window
        self.capture_timer.stop()
        self.web_camera.release()

    def on_preview_frame(self):
        ret, frame = self.web_camera.read()
        frame = cv2.resize(frame, (self.web_camera_view.width(), self.web_camera_view.height()))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        pixmap = QPixmap.fromImage(image)
        self.web_camera_view.setPixmap(pixmap)
        self.web_camera_object_recognizer.frame = cv2.imencode('.jpg', frame)[1].tobytes()
        self.face_recognizer.frame = frame

    def update_phone_video(self, frame):
        self.web_camera_object_recognizer.frame = frame
        pixmap = QPixmap()
        pixmap.loadFromData(frame)
        self.phone_camera_view.setPixmap(pixmap.scaledToWidth(self.phone_camera_view.width()))

    def update_acceleration_view(self, acceleration):
        self.acceleration_view.populate_acceleration(acceleration)

    def set_acceleration_max_value(self, max_value):
        self.acceleration_view.set_max_value(max_value)
