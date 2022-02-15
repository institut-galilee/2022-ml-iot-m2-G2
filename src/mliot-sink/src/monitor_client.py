import time

from grpc import aio, RpcError, insecure_channel

from monitor_pb2 import *
from monitor_pb2_grpc import MonitorServiceStub
from util.network_util import NetworkHelper, GATEWAY_LISTENING_PORT
import logging as logger


class MonitorHelper:

    @staticmethod
    def connect_student(card_number):
        exam_url, api_url = None, None
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        with insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                gateway_address = NetworkHelper.get_gateway_listening_address()
                gateway_port_number = GATEWAY_LISTENING_PORT
                message = StudentConnectionMessage()
                message.card_number = card_number
                message.address = gateway_address
                message.port_number = gateway_port_number
                response = stub.onStudentConnected(message)
                exam_url, api_url = response.exam_url, response.api_url
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while connecting student: {e}")
            finally:
                channel.close()
        return exam_url, api_url

    @staticmethod
    def fetch_known_students():
        known_students = []
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        with insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                responses = stub.fetchKnownStudents(EmptyMessage())
                for response in responses:
                    known_students.append(response)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while fetching known students: {e}")
            finally:
                channel.close()
        return known_students

    @staticmethod
    async def microphone_speech_recognized(card_number, extracted_text, similarity_report):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                speech_message = SpeechRecognitionMessage()
                speech_message.card_number = card_number
                speech_message.spoken_speech = extracted_text
                speech_message.similarity_report.extend(similarity_report)
                speech_message.mills = int(round(time.time() * 1000))
                speech_message.severity = SEVERE
                await stub.onMicrophoneSpeechRecognized(speech_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def browser_size_not_fitting_screen_size(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                browser_message = BrowserSizeMessage()
                browser_message.card_number = card_number
                browser_message.message = message
                browser_message.mills = int(round(time.time() * 1000))
                browser_message.severity = WARNING
                await stub.onBrowserSizeNotFittingScreenSize(browser_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def screenshot_text_recognized(card_number, extracted_text, similarity_report):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                screenshot_message = ScreenshotTextRecognitionMessage()
                screenshot_message.card_number = card_number
                screenshot_message.recognized_text = extracted_text
                screenshot_message.similarity_report.extend(similarity_report)
                screenshot_message.mills = int(round(time.time() * 1000))
                screenshot_message.severity = SEVERE
                await stub.onScreenshotTextRecognized(screenshot_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def qr_code_verification_failed(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                qr_code_message = QRCodeVerificationMessage()
                qr_code_message.card_number = card_number
                qr_code_message.message = message
                qr_code_message.mills = int(round(time.time() * 1000))
                qr_code_message.severity = WARNING
                await stub.onQRCodeVerificationFailed(qr_code_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def student_not_allowed(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                student_fraud_message = StudentFraudMessage()
                student_fraud_message.card_number = card_number
                student_fraud_message.message = message
                student_fraud_message.mills = int(round(time.time() * 1000))
                student_fraud_message.severity = WARNING
                await stub.onStudentNotAllowed(student_fraud_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def face_not_recognized(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                face_message = FaceRecognitionMessage()
                face_message.card_number = card_number
                face_message.message = message
                face_message.mills = int(round(time.time() * 1000))
                face_message.severity = WARNING
                await stub.onFaceNotRecognized(face_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def web_camera_objects_recognized(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                web_camera_message = WebCameraRecognitionMessage()
                web_camera_message.card_number = card_number
                web_camera_message.message = message
                web_camera_message.mills = int(round(time.time() * 1000))
                web_camera_message.severity = WARNING
                await stub.onWebCameraObjectsRecognized(web_camera_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def phone_camera_objects_recognized(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                phone_camera_message = PhoneCameraRecognitionMessage()
                phone_camera_message.card_number = card_number
                phone_camera_message.message = message
                phone_camera_message.mills = int(round(time.time() * 1000))
                phone_camera_message.severity = WARNING
                await stub.onPhoneCameraObjectsRecognized(phone_camera_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def un_authorized_monitor(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                monitor_message = UnAuthorizedMonitorMessage()
                monitor_message.card_number = card_number
                monitor_message.message = message
                monitor_message.mills = int(round(time.time() * 1000))
                monitor_message.severity = WARNING
                await stub.onUnAuthorizedMonitor(monitor_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def motion_detected(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                movement_message = MovementDetectionMessage()
                movement_message.card_number = card_number
                movement_message.message = message
                movement_message.mills = int(round(time.time() * 1000))
                movement_message.severity = WARNING
                await stub.onMovementDetected(movement_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def hand_device_state_changed(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                hand_device_message = HandDeviceMessage()
                hand_device_message.card_number = card_number
                hand_device_message.message = message
                hand_device_message.mills = int(round(time.time() * 1000))
                hand_device_message.severity = WARNING
                await stub.onHandDeviceStateChanged(hand_device_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()

    @staticmethod
    async def high_acceleration_noticed(card_number, message):
        address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        async with aio.insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                acceleration_message = HighAccelerationMessage()
                acceleration_message.card_number = card_number
                acceleration_message.message = message
                acceleration_message.mills = int(round(time.time() * 1000))
                acceleration_message.severity = WARNING
                await stub.onHighAccelerationNoticed(acceleration_message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                await channel.close()
