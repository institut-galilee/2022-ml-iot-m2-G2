import grpc

from src import monitor_pb2_grpc, monitor_pb2


def run():
    with grpc.insecure_channel("192.168.1.79:1771") as channel:
        stub = monitor_pb2_grpc.MonitorServiceStub(channel)
        responses = stub.fetchKnownStudents(monitor_pb2.EmptyMessage())
        for response in responses:
            print(response)
        channel.unsubscribe(close)


def close(channel):
    channel.close()


if __name__ == "__main__":
    run()
