import grpc

import monitor_pb2
import monitor_pb2_grpc
from util.network_util import *
import logging as logger


class MonitorHelper:
    @staticmethod
    def fetch_known_students():
        known_students = []
        ip_address = NetworkHelper.listening_address()
        port_number = MONITOR_LISTENING_PORT
        with grpc.insecure_channel("{0}:{1}".format(ip_address, port_number)) as channel:
            stub = monitor_pb2_grpc.MonitorServiceStub(channel)
            try:
                responses = stub.fetchKnownStudents(monitor_pb2.EmptyMessage())
                for response in responses:
                    known_students.append(response)
            except grpc.RpcError as e:
                logger.log(level=logger.FATAL, msg="Error while fetching known students")
            finally:
                channel.close()
        return known_students
