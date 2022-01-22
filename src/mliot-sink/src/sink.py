import sys
import grpc
import random
import socket
import asyncio
import sink_pb2
import sink_pb2_grpc
from concurrent import futures
from PySide6 import QtCore, QtWidgets, QtGui


class ServiceListener(sink_pb2_grpc.SinkServiceServicer):
    def SendAudio(self, request, context):
        print(request)
        return sink_pb2.Response(received=True)

    def SendVideo(self, request, context):
        print(request)
        return sink_pb2.Response(received=True)

    def SendAcceleration(self, request, context):
        print(request.x)
        return sink_pb2.Response(received=True)


async def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    sink_pb2_grpc.add_SinkServiceServicer_to_server(ServiceListener(), server)
    server.add_insecure_port("localhost:7117")
    print('Server is running on port 7117')
    server.start()
    server.wait_for_termination()


class MyWidget(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.hello = ["Hallo Welt", "Hei maailma", "Hola Mundo", "Привет мир"]

        self.button = QtWidgets.QPushButton("Click me!")
        socket_instance = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        socket_instance.settimeout(0)
        try:
            socket_instance.connect(("google.com", 443))
            ip_address = socket_instance.getsockname()[0]
            self.ip_text = QtWidgets.QLabel(ip_address, alignment=QtCore.Qt.AlignTop)
        except Exception:
            self.ip_text = QtWidgets.QLabel("Not connected", alignment=QtCore.Qt.AlignTop)
        finally:
            socket_instance.close()
        self.text = QtWidgets.QLabel("Hello World", alignment=QtCore.Qt.AlignCenter)
        self.layout = QtWidgets.QVBoxLayout(self)
        self.layout.addWidget(self.ip_text)
        self.layout.addWidget(self.text)
        self.layout.addWidget(self.button)

        self.button.clicked.connect(self.magic)

        asyncio.run(serve())

    @QtCore.Slot()
    def magic(self):
        self.text.setText(random.choice(self.hello))


if __name__ == "__main__":
    app = QtWidgets.QApplication([])
    widget = MyWidget()
    widget.resize(400, 800)
    widget.show()
    sys.exit(app.exec())
