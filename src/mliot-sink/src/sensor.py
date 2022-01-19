import grpc
import sink_pb2
import sink_pb2_grpc


def run():
    with grpc.insecure_channel("192.168.1.79:7117") as channel:
        stub = sink_pb2_grpc.SinkServiceStub(channel)
        response = stub.SendAcceleration(sink_pb2.Acceleration(x=12.5, y=10.4, z=11.12))
        print(response)
        channel.unsubscribe(close)


def close(channel):
    channel.close()


if __name__ == "__main__":
    run()
