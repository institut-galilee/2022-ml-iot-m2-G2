import io

import cv2
import numpy as np
from PIL import Image
from pytesseract import pytesseract as ocr


class MLHelper:

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
