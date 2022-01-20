from concurrent import futures
import grpc
import sink_pb2
import sink_pb2_grpc
from PIL import Image
import io


class ServiceListener(sink_pb2_grpc.SinkServiceServicer):
    def SendAudio(self, request, context):
        print(request)
        return sink_pb2.Response(received=True)

    def SendVideo(self, request, context):
        print(request)
        image = Image.open(io.BytesIO(request.data))
        image.show()
        return sink_pb2.Response(received=True)

    def SendAcceleration(self, request, context):
        print(request.x)
        return sink_pb2.Response(received=True)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    sink_pb2_grpc.add_SinkServiceServicer_to_server(ServiceListener(), server)
    server.add_insecure_port("[::]:7117")
    print('Server is running on port 7117')
    server.start()
    server.wait_for_termination()


if __name__ == "__main__":
    serve()
