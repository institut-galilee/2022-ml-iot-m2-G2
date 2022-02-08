import cv2
from PySide6.QtCore import QTimer
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, Qt
from PySide6.QtWidgets import QWidget, QHBoxLayout, QVBoxLayout

from view.acceleration_view import AccelerationView
from view.audio_view import AudioView
from view.video_view import VideoView


class MainView(QWidget):
    def __init__(self):
        super().__init__()

        self.setFixedWidth(1080)
        self.setFixedHeight(960)

        # Setup Audio View
        self.audio_view = AudioView()
        self.audio_view.setFixedWidth(640)
        self.audio_view.setFixedHeight(240)
        self.audio_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Phone Video View
        self.phone_video_view = VideoView()
        self.phone_video_view.setFixedWidth(380)
        self.phone_video_view.setFixedHeight(560)
        self.phone_video_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Computer Video View
        self.computer_video_view = VideoView()
        self.computer_video_view.setFixedWidth(640)
        self.computer_video_view.setFixedHeight(360)
        self.computer_video_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()
        self.acceleration_view.setFixedWidth(1080)
        self.acceleration_view.setFixedHeight(360)
        self.acceleration_view.setStyleSheet("QWidget {border: 5px solid #396EB0; border-radius: 3px;}")

        v_layout = QVBoxLayout()
        v_layout.addWidget(self.computer_video_view, alignment=Qt.AlignRight)
        v_layout.addWidget(self.audio_view, alignment=Qt.AlignRight)

        h_layout = QHBoxLayout()
        h_layout.addWidget(self.phone_video_view, alignment=Qt.AlignLeft)
        h_layout.addLayout(v_layout)

        layout = QVBoxLayout(self)
        layout.addLayout(h_layout)
        layout.addWidget(self.acceleration_view)

        # Create a capture timer to refresh images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

        self.video_capture = cv2.VideoCapture(0)
        self.capture_timer.start(1)

    def closeEvent(self, event: QCloseEvent):
        self.stop_recognition()

    def stop_recognition(self):
        self.capture_timer.stop()
        self.video_capture.release()

    def on_preview_frame(self):
        ret, frame = self.video_capture.read()
        frame = cv2.resize(frame, (self.computer_video_view.width(), self.computer_video_view.height()))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        pixmap = QPixmap.fromImage(image)
        self.computer_video_view.update_image(pixmap)

    def update_phone_video(self, frame):
        self.phone_video_view.update_frame(frame)

    def update_computer_video(self, pixmap):
        self.computer_video_view.update_image(pixmap)

    def update_audio_waveform(self, frame):
        self.audio_view.update_waveform(frame)

    def update_acceleration_view(self, acceleration):
        self.acceleration_view.populate_acceleration(acceleration)

    def set_acceleration_max_value(self, max_value):
        self.acceleration_view.set_max_value(max_value)
