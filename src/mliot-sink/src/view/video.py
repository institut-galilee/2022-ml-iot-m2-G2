from PySide6 import QtCore, QtWidgets, QtGui


class AudioView(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.point_array = []
        self.frame = None

    def update_frame(self, frame):
        self.frame = frame
        self.update()

    def paintEvent(self, event):

        if self.frame is not None:
            self.point_array.clear()

            for i in range(0, len(self.frame) - 1):
                print(self.frame[i])
                self.point_array.append(
                    QtCore.QLine(
                        int((self.width() * i) / (len(self.frame) - 1)),
                        int((self.height() / 2.0) + (((int.to_bytes(self.frame[i]) + 128.0) * (self.height() / 2.0)) / 128.0)),
                        int((self.width() * (i + 1.0)) / (len(self.frame) - 1)),
                        int((self.height() / 2.0) + (((int.to_bytes(self.frame[i + 1]) + 128.0) * (self.height() / 2.0)) / 128.0))
                    )
                )
            qp = QtGui.QPainter()
            qp.begin(self)
            qp = QtGui.QPixmap()
            qp.loadFromData(self.frame)
            qp.end()
