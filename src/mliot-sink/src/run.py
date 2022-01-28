import sys
import time

import PySide6
from PySide6 import QtCore, QtWidgets
from PySide6.QtGui import QPixmap
from PySide6.QtWidgets import QStackedWidget

from callback.setup_callback import SinkSetupCallback
from sink_pb2 import Response
from sink_pb2_grpc import SinkServiceServicer
from sink_server import Sink
from src.recogninizer_view import RecognizerView
from setup_view import MonitorView
from util.network_util import NetworkHelper, SINK_LISTENING_PORT
from view.acceleration_view import AccelerationView
from view.audio_view import AudioView


class MainWindow(QtWidgets.QMainWindow, SinkServiceServicer, SinkSetupCallback):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE SAFE EXAM")

        # Show IP Address and Port
        ip_port = QtWidgets.QLabel("PORT NUMBER: {0}".format(SINK_LISTENING_PORT))
        ip_address = QtWidgets.QLabel("IP ADDRESS: {0}".format(NetworkHelper.get_sink_listening_address()))

        # Setup Audio View
        self.audio_view = AudioView()

        # Setup Video View
        #self.video_view = QtWidgets.QLabel()
        self.recognizer_view = None
        self.monitor_view = MonitorView(self)
        #self.video_view.setAlignment(QtCore.Qt.AlignLeft)

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()

        self.content_view = QStackedWidget()
        self.setCentralWidget(self.content_view)
        self.content_view.addWidget(self.monitor_view)

        h1_layout = QtWidgets.QHBoxLayout()
        h1_layout.addWidget(ip_address)
        h1_layout.addWidget(ip_port)
        h1_layout.setAlignment(QtCore.Qt.AlignTop)

        v1_layout = QtWidgets.QVBoxLayout()
        v1_layout.addWidget(self.audio_view)
        v1_layout.addWidget(self.acceleration_view)

        h2_layout = QtWidgets.QHBoxLayout()
        #h2_layout.addWidget(self.video_view)
        h2_layout.addLayout(v1_layout)

        v2_layout = QtWidgets.QVBoxLayout()
        v2_layout.addLayout(h1_layout)
        v2_layout.addLayout(h2_layout)

        # Add all views to the window
        widget = QtWidgets.QWidget()
        widget.setLayout(v2_layout)
        #self.setCentralWidget(widget)

        # Setup gRPC Sink
        self.sink = Sink(self)
        self.sink.start()

    def closeEvent(self, event: PySide6.QtGui.QCloseEvent):
        self.sink.shut_down()

    def on_student_recognized(self, student):
        print(student)

    def on_connection_interface_set(self, address, port):
        NetworkHelper.set_monitor_listening_connection_interface(address, port)
        self.recognizer_view = RecognizerView(self)
        self.content_view.addWidget(self.recognizer_view)
        self.content_view.setCurrentWidget(self.recognizer_view)

    def onAudioFrameAvailable(self, request, context):
        self.audio_view.update_waveform(request.audio_frame)
        return Response(is_received=True)

    def onVideoFrameAvailable(self, request, context):
        image = QPixmap()
        image.loadFromData(request.video_frame)
        self.video_view.setPixmap(image.scaled(480, 720))
        return Response(is_received=True)

    def onAccelerationChanged(self, request, context):
        self.acceleration_view.populate_acceleration(request)
        return Response(is_received=self.acceleration_view.max_range is not None)

    def setAccelerationMaxRange(self, request, context):
        self.acceleration_view.max_range = request.max_range
        return Response(is_received=True)

    def onStepDetected(self, request, context):
        print("Un pas a été detecté")
        return Response(is_received=True)

    def onProximityChanged(self, request, context):
        print("La proximité est estimé à {0} cm".format(request.distance))
        return Response(is_received=True)

    def onHeartRateChanged(self, request, context):
        print(request.heart_rate)
        return Response(is_received=True)

    def onMotionDetected(self, request, context):
        print("Mouvement detecté")
        return Response(is_received=True)

    def onTemperatureChanged(self, request, context):
        print(request.degrees)
        return Response(is_received=True)


if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    window = MainWindow()
    #window.setFixedWidth(720)
    #window.setFixedHeight(720)
    window.show()
    sys.exit(app.exec())
