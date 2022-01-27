import sys

from PySide6 import QtCore, QtWidgets
from PySide6.QtGui import QPixmap

from generated import sink_pb2, sink_pb2_grpc
from impl.sink import Sink
from util.network import NetworkHelper
from view.acc import AccelerationView
from view.audio import AudioView


class MainWindow(QtWidgets.QMainWindow, sink_pb2_grpc.SinkServiceServicer):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE SAFE EXAM")

        # Show IP Address and Port
        ip_port = QtWidgets.QLabel("PORT NUMBER: {0}".format(NetworkHelper.listening_port()))
        ip_address = QtWidgets.QLabel("IP ADDRESS: {0}".format(NetworkHelper.listening_address()))

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

        v2_layout = QtWidgets.QVBoxLayout()
        v2_layout.addLayout(h1_layout)
        v2_layout.addLayout(h2_layout)

        # Add all views to the window
        widget = QtWidgets.QWidget()
        widget.setLayout(v2_layout)
        self.setCentralWidget(widget)

        # Setup gRPC Sink
        self.sink = Sink(self)
        self.sink.start()

    def close(self):
        self.sink.stop()

    def onAudioFrameAvailable(self, request, context):
        self.audio_view.update_waveform(request.audio_frame)
        return sink_pb2.Response(is_received=True)

    def onVideoFrameAvailable(self, request, context):
        image = QPixmap()
        image.loadFromData(request.video_frame)
        self.video_view.setPixmap(image.scaled(480, 720))
        return sink_pb2.Response(is_received=True)

    def onAccelerationChanged(self, request, context):
        self.acceleration_view.populate_acceleration(request)
        return sink_pb2.Response(is_received=self.acceleration_view.max_range is not None)

    def setAccelerationMaxRange(self, request, context):
        self.acceleration_view.max_range = request.max_range
        return sink_pb2.Response(is_received=True)

    def onStepDetected(self, request, context):
        print("Un pas a été detecté")
        return sink_pb2.Response(is_received=True)

    def onProximityChanged(self, request, context):
        print("La proximité est estimé à {0} cm".format(request.distance))
        return sink_pb2.Response(is_received=True)

    def onHeartRateChanged(self, request, context):
        print(request.heart_rate)
        return sink_pb2.Response(is_received=True)

    def onMotionDetected(self, request, context):
        print("Mouvement detecté")
        return sink_pb2.Response(is_received=True)

    def onTemperatureChanged(self, request, context):
        print(request.degrees)
        return sink_pb2.Response(is_received=True)


if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    window = MainWindow()
    window.setFixedWidth(1280)
    window.setFixedHeight(720)
    window.show()
    sys.exit(app.exec())
