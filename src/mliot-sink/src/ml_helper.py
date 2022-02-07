import io

import cv2
import imutils
import numpy as np
from PIL import Image
from pytesseract import pytesseract as ocr

"""
    This class contains ML methods to detect faces, object or text from speech or images
"""


class MLHelper:
    """
        This method take image as raw frame from camera and tries to extract any text from it.
        It returns the extracted text
    """
    @staticmethod
    def apply_ocr(frame):
        # convert frame to numpy array
        bytes_image = io.BytesIO(frame)
        image = np.array(Image.open(bytes_image))

        # convert it to gray
        image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

        # apply some dilation and erosion to remove some noise
        kernel = np.ones((1, 1), np.uint8)
        image = cv2.dilate(image, kernel, iterations=1)
        image = cv2.erode(image, kernel, iterations=1)

        # apply threshold to get image only with black&white color
        image = cv2.adaptiveThreshold(image, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 11, 2)
        extracted_text = ocr.image_to_string(image, lang="fra", config='--tessdata-dir tesseract_pretrained_model')
        return extracted_text.strip()

    @staticmethod
    def recognize_object(frame):

        # convert frame to numpy array
        bytes_image = io.BytesIO(frame)
        image = np.array(Image.open(bytes_image))

        confidence_threshold = 0.2
        model = "net_ssd_pretrained_model/MobileNetSSD_deploy.caffemodel"
        proto_txt = "net_ssd_pretrained_model/MobileNetSSD_deploy.prototxt.txt"

        classes_list = ["arriere-plan", "avion", "velo", "oiseau", "bateau",
                   "bouteille", "autobus", "voiture", "chat", "chaise", "vache", "table",
                   "chien", "cheval", "moto", "personne", "plante en pot", "mouton",
                   "sofa", "train", "moniteur"]
        colors_list = np.random.uniform(0, 255, size=(len(classes_list), 3))
        
        # Load model file
        net = cv2.dnn.readNetFromCaffe(proto_txt, model)

        image = imutils.resize(image, width=800)
        # Create blob from image
        (h, w) = image.shape[:2]
        blob = cv2.dnn.blobFromImage(cv2.resize(image, (300, 300)), 0.007843, (300, 300), 127.5)
        
        # Feed input to neural network
        net.setInput(blob)
        detections = net.forward()

        # List that will contain all recognized objects
        recognized_objects = []

        # Detection loop
        for i in np.arange(0, detections.shape[2]):
            
            # Compute Object detection probability
            confidence = detections[0, 0, i, 2]
            
            # Suppress low probability
            if confidence > confidence_threshold:
                
                # Get index and position of detected object
                idx = int(detections[0, 0, i, 1])
                box = detections[0, 0, i, 3:7] * np.array([w, h, w, h])
                (startX, startY, endX, endY) = box.astype("int")
                
                # Create box and label
                recognized_objects.append(classes_list[idx])
                label = "{}: {:.2f}%".format(classes_list[idx], confidence * 100)
                cv2.rectangle(image, (startX, startY), (endX, endY), colors_list[idx], 2)
                
                y = startY - 15 if startY - 15 > 15 else startY + 15
                cv2.putText(image, label, (startX, y), cv2.FONT_HERSHEY_SIMPLEX, 0.5, colors_list[idx], 2)

        return recognized_objects, image
