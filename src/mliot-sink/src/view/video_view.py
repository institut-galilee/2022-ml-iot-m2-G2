from PySide6.QtGui import QPixmap, Qt
from PySide6.QtWidgets import QLabel


class VideoView(QLabel):

    def __init__(self):
        super().__init__()
        self.frame = None
        self.setAlignment(Qt.AlignCenter)

    def update_frame(self, frame):
        self.frame = frame
        pixmap = QPixmap()
        pixmap.loadFromData(frame)
        self.update_image(pixmap)

    def update_image(self, pixmap):
        self.setPixmap(pixmap)

    def find_current_frame(self):
        return self.frame
