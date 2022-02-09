
class RecognitionCallback(object):

    def __init__(self):
        pass

    def on_face_recognized(self, recognized_image, known_student):
        raise Exception("NotImplementedException")

    def on_speech_recognized(self, extracted_text):
        raise Exception("NotImplementedException")

    def on_objects_recognized(self, recognized_objects, source):
        raise Exception("NotImplementedException")

    def on_text_recognized(self, extracted_text):
        raise Exception("NotImplementedException")
