import argparse
import io
import logging as logger

import PIL.Image
import cv2
import dlib
import numpy as np
from imutils import face_utils

from monitor_client import MonitorHelper

logger.basicConfig(level=logger.INFO)

print('[INFO] Starting System...')
print('[INFO] Importing pretrained model..')
pose_predictor_68_point = dlib.shape_predictor("pretrained_model/shape_predictor_68_face_landmarks.dat")
pose_predictor_5_point = dlib.shape_predictor("pretrained_model/shape_predictor_5_face_landmarks.dat")
face_encoder = dlib.face_recognition_model_v1("pretrained_model/dlib_face_recognition_resnet_model_v1.dat")
face_detector = dlib.get_frontal_face_detector()


def transform(image, face_locations):
    coord_faces = []
    for face in face_locations:
        rect = face.top(), face.right(), face.bottom(), face.left()
        coord_face = max(rect[0], 0), min(rect[1], image.shape[1]), min(rect[2], image.shape[0]), max(rect[3], 0)
        coord_faces.append(coord_face)
    return coord_faces


def encode_face(image):
    face_locations = face_detector(image, 1)
    face_encodings_list = []
    landmarks_list = []
    for face_location in face_locations:
        # DETECT FACES
        shape = pose_predictor_68_point(image, face_location)
        face_encodings_list.append(np.array(face_encoder.compute_face_descriptor(image, shape, num_jitters=1)))
        # GET LANDMARKS
        shape = face_utils.shape_to_np(shape)
        landmarks_list.append(shape)
    face_locations = transform(image, face_locations)
    return face_encodings_list, face_locations, landmarks_list


def easy_face_reco(frame, known_encoded_faces, known_face_names):
    rgb_small_frame = frame[:, :, ::-1]
    # ENCODING FACE
    face_encodings_list, face_locations_list, landmarks_list = encode_face(rgb_small_frame)
    face_names = []
    for face_encoding in face_encodings_list:
        if len(face_encoding) == 0:
            return np.empty((0))
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
            name = known_face_names[first_match_index]
        else:
            name = "Unknown"
        face_names.append(name)

    for (top, right, bottom, left), name in zip(face_locations_list, face_names):
        if True in result:
            color = (0, 255, 0)
        else:
            color = (255, 0, 255)
        cv2.rectangle(frame, (left, top), (right, bottom), color, 2)
        cv2.rectangle(frame, (left, bottom - 30), (right, bottom), color, cv2.FILLED)
        cv2.putText(frame, name, (left + 2, bottom - 2), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 0), 1)

    for shape in landmarks_list:
        for (x, y) in shape:
            cv2.circle(frame, (x, y), 1, (255, 0, 255), -1)


if __name__ == '__main__':

    known_face_names = []
    known_encoded_faces = []

    logger.info("Searching for students' faces…")
    known_students = MonitorHelper.fetch_known_students()
    if len(known_students) == 0:
        raise ValueError('No student found as reference')
    for known_student in known_students:
        known_face_names.append(f"{known_student.first_name} {known_student.last_name}")
        image = PIL.Image.open(io.BytesIO(known_student.profile_photo))
        image = np.array(image)
        encoded_face = encode_face(image)[0][0]
        known_encoded_faces.append(encoded_face)
    logger.info("Students' faces well imported")

    logger.info("Opening of web camera…")
    video_capture = cv2.VideoCapture(0)
    logger.info("Web camera well opened")

    logger.info("Starting of face detection…")
    while True:
        ret, frame = video_capture.read()
        easy_face_reco(frame, known_encoded_faces, known_face_names)
        cv2.imshow('Easy Facial Recognition App', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    logger.info("Shutting down the face recognition step…")
    video_capture.release()
    cv2.destroyAllWindows()
