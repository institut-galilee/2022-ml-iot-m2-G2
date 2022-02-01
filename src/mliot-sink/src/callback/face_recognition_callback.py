
class FaceRecognitionCallback(object):

    def __init__(self):
        pass

    def on_face_recognized(self, recognized_image, known_student):
        raise Exception("NotImplementedException")
