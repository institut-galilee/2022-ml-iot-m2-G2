import sys

import PySide6
from PySide6.QtGui import QPixmap, QScreen, QIcon
from PySide6.QtWidgets import QStackedWidget, QApplication, QLabel, QMainWindow

from callback.setup_callback import SinkSetupCallback
from main_view import MainView
from setup_view import AuthenticationView
from setup_view import SensorsView, HandView, HeadView
from sink_pb2 import Response
from sink_pb2_grpc import SinkServiceServicer
from sink_server import Sink
from util.network_util import NetworkHelper, SINK_LISTENING_PORT


class MainWindow(QMainWindow, SinkServiceServicer, SinkSetupCallback):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE PROCTORED EXAM")

        # Show IP Address and Port
        ip_port = QLabel("PORT NUMBER: {0}".format(SINK_LISTENING_PORT))
        ip_address = QLabel("IP ADDRESS: {0}".format(NetworkHelper.get_sink_listening_address()))

        # Views
        #self.invigilator_view = InvigilatorView(self)
        self.invigilator_view = None
        self.authentication_view = None
        self.sensors_view = None
        self.hand_view = None
        self.head_view = None
        self.main_view = MainView()

        self.content_view = QStackedWidget()
        self.setCentralWidget(self.content_view)
        self.content_view.addWidget(self.main_view)
        #self.content_view.addWidget(self.invigilator_view)

        # Setup gRPC Sink server
        self.sink = Sink(self)
        self.sink.start()

        #self.setup_is_ongoing = True
        self.setup_is_ongoing = False

    def center_window(self):
        # Center the window
        center = QScreen.availableGeometry(QApplication.primaryScreen()).center()
        geometry = self.frameGeometry()
        geometry.moveCenter(center)
        self.move(geometry.topLeft())

    def closeEvent(self, event: PySide6.QtGui.QCloseEvent):
        self.sink.shut_down()
        for i in range(0, self.content_view.count()):
            self.content_view.widget(i).close()

    def on_head_device_set(self):
        self.main_view = MainView()
        self.content_view.addWidget(self.main_view)
        self.content_view.setCurrentWidget(self.main_view)
        self.center_window()
        self.setup_is_ongoing = False

    def on_hand_device_set(self):
        self.head_view = HeadView(self)
        self.content_view.addWidget(self.head_view)
        self.content_view.setCurrentWidget(self.head_view)
        self.center_window()

    def on_student_recognized(self, student):
        self.authentication_view.close()
        self.sensors_view = SensorsView(self)
        self.content_view.addWidget(self.sensors_view)
        self.content_view.setCurrentWidget(self.sensors_view)
        self.center_window()

    def on_monitor_connection_interface_set(self, address, port):
        NetworkHelper.set_monitor_listening_connection_interface(address, port)
        self.authentication_view = AuthenticationView(self)
        self.content_view.addWidget(self.authentication_view)
        self.content_view.setCurrentWidget(self.authentication_view)
        self.center_window()

    def on_sink_connection_interface_set(self):
        self.hand_view = HandView(self)
        self.content_view.addWidget(self.hand_view)
        self.content_view.setCurrentWidget(self.hand_view)
        self.center_window()

    def onVideoFrameAvailable(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.update_phone_video(request.video_frame)
        elif self.setup_is_ongoing and self.head_view is not None and self.head_view.isVisible():
            self.head_view.new_frame(request.video_frame)
        return Response(is_received=True)

    def onAccelerationChanged(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.update_acceleration_view(request)
            return Response(is_received=self.main_view.acceleration_view.max_range is not None)
        elif self.setup_is_ongoing:
            return Response(is_received=True)

    def setAccelerationMaxRange(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.set_acceleration_max_value(request.max_range)
        return Response(is_received=True)

    def onStepDetected(self, request, context):
        print("Un pas a été detecté")
        return Response(is_received=True)

    def onProximityChanged(self, request, context):
        if self.setup_is_ongoing and self.hand_view is not None and self.hand_view.isVisible():
            self.hand_view.set_proximity(request.distance)
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
    app = QApplication(sys.argv)
    app.setWindowIcon(QIcon("resources/logo.png"))
    window = MainWindow()
    window.show()
    window.center_window()
    sys.exit(app.exec())
