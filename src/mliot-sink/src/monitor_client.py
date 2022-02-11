import grpc

import monitor_pb2
import monitor_pb2_grpc
from util.network_util import NetworkHelper, GATEWAY_LISTENING_PORT
import logging as logger


class MonitorHelper:

    @staticmethod
    def connect_student(card_number):
        ip_address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        exam_url, api_url = None, None
        with grpc.insecure_channel("{0}:{1}".format(ip_address, port_number)) as channel:
            stub = monitor_pb2_grpc.MonitorServiceStub(channel)
            try:
                address = NetworkHelper.get_gateway_listening_address()
                port_number = GATEWAY_LISTENING_PORT
                response = stub.onStudentConnected(monitor_pb2.StudentConnectionMessage(card_number=card_number, address=address, port_number=port_number))
                exam_url, api_url = response.exam_url, response.api_url
            except grpc.RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while connecting student: {e}")
            finally:
                channel.close()
        return exam_url, api_url

    @staticmethod
    def fetch_known_students():
        known_students = []
        ip_address = NetworkHelper.get_monitor_listening_address()
        port_number = NetworkHelper.get_monitor_listening_port_number()
        with grpc.insecure_channel("{0}:{1}".format(ip_address, port_number)) as channel:
            stub = monitor_pb2_grpc.MonitorServiceStub(channel)
            try:
                responses = stub.fetchKnownStudents(monitor_pb2.EmptyMessage())
                for response in responses:
                    known_students.append(response)
            except grpc.RpcError as e:
                logger.log(level=logger.FATAL, msg=f"Error while fetching known students: {e}")
            finally:
                channel.close()
        return known_students
