import io

import cv2
import imutils
import numpy as np
from PIL import Image
from imutils import face_utils
from pytesseract import pytesseract as ocr

"""
    This class contains ML methods to detect faces, object or text from speech or images
"""


class MLHelper:
    """
        This method take Pillow Image as a screenshot and tries to extract any text from it.
        It returns the extracted text.
    """
    @staticmethod
    def recognize_text(screenshot):

        # convert image to numpy array
        image = np.array(screenshot)

        # convert it to gray
        image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

        # apply some dilation and erosion to remove some noise
        kernel = np.ones((1, 1), np.uint8)
        image = cv2.dilate(image, kernel, iterations=1)
        image = cv2.erode(image, kernel, iterations=1)

        # apply threshold to get image only with black&white color
        image = cv2.adaptiveThreshold(image, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 11, 2)
        extracted_text = ocr.image_to_string(image, lang="fra", config='--tessdata-dir tesseract_pretrained_model')
        return "\n".join([line for line in extracted_text.split("\n") if line])

    """
        This method take image as bytes from camera and tries to recognize any object in it.
        It returns the list of the recognized objects' name and the new frame on which identified objects are shown.
    """
    @staticmethod
    def recognize_object(image):

        np.random.seed(42)
        labels = open("yolo_coco_pretrained_model/coco.names").read().strip().split("\n")
        colors = np.random.randint(0, 255, size=(len(labels), 3), dtype="uint8")

        net = cv2.dnn.readNetFromDarknet("yolo_coco_pretrained_model/yolov3.cfg", "yolo_coco_pretrained_model/yolov3.weights")

        image = np.array(image)
        (H, W) = image.shape[:2]

        ln = net.getLayerNames()
        ln = [ln[i - 1] for i in net.getUnconnectedOutLayers()]

        blob = cv2.dnn.blobFromImage(image, 1 / 255.0, (416, 416), swapRB=True, crop=False)
        net.setInput(blob)
        layerOutputs = net.forward(ln)

        boxes = []
        confidences = []
        classIDs = []

        for output in layerOutputs:
            for detection in output:
                scores = detection[5:]
                classID = np.argmax(scores)
                confidence = scores[classID]
                if confidence > 0.5:
                    box = detection[0:4] * np.array([W, H, W, H])
                    (centerX, centerY, width, height) = box.astype("int")
                    x = int(centerX - (width / 2))
                    y = int(centerY - (height / 2))
                    boxes.append([x, y, int(width), int(height)])
                    confidences.append(float(confidence))
                    classIDs.append(classID)

        recognized_objects = []
        idxs = cv2.dnn.NMSBoxes(boxes, confidences, 0.5, 0.3)

        if len(idxs) > 0:
            for i in idxs.flatten():
                (x, y) = (boxes[i][0], boxes[i][1])
                (w, h) = (boxes[i][2], boxes[i][3])
                color = [int(c) for c in colors[classIDs[i]]]
                cv2.rectangle(image, (x, y), (x + w, y + h), color, 2)
                text = "{}: {:.4f}".format(labels[classIDs[i]], confidences[i])
                cv2.putText(image, text, (x, y - 5), cv2.FONT_HERSHEY_SIMPLEX, 0.5, color, 2)
                recognized_objects.append(labels[classIDs[i]])

        return recognized_objects, image

    """
        This method take image as bytes from camera and tries to recognize or identify the person on it based on already known faces.
        It returns the list of the recognized objects' name and the new frame on which identified objects are shown.
    """
    @staticmethod
    def encode_face(image, face_detector, pose_predictor_68_point, face_encoder):
        face_locations = face_detector(image, 1)
        face_encodings_list = []
        for face_location in face_locations:
            # DETECT FACES
            shape = pose_predictor_68_point(image, face_location)
            face_encodings_list.append(np.array(face_encoder.compute_face_descriptor(image, shape, num_jitters=1)))
            # GET LANDMARKS
            shape = face_utils.shape_to_np(shape)
        coord_faces = []
        for face in face_locations:
            rect = face.top(), face.right(), face.bottom(), face.left()
            coord_face = max(rect[0], 0), min(rect[1], image.shape[1]), min(rect[2], image.shape[0]), max(rect[3], 0)
            coord_faces.append(coord_face)
        face_locations = coord_faces
        return face_encodings_list, face_locations

    @staticmethod
    def recognize_face(frame, known_persons, known_encoded_faces, face_detector, pose_predictor_68_point, face_encoder):
        rgb_small_frame = frame[:, :, ::-1]
        # ENCODING FACE
        face_encodings_list, face_locations_list = MLHelper.encode_face(rgb_small_frame, face_detector, pose_predictor_68_point, face_encoder)
        for face_encoding in face_encodings_list:
            if len(face_encoding) == 0:
                return np.empty(0)
            # CHECK DISTANCE BETWEEN KNOWN FACES AND FACES DETECTED
            vectors = np.linalg.norm(known_encoded_faces - face_encoding, axis=1)
            tolerance = 0.6
            result = []
            for vector in vectors:
                if vector <= tolerance:
                    result.append(True)
                else:
                    result.append(False)
            if True in result:
                first_match_index = result.index(True)
                top, right, bottom, left = list(face_locations_list[0])
                return known_persons[first_match_index], top, right, bottom, left

        return None, None, None, None, None
