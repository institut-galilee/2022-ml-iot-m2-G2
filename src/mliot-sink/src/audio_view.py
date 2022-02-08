import ctypes
import threading

import speech_recognition as sr
from PySide6 import QtGui
from PySide6.QtCore import QLine
from PySide6.QtGui import QPen, Qt
from PySide6.QtWidgets import QWidget

from callback.recognition_callback import RecognitionCallback


class AudioView(QWidget, threading.Thread):
    def __init__(self, speech_recognition_callback: RecognitionCallback):
        super().__init__()
        threading.Thread.__init__(self)

        self.speech_recognition_callback = speech_recognition_callback

        self.point_array = []
        self.waveform = None

        self.pen = QPen(Qt.green, 1, Qt.SolidLine)

        self.speech_engine = sr.Recognizer()
        self.is_recording = True

    def update_waveform(self, frame):
        self.waveform = frame
        self.update()

    def run(self):
        while self.is_recording:
            with sr.Microphone() as source:
                self.speech_engine.adjust_for_ambient_noise(source)
                audio_data = self.speech_engine.record(source, duration=5)
                # self.update_waveform(audio_data.frame_data)
                try:
                    extracted_text = self.speech_engine.recognize_google(audio_data, language="fr-FR")
                    self.speech_recognition_callback.on_speech_recognized(extracted_text)
                except sr.UnknownValueError:
                    pass
                except sr.RequestError:
                    pass

    def close(self):
        self.is_recording = False

    def paintEvent(self, event):

        if self.waveform is not None:
            self.point_array.clear()

            for i in range(0, len(self.waveform) - 1):
                self.point_array.append(
                    QLine(
                        int((self.width() * i) / (len(self.waveform) - 1)),
                        int((self.height() / 2.0) + ((ctypes.c_int8(self.waveform[i] + 128)).value * (self.height() / 2.0)) / 128.0),
                        int((self.width() * (i + 1.0)) / (len(self.waveform) - 1)),
                        int((self.height() / 2.0) + ((ctypes.c_int8(self.waveform[i + 1] + 128)).value * (self.height() / 2.0)) / 128.0)
                    )
                )
            qp = QtGui.QPainter()
            qp.begin(self)

            if len(self.point_array) > 0:
                qp.setPen(self.pen)
                qp.drawLines(self.point_array)
            qp.end()
