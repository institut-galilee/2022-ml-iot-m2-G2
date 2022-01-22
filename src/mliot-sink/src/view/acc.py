from PySide6 import QtCore, QtWidgets, QtGui


class AccelerationView(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()

        self.x_points = []
        self.y_points = []
        self.z_points = []

        self.list = []
        self.MAX_ITEM = 50
        self.max_range = None

        self.x_pen = QtGui.QPen(QtCore.Qt.blue, 1, QtCore.Qt.SolidLine)
        self.y_pen = QtGui.QPen(QtCore.Qt.yellow, 1, QtCore.Qt.SolidLine)
        self.z_pen = QtGui.QPen(QtCore.Qt.white, 1, QtCore.Qt.SolidLine)

    def populate_acceleration(self, acceleration):
        if len(self.list) == self.MAX_ITEM:
            self.list.pop(0)
        self.list.append(acceleration)
        self.update()

    def set_max_value(self, max_value):
        self.max_range = max_value

    def paintEvent(self, event):

        if self.max_range is not None:
            self.x_points.clear()
            self.y_points.clear()
            self.z_points.clear()

            for i in range(0, len(self.list) - 1):
                self.x_points.append(
                    QtCore.QLine(
                        int((self.width() * i) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i].x * self.height() * 2.0) / self.max_range)),
                        int((self.width() * (i + 1.0)) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i + 1].x * self.height() * 2.0) / self.max_range))
                    )
                )
                self.y_points.append(
                    QtCore.QLine(
                        int((self.width() * i) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i].y * self.height() * 2.0) / self.max_range)),
                        int((self.width() * (i + 1.0)) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i + 1].y * self.height() * 2.0) / self.max_range))
                    )
                )
                self.z_points.append(
                    QtCore.QLine(
                        int((self.width() * i) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i].z * self.height() * 2.0) / self.max_range)),
                        int((self.width() * (i + 1.0)) / (len(self.list) - 1.0)),
                        int((self.height() / 2.0) + ((self.list[i + 1].z * self.height() * 2.0) / self.max_range))
                    )
                )
            qp = QtGui.QPainter()
            qp.begin(self)

            if min(len(self.x_points), len(self.y_points), len(self.z_points)) > 0:
                print(self.x_points)
                qp.setPen(self.x_pen)
                qp.drawLines(self.x_points)

                qp.setPen(self.y_pen)
                qp.drawLines(self.y_points)

                qp.setPen(self.z_pen)
                qp.drawLines(self.z_points)
            qp.end()
