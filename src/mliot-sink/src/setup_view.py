import re

from PySide6.QtCore import QTimer
from PySide6.QtGui import Qt, QPixmap
from PySide6.QtWidgets import QWidget, QLabel, QGridLayout, QLineEdit, QPushButton, QVBoxLayout, QHBoxLayout, QDialog

from callback.setup_callback import SinkSetupCallback
from ml_helper import MLHelper
from util.network_util import NetworkHelper, SINK_LISTENING_PORT


class InvigilatorView(QWidget):
    def __init__(self, monitor_connection_interface_callback: SinkSetupCallback):
        super().__init__()

        self.monitor_connection_interface_callback = monitor_connection_interface_callback

        header_label = QLabel("SETUP THE INVIGILATOR'S CONNECTION INTERFACE")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin-top: 25px; font-size: 18px; font-weight: bold")

        pixmap = QPixmap('resources/invigilator.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        image_view = QLabel()
        image_view.setAlignment(Qt.AlignCenter)
        image_view.setPixmap(pixmap)

        self.address_field = QLineEdit()
        self.address_field.setFixedWidth(200)
        self.address_field.setAlignment(Qt.AlignLeft)
        self.address_field.setPlaceholderText("10.0.0.71")
        address_label = QLabel("ADDRESS:")
        address_label.setBuddy(self.address_field)
        address_label.setAlignment(Qt.AlignRight)

        self.port_number_field = QLineEdit()
        self.port_number_field.setFixedWidth(200)
        self.port_number_field.setAlignment(Qt.AlignLeft)
        self.port_number_field.setPlaceholderText("1771")
        port_number_label = QLabel("PORT NUMBER:")
        port_number_label.setBuddy(self.port_number_field)
        port_number_label.setAlignment(Qt.AlignRight)

        next_button = QPushButton("NEXT")
        next_button.clicked.connect(self.next)

        grid_layout = QGridLayout(self)
        grid_layout.addWidget(header_label, 0, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(image_view, 1, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(address_label, 2, 0)
        grid_layout.addWidget(self.address_field, 2, 1)
        grid_layout.addWidget(port_number_label, 3, 0)
        grid_layout.addWidget(self.port_number_field, 3, 1)
        grid_layout.addWidget(next_button, 4, 1)

        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        if len(address) > 0 and len(port_number) > 0:
            self.address_field.setText(address)
            self.port_number_field.setText(port_number)

    def next(self):
        address_validator_regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"
        port_number_validator_regex = "^()([1-9]|[1-5]?[0-9]{2,4}|6[1-4][0-9]{3}|65[1-4][0-9]{2}|655[1-2][0-9]|6553[1-5])$"
        if re.search(address_validator_regex, self.address_field.text().strip()) and re.search(port_number_validator_regex, self.port_number_field.text().strip()):
            self.monitor_connection_interface_callback.on_monitor_connection_interface_set(self.address_field.text().strip(), self.port_number_field.text().strip())


class SensorsView(QWidget):
    def __init__(self, connection_interface_callback: SinkSetupCallback):
        super().__init__()

        self.connection_interface_callback = connection_interface_callback

        header_label = QLabel("LINK YOUR BODY DEVICES TO YOUR COMPUTER")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin :15px 10px 20px 10px; font-size: 18px; font-weight: bold")

        pixmap = QPixmap('resources/connection-config.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        image_view = QLabel()
        image_view.setAlignment(Qt.AlignCenter)
        image_view.setPixmap(pixmap)

        address_field = QLineEdit()
        address_field.setEnabled(False)
        address_field.setFixedWidth(200)
        address_field.setAlignment(Qt.AlignRight)
        address_field.setText(NetworkHelper.get_sink_listening_address())
        address_label = QLabel("COMPUTER'S ADDRESS")
        address_label.setBuddy(address_field)
        address_label.setAlignment(Qt.AlignRight)

        port_number_field = QLineEdit()
        port_number_field.setEnabled(False)
        port_number_field.setFixedWidth(200)
        port_number_field.setAlignment(Qt.AlignRight)
        port_number_field.setText(f"{SINK_LISTENING_PORT}")
        port_number_label = QLabel("COMPUTER'S PORT NUMBER")
        port_number_label.setBuddy(port_number_field)
        port_number_label.setAlignment(Qt.AlignRight)

        next_button = QPushButton("NEXT")
        next_button.clicked.connect(self.next)

        form_layout = QVBoxLayout()
        form_layout.addStretch()
        form_layout.addWidget(address_label)
        form_layout.addWidget(address_field)
        form_layout.addWidget(port_number_label)
        form_layout.addWidget(port_number_field)
        form_layout.addStretch()
        form_layout.addWidget(next_button)

        grid_layout = QGridLayout(self)
        grid_layout.addWidget(header_label, 0, 0, 1, 2)
        grid_layout.addWidget(image_view, 1, 0)
        grid_layout.addLayout(form_layout, 1, 1)

    def next(self):
        self.connection_interface_callback.on_sink_connection_interface_set()


class HandView(QWidget):
    def __init__(self, hand_device_callback: SinkSetupCallback):
        super().__init__()

        self.hand_device_callback = hand_device_callback

        header_label = QLabel("WEAR AND SETUP YOUR HAND DEVICE UNTIL THE NEXT BUTTON IS ACTIVE")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin-top: 25px; font-size: 18px; font-weight: bold")

        pixmap = QPixmap('resources/hand-config.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        hand_view = QLabel()
        hand_view.setAlignment(Qt.AlignCenter)
        hand_view.setPixmap(pixmap)

        pixmap = QPixmap('resources/wrist-pouch-setup.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        wrist_pouch_view = QLabel()
        wrist_pouch_view.setAlignment(Qt.AlignCenter)
        wrist_pouch_view.setPixmap(pixmap)

        self.next_button = QPushButton("NEXT")
        self.next_button.setEnabled(False)
        self.next_button.setFixedWidth(200)
        self.next_button.clicked.connect(self.next)

        vertical_layout = QVBoxLayout(self)
        vertical_layout.addWidget(header_label)
        vertical_layout.addStretch()
        horizontal_layout = QHBoxLayout()
        horizontal_layout.addWidget(hand_view)
        horizontal_layout.addWidget(wrist_pouch_view)
        vertical_layout.addLayout(horizontal_layout)
        vertical_layout.addStretch()
        vertical_layout.addWidget(self.next_button, alignment=Qt.AlignRight)

    def set_proximity(self, distance):
        if int(distance) == 0:
            self.next_button.setEnabled(True)
        else:
            self.next_button.setEnabled(False)

    def next(self):
        self.hand_device_callback.on_hand_device_set()


class HeadView(QWidget):

    def __init__(self, head_device_callback: SinkSetupCallback):
        super().__init__()

        self.head_device_callback = head_device_callback

        header_label = QLabel("WEAR AND SETUP YOUR HEAD DEVICE UNTIL THE NEXT BUTTON IS ACTIVE")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin-top: 25px; font-size: 18px; font-weight: bold")

        pixmap = QPixmap('resources/head-config.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        head_view = QLabel()
        head_view.setAlignment(Qt.AlignCenter)
        head_view.setPixmap(pixmap)

        pixmap = QPixmap('resources/front-phone-holder-setup.png')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        front_holder_view = QLabel()
        front_holder_view.setAlignment(Qt.AlignCenter)
        front_holder_view.setPixmap(pixmap)

        self.next_button = QPushButton("NEXT")
        #self.next_button.setEnabled(False)
        self.next_button.setFixedWidth(200)
        self.next_button.clicked.connect(self.next)

        vertical_layout = QVBoxLayout(self)
        vertical_layout.addWidget(header_label)
        vertical_layout.addStretch()
        horizontal_layout = QHBoxLayout()
        horizontal_layout.addWidget(head_view)
        horizontal_layout.addWidget(front_holder_view)
        vertical_layout.addLayout(horizontal_layout)
        vertical_layout.addStretch()
        vertical_layout.addWidget(self.next_button, alignment=Qt.AlignRight)

        self.test_text = "Bonjour"
        dialog_label = QLabel(self.test_text)
        dialog_label.setStyleSheet("font-size: 72px; font-weight: bold; color: black")
        dialog_layout = QHBoxLayout()
        dialog_layout.addWidget(dialog_label, alignment=Qt.AlignCenter)
        self.dialog = QDialog()
        self.dialog.setStyleSheet("background-color: white")
        self.dialog.setAttribute(Qt.WA_DeleteOnClose)
        self.dialog.setLayout(dialog_layout)

        self.calibration_timer = QTimer()
        self.calibration_timer.timeout.connect(self.apply_ocr)
        self.calibration_timer.start(5000)
        self.frame = None
        self.is_processing = False

    def new_frame(self, frame):
        self.frame = frame

    def apply_ocr(self):
        if not self.is_processing and self.frame is not None:
            self.is_processing = True
            recognized_objects, frame = MLHelper.recognize_object(self.frame)
            self.is_processing = False
            print(recognized_objects)

    def next(self):
        self.dialog.showFullScreen()
        #self.head_device_callback.on_head_device_set()
