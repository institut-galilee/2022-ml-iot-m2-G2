import sys

from PySide6 import QtCore, QtWidgets

import sink_pb2
import sink_pb2_grpc
from network import NetworkHelper
from server import Server
from view.acc import AccelerationView
from view.audio import AudioView


class MainWindow(QtWidgets.QWidget, sink_pb2_grpc.SinkServiceServicer):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE SAFE EXAM")

        self.button = QtWidgets.QPushButton("Click me!")
        self.ip_text = QtWidgets.QLabel(
            "{0}:{1}".format(NetworkHelper.listening_address(), NetworkHelper.listening_port()),
            alignment=QtCore.Qt.AlignTop)
        self.text = QtWidgets.QLabel("Hello World", alignment=QtCore.Qt.AlignCenter)

        self.audio_view = AudioView()
        self.acceleration_view = AccelerationView()
        self.layout = QtWidgets.QVBoxLayout(self)
        self.layout.addWidget(self.ip_text)
        self.layout.addWidget(self.text)
        self.layout.addWidget(self.button)
        self.layout.addWidget(self.audio_view)
        self.layout.addWidget(self.acceleration_view)

        self.button.clicked.connect(self.magic)
        self.server = Server(self)
        self.server.start()

    @QtCore.Slot()
    def magic(self):
        self.text.setText("random.choice(self.hello)")

    def close(self):
        self.server.stop()

    def onAudioFrameAvailable(self, request, context):
        self.audio_view.update_waveform(request.audio_frame)
        return sink_pb2.Response(received=True)

    def onVideoFrameAvailable(self, request, context):
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
    window.resize(800, 600)
    window.show()
    sys.exit(app.exec())
