# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import common_pb2 as common__pb2
import sink_pb2 as sink__pb2


class SinkServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.onStepDetected = channel.unary_unary(
                '/SinkService/onStepDetected',
                request_serializer=sink__pb2.StepDetectionMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onVideoFrameAvailable = channel.unary_unary(
                '/SinkService/onVideoFrameAvailable',
                request_serializer=sink__pb2.VideoMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onProximityChanged = channel.unary_unary(
                '/SinkService/onProximityChanged',
                request_serializer=sink__pb2.ProximityMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onHeartRateChanged = channel.unary_unary(
                '/SinkService/onHeartRateChanged',
                request_serializer=sink__pb2.HeartBeatMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.setAccelerationMaxRange = channel.unary_unary(
                '/SinkService/setAccelerationMaxRange',
                request_serializer=sink__pb2.RangeMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onMotionDetected = channel.unary_unary(
                '/SinkService/onMotionDetected',
                request_serializer=sink__pb2.MotionDetectionMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onTemperatureChanged = channel.unary_unary(
                '/SinkService/onTemperatureChanged',
                request_serializer=sink__pb2.TemperatureMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )
        self.onAccelerationChanged = channel.unary_unary(
                '/SinkService/onAccelerationChanged',
                request_serializer=sink__pb2.AccelerationMessage.SerializeToString,
                response_deserializer=sink__pb2.BoolResponse.FromString,
                )
        self.onMonitorFeedbackAvailable = channel.unary_unary(
                '/SinkService/onMonitorFeedbackAvailable',
                request_serializer=sink__pb2.FeedbackMessage.SerializeToString,
                response_deserializer=common__pb2.EmptyResponse.FromString,
                )


class SinkServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def onStepDetected(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onVideoFrameAvailable(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onProximityChanged(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onHeartRateChanged(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def setAccelerationMaxRange(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onMotionDetected(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onTemperatureChanged(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onAccelerationChanged(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onMonitorFeedbackAvailable(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_SinkServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'onStepDetected': grpc.unary_unary_rpc_method_handler(
                    servicer.onStepDetected,
                    request_deserializer=sink__pb2.StepDetectionMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onVideoFrameAvailable': grpc.unary_unary_rpc_method_handler(
                    servicer.onVideoFrameAvailable,
                    request_deserializer=sink__pb2.VideoMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onProximityChanged': grpc.unary_unary_rpc_method_handler(
                    servicer.onProximityChanged,
                    request_deserializer=sink__pb2.ProximityMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onHeartRateChanged': grpc.unary_unary_rpc_method_handler(
                    servicer.onHeartRateChanged,
                    request_deserializer=sink__pb2.HeartBeatMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'setAccelerationMaxRange': grpc.unary_unary_rpc_method_handler(
                    servicer.setAccelerationMaxRange,
                    request_deserializer=sink__pb2.RangeMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onMotionDetected': grpc.unary_unary_rpc_method_handler(
                    servicer.onMotionDetected,
                    request_deserializer=sink__pb2.MotionDetectionMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onTemperatureChanged': grpc.unary_unary_rpc_method_handler(
                    servicer.onTemperatureChanged,
                    request_deserializer=sink__pb2.TemperatureMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
            'onAccelerationChanged': grpc.unary_unary_rpc_method_handler(
                    servicer.onAccelerationChanged,
                    request_deserializer=sink__pb2.AccelerationMessage.FromString,
                    response_serializer=sink__pb2.BoolResponse.SerializeToString,
            ),
            'onMonitorFeedbackAvailable': grpc.unary_unary_rpc_method_handler(
                    servicer.onMonitorFeedbackAvailable,
                    request_deserializer=sink__pb2.FeedbackMessage.FromString,
                    response_serializer=common__pb2.EmptyResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'SinkService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class SinkService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def onStepDetected(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onStepDetected',
            sink__pb2.StepDetectionMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onVideoFrameAvailable(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onVideoFrameAvailable',
            sink__pb2.VideoMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onProximityChanged(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onProximityChanged',
            sink__pb2.ProximityMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onHeartRateChanged(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onHeartRateChanged',
            sink__pb2.HeartBeatMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def setAccelerationMaxRange(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/setAccelerationMaxRange',
            sink__pb2.RangeMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onMotionDetected(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onMotionDetected',
            sink__pb2.MotionDetectionMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onTemperatureChanged(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onTemperatureChanged',
            sink__pb2.TemperatureMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onAccelerationChanged(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onAccelerationChanged',
            sink__pb2.AccelerationMessage.SerializeToString,
            sink__pb2.BoolResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onMonitorFeedbackAvailable(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/SinkService/onMonitorFeedbackAvailable',
            sink__pb2.FeedbackMessage.SerializeToString,
            common__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
