import re

from PySide6.QtGui import Qt, QPixmap
from PySide6.QtWidgets import QWidget, QLabel, QGridLayout, QLineEdit, QPushButton, QVBoxLayout

from callback.setup_callback import SinkSetupCallback
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

        pixmap = QPixmap('resources/sensors-config-screenshot.png')
        pixmap = pixmap.scaled(720, 720, Qt.KeepAspectRatio)
        image_view = QLabel()
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
    def __init__(self, arm_device_callback: SinkSetupCallback):
        super().__init__()

        self.arm_device_callback = arm_device_callback

        header_label = QLabel("WEAR AND SETUP YOUR HAND DEVICE")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin-top: 25px; font-size: 18px; font-weight: bold")

        pixmap = QPixmap('resources/arm.jpg')
        pixmap = pixmap.scaled(480, 480, Qt.KeepAspectRatio)
        image_view = QLabel()
        image_view.setAlignment(Qt.AlignCenter)
        image_view.setPixmap(pixmap)

        address_label = QLabel("OPEN HAND DEVICE AND WAIT UNTIL THE NEXT BUTTON IS ACTIVE.")
        address_label.setAlignment(Qt.AlignCenter)

        self.next_button = QPushButton("NEXT")
        self.next_button.setEnabled(False)
        self.next_button.setFixedWidth(200)
        self.next_button.clicked.connect(self.next)

        grid_layout = QGridLayout(self)
        grid_layout.addWidget(header_label, 0, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(image_view, 1, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(address_label, 2, 0, 1, 2)
        grid_layout.setRowStretch(1, 10)
        grid_layout.addWidget(self.next_button, 4, 1)

    def set_proximity(self, distance):
        if int(distance) == 0:
            self.next_button.setEnabled(True)
        else:
            self.next_button.setEnabled(False)

    def next(self):
        self.arm_device_callback.on_arm_device_set()
