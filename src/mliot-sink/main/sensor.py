import grpc
from main.generated import monitor_pb2, monitor_pb2_grpc


def run():
    with grpc.insecure_channel("192.168.1.79:1771") as channel:
        stub = monitor_pb2_grpc.MonitorServiceStub(channel)
        response = stub.onProximityDetected(monitor_pb2.ProximityMessage(distance=0.2))
        print(response)
        channel.unsubscribe(close)


def close(channel):
    channel.close()


if __name__ == "__main__":
    run()
