from PySide6.QtCore import QLine, QPointF
from PySide6.QtGui import QFont, QPen, QColor, Qt, QPainter
from PySide6.QtWidgets import QWidget


class AccelerationView(QWidget):
    def __init__(self):
        super().__init__()

        self.x_points = []
        self.y_points = []
        self.z_points = []

        self.list_acceleration = []
        self.MAX_ITEM = 500
        self.max_range = None

        self.qf = QFont()
        self.qf.setPointSize(5)

        self.x_pen = QPen(QColor(135, 100, 69, 255), 1, Qt.SolidLine)
        self.y_pen = QPen(QColor(23, 0, 85, 255), 1, Qt.SolidLine)
        self.z_pen = QPen(QColor(121, 0, 255, 255), 1, Qt.SolidLine)
        self.g_pen = QPen(QColor(136, 111, 111, 100), 1, Qt.SolidLine)

        self.vertical_lines = []
        self.horizontal_lines = []
        self.VERTICAL_SPACING = None
        self.HORIZONTAL_SPACING = None
        self.w = None
        self.h = None

    def get_usable_width(self):
        width = 0
        while self.HORIZONTAL_SPACING < (self.width() - width):
            width += self.HORIZONTAL_SPACING
        return width

    def get_usable_height(self):
        height = 0
        while self.VERTICAL_SPACING < (self.height() - height):
            height += self.HORIZONTAL_SPACING
        return height

    def populate_acceleration(self, acceleration):
        if len(self.list_acceleration) == self.MAX_ITEM:
            self.list_acceleration.pop(0)
        self.list_acceleration.append(acceleration)
        self.update()

    def set_max_value(self, max_value):
        self.max_range = max_value

    def resizeEvent(self, event):
        self.VERTICAL_SPACING = int(self.height() / 35)
        self.HORIZONTAL_SPACING = int(((self.width() * self.VERTICAL_SPACING) / self.height()))
        self.w = self.get_usable_width()
        self.h = self.get_usable_height()

    def paintEvent(self, event):
        if self.max_range is not None:
            self.draw_grid(event)
            self.x_points.clear()
            self.y_points.clear()
            self.z_points.clear()

            for i in range(0, len(self.list_acceleration) - 1):
                self.x_points.append(
                    QLine(
                        int(((self.w - self.HORIZONTAL_SPACING) * i) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i].x * self.h) / (self.max_range * 2.0))),
                        int(((self.w - self.HORIZONTAL_SPACING) * (i + 1)) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i + 1].x * self.h) / (self.max_range * 2.0)))
                    )
                )
                self.y_points.append(
                    QLine(
                        int(((self.w - self.HORIZONTAL_SPACING) * i) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i].y * self.h) / (self.max_range * 2.0))),
                        int(((self.w - self.HORIZONTAL_SPACING) * (i + 1)) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i + 1].y * self.h) / (self.max_range * 2.0)))
                    )
                )
                self.z_points.append(
                    QLine(
                        int(((self.w - self.HORIZONTAL_SPACING) * i) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i].z * self.h) / (self.max_range * 2.0))),
                        int(((self.w - self.HORIZONTAL_SPACING) * (i + 1)) / (len(self.list_acceleration) - 1.0)) + self.HORIZONTAL_SPACING,
                        int(((self.h + self.VERTICAL_SPACING * 2.0) / 2.0) - ((self.list_acceleration[i + 1].z * self.h) / (self.max_range * 2.0)))
                    )
                )
            qp = QPainter()
            qp.begin(self)

            if min(len(self.x_points), len(self.y_points), len(self.z_points)) > 0:
                qp.setPen(self.x_pen)
                qp.drawLines(self.x_points)

                qp.setPen(self.y_pen)
                qp.drawLines(self.y_points)

                qp.setPen(self.z_pen)
                qp.drawLines(self.z_points)
            qp.end()

    def draw_grid(self, event):
        qp = QPainter()
        qp.begin(self)
        qp.setFont(self.qf)
        qp.setPen(self.g_pen)

        interval = (self.max_range * self.VERTICAL_SPACING * 2) / self.h
        current_value = self.max_range
        for i in range(0, self.h, self.VERTICAL_SPACING):
            qp.drawText(QPointF(self.HORIZONTAL_SPACING / 4, self.VERTICAL_SPACING + i), "{:.1f}".format(current_value))
            self.vertical_lines.append(
                QLine(
                    self.HORIZONTAL_SPACING,
                    self.VERTICAL_SPACING + i,
                    self.w,
                    self.VERTICAL_SPACING + i
                )
            )
            current_value -= interval

        for i in range(0, self.w, self.HORIZONTAL_SPACING):
            self.vertical_lines.append(
                QLine(
                    self.HORIZONTAL_SPACING + i,
                    self.VERTICAL_SPACING,
                    self.HORIZONTAL_SPACING + i,
                    self.h
                )
            )
        qp.drawLines(self.vertical_lines)
        qp.end()
