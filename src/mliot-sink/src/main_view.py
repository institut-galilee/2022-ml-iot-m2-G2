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
        self.audio_view.setFixedWidth(480)
        self.audio_view.setFixedHeight(240)
        self.audio_view.setStyleSheet("background-color: blue")

        # Setup Phone Video View
        self.phone_video_view = VideoView()
        self.phone_video_view.setFixedWidth(480)
        self.phone_video_view.setFixedHeight(720)
        self.phone_video_view.setStyleSheet("background-color: #F0F")

        # Setup Computer Video View
        self.computer_video_view = VideoView()
        self.computer_video_view.setFixedWidth(480)
        self.computer_video_view.setFixedHeight(480)
        self.computer_video_view.setStyleSheet("background-color: red")

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()
        self.acceleration_view.setFixedWidth(1080)
        self.acceleration_view.setFixedHeight(240)
        self.acceleration_view.setStyleSheet("background-color: #0F0")

        v_layout = QVBoxLayout()
        v_layout.addWidget(self.computer_video_view)
        v_layout.addWidget(self.audio_view)

        h_layout = QHBoxLayout()
        h_layout.addWidget(self.phone_video_view)
        h_layout.addLayout(v_layout)

        layout = QVBoxLayout(self)
        layout.addLayout(h_layout)
        layout.addWidget(self.acceleration_view)

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
