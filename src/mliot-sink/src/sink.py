import sys

from PySide6 import QtCore, QtWidgets
from PySide6.QtGui import QPixmap

import sink_pb2
import sink_pb2_grpc
from network import NetworkHelper
from server import Server
from view.acc import AccelerationView
from view.audio import AudioView
from PIL import Image


class MainWindow(QtWidgets.QWidget, sink_pb2_grpc.SinkServiceServicer):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE SAFE EXAM")

        # Show IP Address and Port
        ip_port = QtWidgets.QLabel("IP ADDRESS: {0}".format(NetworkHelper.listening_port()))
        ip_address = QtWidgets.QLabel("PORT NUMBER: {0}".format(NetworkHelper.listening_address()))

        # Setup Audio View
        self.audio_view = AudioView()

        # Setup Video View
        self.video_view = QtWidgets.QLabel()
        self.video_view.setAlignment(QtCore.Qt.AlignLeft)

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()

        h1_layout = QtWidgets.QHBoxLayout()
        h1_layout.addWidget(ip_address)
        h1_layout.addWidget(ip_port)
        h1_layout.setAlignment(QtCore.Qt.AlignTop)

        v1_layout = QtWidgets.QVBoxLayout()
        v1_layout.addWidget(self.audio_view)
        v1_layout.addWidget(self.acceleration_view)

        h2_layout = QtWidgets.QHBoxLayout()
        h2_layout.addWidget(self.video_view)
        h2_layout.addLayout(v1_layout)

        v2_layout = QtWidgets.QVBoxLayout(self)
        v2_layout.addLayout(h1_layout)
        v2_layout.addLayout(h2_layout)

        # Setup gRPC Server
        self.server = Server(self)
        self.server.start()

    def close(self):
        self.server.stop()

    def onAudioFrameAvailable(self, request, context):
        self.audio_view.update_waveform(request.audio_frame)
        return sink_pb2.Response(received=True)

    def onVideoFrameAvailable(self, request, context):
        image = QPixmap()
        image.loadFromData(request.video_frame)
        self.video_view.setPixmap(image.scaled(320, 480))
        return sink_pb2.Response(received=True)

    def onAccelerationValuesChanged(self, request, context):
        self.acceleration_view.populate_acceleration(request)
        return sink_pb2.Response(received=self.acceleration_view.max_range is not None)

    def setAccelerationMaxRange(self, request, context):
        self.acceleration_view.max_range = request.max_range
        return sink_pb2.Response(received=True)


if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    window = MainWindow()
    window.setFixedWidth(720)
    window.setFixedHeight(480)
    window.show()
    sys.exit(app.exec())
