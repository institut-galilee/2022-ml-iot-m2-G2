import logging as logger
from concurrent import futures

import grpc

from sink_pb2_grpc import add_SinkServiceServicer_to_server
from util.network_util import NetworkHelper, SINK_LISTENING_PORT

logger.basicConfig(level=logger.INFO)


class Sink:
    def __init__(self, listener):
        self.port_number = SINK_LISTENING_PORT
        self.ip_address = NetworkHelper.listening_address()
        self.server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
        add_SinkServiceServicer_to_server(listener, self.server)
        self.server.add_insecure_port("{0}:{1}".format(self.ip_address, self.port_number))

    def start(self):
        self.server.start()
        logger.info("gRPC Sink Server is running at {0}:{1}".format(self.ip_address, self.port_number))

    def shut_down(self):
        self.server.stop(30).wait()
        logger.info("gRPC Sink Server is shut down")
