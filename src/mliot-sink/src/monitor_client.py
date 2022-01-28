import grpc

import monitor_pb2
import monitor_pb2_grpc


class MonitorHelper:
    @staticmethod
    def fetch_known_students():
        known_students = []
        with grpc.insecure_channel("192.168.1.79:1771") as channel:
            stub = monitor_pb2_grpc.MonitorServiceStub(channel)
            responses = stub.fetchKnownStudents(monitor_pb2.EmptyMessage())
            for response in responses:
                known_students.append(response)
            channel.close()
        return known_students
