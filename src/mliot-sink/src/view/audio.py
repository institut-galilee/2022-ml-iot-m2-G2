from PySide6 import QtCore, QtWidgets, QtGui


class AudioView(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.point_array = []
        self.waveform = None

        self.pen = QtGui.QPen(QtCore.Qt.white, 1, QtCore.Qt.SolidLine)

    def update_waveform(self, frame):
        self.waveform = frame
        self.update()

    def paintEvent(self, event):

        if self.waveform is not None:
            self.point_array.clear()

            for i in range(0, len(self.waveform) - 1):
                self.point_array.append(
                    QtCore.QLine(
                        int((self.width() * i) / (len(self.waveform) - 1)),
                        int((self.height() / 2.0) + (((self.waveform[i]) + 128.0 * (self.height() / 2.0)) / 128.0)),
                        int((self.width() * (i + 1.0)) / (len(self.waveform) - 1)),
                        int((self.height() / 2.0) + (((self.waveform[i + 1] + 128.0) * (self.height() / 2.0)) / 128.0))
                    )
                )
            qp = QtGui.QPainter()
            qp.begin(self)

            if len(self.point_array) > 0:
                qp.setPen(self.pen)
                qp.drawLines(self.point_array)
            qp.end()
