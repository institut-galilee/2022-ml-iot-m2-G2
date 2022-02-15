import time

from grpc import insecure_channel, RpcError

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
        with insecure_channel("{0}:{1}".format(address, port_number)) as channel:
            stub = MonitorServiceStub(channel)
            try:
                message = SpeechRecognitionMessage()
                message.card_number = card_number
                message.spoken_speech = extracted_text
                message.similarity_report.extended(similarity_report)
                message.mills = int(round(time.time() * 1000))
                message.severity = SEVERE
                stub.onMicrophoneSpeechRecognized(message)
            except RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while communicating with monitor: {e}")
            finally:
                channel.close()

    @staticmethod
    async def browser_size_not_fitting_screen_size(card_number, message):
        pass

    @staticmethod
    async def screenshot_text_recognized(card_number, extracted_text, similarity_report):
        pass

    @staticmethod
    async def qr_code_verification_failed(card_number, message):
        pass

    @staticmethod
    async def student_not_allowed(card_number, message):
        pass

    @staticmethod
    async def face_not_recognized(card_number, message):
        pass

    @staticmethod
    async def web_camera_objects_recognized(card_number, message):
        pass

    @staticmethod
    async def phone_camera_objects_recognized(card_number, message):
        pass

    @staticmethod
    async def un_authorized_monitor(card_number, message):
        pass

    @staticmethod
    async def motion_detected(card_number, message):
        pass

    @staticmethod
    async def hand_device_state_changed(card_number, message):
        pass
