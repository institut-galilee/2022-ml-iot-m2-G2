import logging
import threading
from concurrent import futures

import grpc

from main.generated import sink_pb2_grpc
from ..util.network import NetworkHelper


class Sink(threading.Thread):
    def __init__(self, listener):
        threading.Thread.__init__(self)
        port_number = NetworkHelper.listening_port()
        ip_address = NetworkHelper.listening_address()
        self.server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
        sink_pb2_grpc.add_SinkServiceServicer_to_server(listener, self.server)
        self.server.add_insecure_port("{0}:{1}".format(ip_address, port_number))
        logging.warning("gRPC Sink Server is running at {0}:{1}".format(ip_address, port_number))

    def run(self):
        self.server.start()
        self.server.wait_for_termination()

    def stop(self):
        self.server.stop()
