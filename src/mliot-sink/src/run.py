import asyncio
import json
import logging as logger
import ssl
import sys
import time
import urllib.request
import webbrowser

import gtts
from PySide6.QtGui import QScreen, QIcon, QCloseEvent
from PySide6.QtWidgets import QStackedWidget, QApplication, QMainWindow
from playsound import playsound

from callback.setup_callback import SinkSetupCallback
from common_pb2 import EmptyResponse
from main_view import MainView
from monitor_client import MonitorHelper
from setup_view import AuthenticationView, InvigilatorView
from setup_view import SensorsView, HandView, HeadView
from sink_pb2 import BoolResponse
from sink_pb2_grpc import SinkServiceServicer
from sink_server import Sink
from util.network_util import NetworkHelper


class MainWindow(QMainWindow, SinkServiceServicer, SinkSetupCallback):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("REMOTE PROCTORED EXAM")

        logger.basicConfig(level=logger.INFO)
        logger.info("Starting face recognition system…")

        # Views
        self.invigilator_view = InvigilatorView(self)
        # self.invigilator_view = None
        self.authentication_view = None
        self.sensors_view = None
        self.hand_view = None
        self.head_view = None
        self.main_view = None
        # self.main_view = MainView("")

        self.content_view = QStackedWidget()
        self.setCentralWidget(self.content_view)
        # self.content_view.addWidget(self.main_view)
        self.content_view.addWidget(self.invigilator_view)

        # Setup gRPC Sink server
        self.sink = Sink(self)
        self.sink.start()

        self.setup_is_ongoing = True
        # self.setup_is_ongoing = False

        # Exam & API URLs
        self.exam_url = None
        self.api_url = None

        # Current student
        self.current_student = None

        # Exam content
        self.api_content = None

    def center_window(self):
        # Center the window
        center = QScreen.availableGeometry(QApplication.primaryScreen()).center()
        geometry = self.frameGeometry()
        geometry.moveCenter(center)
        self.move(geometry.topLeft())

    def closeEvent(self, event: QCloseEvent):
        if self.current_student is not None:
            asyncio.run(MonitorHelper.disconnect_student(self.current_student.card_number))
        self.sink.shut_down()
        for i in range(0, self.content_view.count()):
            self.content_view.widget(i).close()

    def on_head_device_set(self):
        self.exam_url, self.api_url = MonitorHelper.connect_student(self.current_student.card_number)
        if self.exam_url is not None and self.exam_url is not None:
            context = ssl._create_unverified_context()
            content = urllib.request.urlopen(self.api_url, context=context).read()
            self.api_content = json.loads(content)
            webbrowser.open(self.exam_url)
            self.main_view = MainView(self.current_student, self.api_content)
            self.content_view.addWidget(self.main_view)
            self.content_view.setCurrentWidget(self.main_view)
            self.center_window()
            self.setup_is_ongoing = False
        else:
            self.close()

    def on_hand_device_set(self):
        self.head_view = HeadView(self)
        self.content_view.addWidget(self.head_view)
        self.content_view.setCurrentWidget(self.head_view)
        self.center_window()

    def on_student_recognized(self, student):
        tts = gtts.gTTS(f"Bonjour {student.first_name} {student.last_name}", lang="fr")
        tts.save("greeting.mp3")
        playsound("greeting.mp3")
        self.current_student = student
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

    def onMonitorFeedbackAvailable(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.speech_recognizer.is_suspended = True
            time.sleep(5)
            tts = gtts.gTTS(request.message, lang="fr")
            tts.save("warning.mp3")
            playsound("warning.mp3")
            self.main_view.speech_recognizer.is_suspended = False
        return EmptyResponse()

    def onVideoFrameAvailable(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.update_phone_video(request.video_frame)
        elif self.setup_is_ongoing and self.head_view is not None and self.head_view.isVisible():
            self.head_view.new_frame(request.video_frame)
        return EmptyResponse()

    def onAccelerationChanged(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.update_acceleration_view(request)
            return BoolResponse(is_received=self.main_view.acceleration_view.max_range is not None)
        elif self.setup_is_ongoing:
            return BoolResponse(is_received=True)

    def setAccelerationMaxRange(self, request, context):
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible():
            self.main_view.set_acceleration_max_value(request.max_range)
        return EmptyResponse()

    def onStepDetected(self, request, context):
        logger.info(f"Un pas a été detecté")
        return EmptyResponse()

    def onProximityChanged(self, request, context):
        if self.setup_is_ongoing and self.hand_view is not None and self.hand_view.isVisible():
            self.hand_view.set_proximity(request.distance)
        if not self.setup_is_ongoing and self.main_view is not None and self.main_view.isVisible() and self.current_student is not None:
            if request.distance > 0.0:
                message = f"{self.current_student.first_name} {self.current_student.last_name} ne porte plus son hand device."
                asyncio.run(MonitorHelper.hand_device_state_changed(self.current_student.card_number, message))
            else:
                message = f"{self.current_student.first_name} {self.current_student.last_name} met à nouveau son hand device."
                asyncio.run(MonitorHelper.hand_device_state_changed(self.current_student.card_number, message))
        return EmptyResponse()

    def onHeartRateChanged(self, request, context):
        logger.info(f"Le rythme cardiaque est à {request.heart_rate}")
        return EmptyResponse()

    def onMotionDetected(self, request, context):
        if self.current_student is not None:
            message = f"{self.current_student.first_name} {self.current_student.last_name} semble être en mouvement."
            asyncio.run(MonitorHelper.motion_detected(self.current_student.card_number, message))
        return EmptyResponse()

    def onTemperatureChanged(self, request, context):
        logger.info(f"La température ambiente est à {request.degrees}°C")
        return EmptyResponse()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    app.setWindowIcon(QIcon("resources/logo.png"))
    window = MainWindow()
    window.show()
    window.center_window()
    sys.exit(app.exec())
