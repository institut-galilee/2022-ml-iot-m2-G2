
class RecognitionCallback(object):

    def __init__(self):
        pass

    def on_face_recognized(self, recognized_image, known_student):
        raise Exception("NotImplementedException")

    def on_face_not_recognized(self):
        raise Exception("NotImplementedException")

    def on_microphone_speech_recognized(self, extracted_text):
        raise Exception("NotImplementedException")

    def on_camera_objects_recognized(self, recognized_objects, source):
        raise Exception("NotImplementedException")

    def on_browser_size_not_fitting_screen_size(self, screen_width, screen_height, browser_width, browser_height):
        raise Exception("NotImplementedException")

    def on_screenshot_text_recognized(self, extracted_text):
        raise Exception("NotImplementedException")

    def on_qr_code_verification_failed(self, recognized_references):
        raise Exception("NotImplementedException")

    def on_qr_code_read(self, read_entries):
        raise Exception("NotImplementedException")
