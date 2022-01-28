from PySide6.QtGui import Qt
import re
from PySide6.QtWidgets import QWidget, QLabel, QGridLayout, QLineEdit, QPushButton

from callback.setup_callback import SinkSetupCallback
from src.util.network_util import NetworkHelper


class MonitorView(QWidget):
    def __init__(self, connection_interface_callback: SinkSetupCallback):
        super().__init__()

        self.connection_interface_callback = connection_interface_callback

        header_label = QLabel("SETUP THE INVIGILATOR'S CONNECTION INTERFACE")
        header_label.setAlignment(Qt.AlignCenter)
        header_label.setStyleSheet("margin :15px 10px 20px 10px")

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
        grid_layout.addWidget(address_label, 1, 0)
        grid_layout.addWidget(self.address_field, 1, 1)
        grid_layout.addWidget(port_number_label, 2, 0)
        grid_layout.addWidget(self.port_number_field, 2, 1)
        grid_layout.addWidget(next_button, 3, 0, 1, 2)

        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        if len(address) > 0 and len(port_number) > 0:
            self.address_field.setText(address)
            self.port_number_field.setText(port_number)

    def next(self):
        address_validator_regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"
        port_number_validator_regex = "^()([1-9]|[1-5]?[0-9]{2,4}|6[1-4][0-9]{3}|65[1-4][0-9]{2}|655[1-2][0-9]|6553[1-5])$"
        if re.search(address_validator_regex, self.address_field.text().strip()) and re.search(port_number_validator_regex, self.port_number_field.text().strip()):
            self.connection_interface_callback.on_connection_interface_set(self.address_field.text().strip(), self.port_number_field.text().strip())
