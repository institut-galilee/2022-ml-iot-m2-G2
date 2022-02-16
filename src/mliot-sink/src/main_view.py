import asyncio
import math

import cv2
import spacy
from PySide6.QtCore import QTimer
from PySide6.QtGui import QImage, QPixmap, QCloseEvent, Qt
from PySide6.QtWidgets import QWidget, QHBoxLayout, QVBoxLayout, QLabel

from acceleration_view import AccelerationView
from callback.recognition_callback import RecognitionCallback
from monitor_client import MonitorHelper
from process import SpeechRecognizer, ScreenshotTextRecognizer, FaceRecognizer, ObjectRecognizer

GRAVITY = 9.81


class MainView(QWidget, RecognitionCallback):
    def __init__(self, current_student, api_content):
        super().__init__()

        # Thresholds
        self.face_not_recognized_threshold = 4

        # Counters
        self.face_recognizer_counter = 0
        self.monitor_recognizer_counter = 0

        self.current_student = current_student
        self.api_content = api_content

        self.setFixedWidth(1080)
        self.setFixedHeight(720)

        # Setup Phone Camera View
        self.phone_camera_view = QLabel()
        self.phone_camera_view.setFixedWidth(512)
        self.phone_camera_view.setFixedHeight(288)
        self.phone_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Computer Camera View
        self.web_camera_view = QLabel()
        self.web_camera_view.setFixedWidth(512)
        self.web_camera_view.setFixedHeight(288)
        self.web_camera_view.setStyleSheet("border: 5px solid #396EB0; border-radius: 3px;")

        # Setup Acceleration View
        self.acceleration_view = AccelerationView()
        self.acceleration_view.setFixedWidth(1080)
        self.acceleration_view.setFixedHeight(360)
        self.acceleration_view.setStyleSheet("QWidget {border: 5px solid #396EB0; border-radius: 3px;}")

        h_layout = QHBoxLayout()
        h_layout.addWidget(self.phone_camera_view, alignment=Qt.AlignLeft)
        h_layout.addWidget(self.web_camera_view, alignment=Qt.AlignRight)

        layout = QVBoxLayout(self)
        layout.addLayout(h_layout)
        layout.addWidget(self.acceleration_view, alignment=Qt.AlignBottom)

        # Create a capture timer to refresh web camera images
        self.capture_timer = QTimer()
        self.capture_timer.timeout.connect(self.on_preview_frame)

        # Open web camera and start previewing
        self.web_camera = cv2.VideoCapture(0)
        self.capture_timer.start(1)

        # Start Face Recognition process
        self.face_recognizer = FaceRecognizer(self)
        self.face_recognizer.start()

        # Start Phone Camera Object Recognition process
        self.phone_camera_object_recognizer = ObjectRecognizer(self, "phone_camera", should_read_qr_code=True)
        self.phone_camera_object_recognizer.start()

        # Start Web Camera Object Recognition process
        self.web_camera_object_recognizer = ObjectRecognizer(self, "web_camera", should_read_qr_code=False)
        self.web_camera_object_recognizer.start()

        # Start Speech to Text process
        self.speech_recognizer = SpeechRecognizer(self)
        self.speech_recognizer.start()

        self.nlp = None
        asyncio.run(self.load_french_tokenizer())

        # Start OCR process
        self.text_recognizer = ScreenshotTextRecognizer(self, self.api_content["exam_reference"])
        while True:
            if self.nlp is not None:
                self.text_recognizer.start()
                break

    async def load_french_tokenizer(self):
        # Load French tokenizer, tagger, parser and NER
        # self.nlp = spacy.load("fr_dep_news_trf")
        self.nlp = spacy.load("fr_core_news_md")

    def on_microphone_speech_recognized(self, extracted_text):
        similarity_report = self.find_similarities(extracted_text)
        if len(similarity_report) > 0:
            asyncio.run(MonitorHelper.microphone_speech_recognized(self.current_student.card_number, extracted_text, similarity_report))

    def on_browser_size_not_fitting_screen_size(self, screen_width, screen_height, browser_width, browser_height):
        message = f"La taille du navigateur ne correspond pas à la taille de l'écran: ({browser_width}x{browser_height}) au lieu de ({screen_width}x{screen_height})."
        asyncio.run(MonitorHelper.browser_size_not_fitting_screen_size(self.current_student.card_number, message))

    def on_screenshot_text_recognized(self, extracted_text):
        similarity_report = self.find_similarities(extracted_text)
        if len(similarity_report) > 0:
            asyncio.run(MonitorHelper.screenshot_text_recognized(self.current_student.card_number, extracted_text, similarity_report))

    def on_qr_code_verification_failed(self, recognized_references):
        exam_references = self.api_content["exam_reference"].split()
        missing_references = set(exam_references).difference(set(recognized_references))
        message = []
        for missing_reference in missing_references:
            if missing_reference == exam_references[0]:
                message.append("Une fenêtre couvre la partie haute et gauche de l'examen.")
            if missing_reference == exam_references[1]:
                message.append("Une fenêtre couvre la partie haute et droite de l'examen.")
            if missing_reference == exam_references[2]:
                message.append("Une fenêtre couvre la partie basse et gauche de l'examen.")
            if missing_reference == exam_references[3]:
                message.append("Une fenêtre couvre la partie basse et droite de l'examen.")
        message = "\n".join(message)
        asyncio.run(MonitorHelper.qr_code_verification_failed(self.current_student.card_number, message))

    def on_face_recognized(self, recognized_image, known_student):
        self.face_recognizer_counter = 0
        if self.current_student.card_number != known_student.card_number:
            message = f"On espérait voir {self.current_student.first_name} {self.current_student.last_name} mais {known_student.first_name} {known_student.last_name} a été aperçu."
            asyncio.run(MonitorHelper.student_not_allowed(self.current_student.card_number, message))

    def on_face_not_recognized(self):
        self.face_recognizer_counter += 1
        if self.face_recognizer_counter > self.face_not_recognized_threshold:
            message = f"Depuis {self.face_recognizer_counter * self.face_not_recognized_threshold} secondes, {self.current_student.first_name} {self.current_student.last_name} n'est pas reconnu par sa caméra."
            asyncio.run(MonitorHelper.face_not_recognized(self.current_student.card_number, message))
            self.face_recognizer_counter = 0

    def on_camera_objects_recognized(self, recognized_objects, source):
        if source == "web_camera":
            if "person" not in recognized_objects:
                message = "Aucune personne devant le sujet d'examen."
                asyncio.run(MonitorHelper.web_camera_objects_recognized(self.current_student.card_number, message))
            elif recognized_objects.count("person") > 1:
                message = f"Il y a {recognized_objects.count('person')} personnes devant le sujet d'examen."
                asyncio.run(MonitorHelper.web_camera_objects_recognized(self.current_student.card_number, message))
        if source == "phone_camera":
            if "tvmonitor" not in recognized_objects and "laptop" not in recognized_objects:
                message = f"Il y a aucun écran moniteur ou ordinateur portable en face de {self.current_student.first_name} {self.current_student.last_name}."
                asyncio.run(MonitorHelper.phone_camera_objects_recognized(self.current_student.card_number, message))
            elif recognized_objects.count("tvmonitor") > 1 or recognized_objects.count("laptop") > 1:
                message = f"Il y a au moins {recognized_objects.count('tvmonitor') + recognized_objects.count('laptop')} écrans moniteur ou ordinateurs portable en face de {self.current_student.first_name} {self.current_student.last_name}."
                asyncio.run(MonitorHelper.phone_camera_objects_recognized(self.current_student.card_number, message))
            if "book" in recognized_objects:
                message = f"Il y a {recognized_objects.count('book')} livre{'s' if  recognized_objects.count('book') > 1 else ''} en face de {self.current_student.first_name} {self.current_student.last_name}."
                asyncio.run(MonitorHelper.phone_camera_objects_recognized(self.current_student.card_number, message))
            if "cell phone" in recognized_objects:
                message = f"Il y a {recognized_objects.count('book')} téléphone{'s' if recognized_objects.count('cell phone') > 1 else ''} en face de {self.current_student.first_name} {self.current_student.last_name}."
                asyncio.run(MonitorHelper.phone_camera_objects_recognized(self.current_student.card_number, message))

    def on_qr_code_read(self, read_entries):
        exam_references = self.api_content["exam_reference"].split()
        if not set(read_entries).issubset(set(exam_references)):
            message = f"L'écran moniteur ou ordinateur portable en face de {self.current_student.first_name} {self.current_student.last_name} ne contient pas le sujet d'examen."
            asyncio.run(MonitorHelper.un_authorized_monitor(self.current_student.card_number, message))

    def closeEvent(self, event: QCloseEvent):
        # Stop all processes before closing the window
        self.speech_recognizer.is_recording = False
        self.face_recognizer.is_not_stopped = False
        self.text_recognizer.is_screenshotting = False
        self.web_camera_object_recognizer.is_not_stopped = False
        self.phone_camera_object_recognizer.is_not_stopped = False
        # Stop camera before closing the window
        self.capture_timer.stop()
        self.web_camera.release()

    def on_preview_frame(self):
        ret, frame = self.web_camera.read()
        frame = cv2.resize(frame, (self.web_camera_view.width(), self.web_camera_view.height()))
        frame = cv2.flip(frame, 1)
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        image = QImage(frame, frame.shape[1], frame.shape[0], QImage.Format_RGB888)
        pixmap = QPixmap.fromImage(image)
        self.web_camera_view.setPixmap(pixmap)
        self.web_camera_object_recognizer.frame = cv2.imencode('.jpg', frame)[1].tobytes()
        self.face_recognizer.frame = frame

    def update_phone_video(self, frame):
        self.phone_camera_object_recognizer.frame = frame
        pixmap = QPixmap()
        pixmap.loadFromData(frame)
        self.phone_camera_view.setPixmap(pixmap.scaledToWidth(self.phone_camera_view.width()))

    def update_acceleration_view(self, acceleration):
        self.acceleration_view.populate_acceleration(acceleration)
        x, y, z = acceleration.x, acceleration.y, acceleration.z
        average = math.sqrt(math.pow(x, 2) + math.pow(y, 2) + math.pow(z, 2))
        if average > GRAVITY * 2.5:
            message = f"{self.current_student.first_name} {self.current_student.last_name} fait des mouvements de bras suspect, son bras a une accéleration de {average/GRAVITY}g"
            asyncio.run(MonitorHelper.high_acceleration_noticed(self.current_student.card_number, message))

    def set_acceleration_max_value(self, max_value):
        self.acceleration_view.set_max_value(max_value)

    def find_similarities(self, extracted_text):
        similarity_report = []
        spoken_nlp = self.nlp(extracted_text)
        exam_questions = self.api_content["exam_questions"]
        for question in exam_questions:
            question_nlp = self.nlp(question["question_text"])
            question_similarity = question_nlp.similarity(spoken_nlp)
            if question_similarity >= 0.5:
                similarity_report.append(f"Q{question['question_id']}: {round(question_similarity * 100, 2)}%")
            question_responses = question["question_responses"]
            for response in question_responses:
                response_nlp = self.nlp(response["response_text"])
                response_similarity = response_nlp.similarity(spoken_nlp)
                if response_similarity >= 0.3:
                    similarity_report.append(f"Q{question['question_id']}, O{response['response_id']}: {round(response_similarity * 100, 2)}%")
        return similarity_report
