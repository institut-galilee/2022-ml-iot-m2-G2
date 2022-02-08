import cv2
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, Qt
from PySide6.QtWidgets import QWidget, QHBoxLayout, QVBoxLayout

from callback.recognition_callback import RecognitionCallback
from camera_view import WebCameraView, PhoneCameraView
from src.acceleration_view import AccelerationView
from audio_view import AudioView


class MainView(QWidget, RecognitionCallback):
    def __init__(self):
        super().__init__()

        self.setFixedWidth(1080)
        self.setFixedHeight(960)

        # Setup Audio View
        self.audio_view = AudioView(self)
        self.audio_view.setFixedWidth(640)
        self.audio_view.setFixedHeight(240)
        self.audio_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")
        self.audio_view.start()

        # Setup Phone Camera View
        self.phone_camera_view = PhoneCameraView()
        self.phone_camera_view.setFixedWidth(380)
        self.phone_camera_view.setFixedHeight(560)
        self.phone_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Computer Camera View
        self.web_camera_view = WebCameraView()
        self.web_camera_view.setFixedWidth(640)
        self.web_camera_view.setFixedHeight(360)
        self.web_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()
        self.acceleration_view.setFixedWidth(1080)
        self.acceleration_view.setFixedHeight(360)
        self.acceleration_view.setStyleSheet("QWidget {border: 5px solid #396EB0; border-radius: 3px;}")

        v_layout = QVBoxLayout()
        v_layout.addWidget(self.web_camera_view, alignment=Qt.AlignRight)
        v_layout.addWidget(self.audio_view, alignment=Qt.AlignRight)

        h_layout = QHBoxLayout()
        h_layout.addWidget(self.phone_camera_view, alignment=Qt.AlignLeft)
        h_layout.addLayout(v_layout)

        layout = QVBoxLayout(self)
        layout.addLayout(h_layout)
        layout.addWidget(self.acceleration_view)

    def on_speech_recognized(self, extracted_text):
        print(extracted_text)

    def closeEvent(self, event: QCloseEvent):
        self.audio_view.close()
        self.web_camera_view.close()
        self.phone_camera_view.close()

    def on_preview_frame(self):
        ret, frame = self.video_capture.read()
        frame = cv2.resize(frame, (self.web_camera_view.width(), self.web_camera_view.height()))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        pixmap = QPixmap.fromImage(image)
        self.web_camera_view.update_image(pixmap)

    def update_phone_video(self, frame):
        self.phone_camera_view.update_frame(frame)

    def update_audio_waveform(self, frame):
        self.audio_view.update_waveform(frame)

    def update_acceleration_view(self, acceleration):
        self.acceleration_view.populate_acceleration(acceleration)

    def set_acceleration_max_value(self, max_value):
        self.acceleration_view.set_max_value(max_value)
