# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import monitor_pb2 as monitor__pb2


class MonitorServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.fetchKnownStudents = channel.unary_stream(
                '/MonitorService/fetchKnownStudents',
                request_serializer=monitor__pb2.EmptyMessage.SerializeToString,
                response_deserializer=monitor__pb2.KnownStudentResponse.FromString,
                )
        self.onStudentConnected = channel.unary_unary(
                '/MonitorService/onStudentConnected',
                request_serializer=monitor__pb2.StudentConnectionMessage.SerializeToString,
                response_deserializer=monitor__pb2.StudentConnectionResponse.FromString,
                )
        self.onMovementDetected = channel.unary_unary(
                '/MonitorService/onMovementDetected',
                request_serializer=monitor__pb2.MovementDetectionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onMicrophoneSpeechRecognized = channel.unary_unary(
                '/MonitorService/onMicrophoneSpeechRecognized',
                request_serializer=monitor__pb2.SpeechRecognitionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onBrowserSizeNotFittingScreenSize = channel.unary_unary(
                '/MonitorService/onBrowserSizeNotFittingScreenSize',
                request_serializer=monitor__pb2.BrowserSizeMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onScreenshotTextRecognized = channel.unary_unary(
                '/MonitorService/onScreenshotTextRecognized',
                request_serializer=monitor__pb2.ScreenshotTextRecognitionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onQRCodeVerificationFailed = channel.unary_unary(
                '/MonitorService/onQRCodeVerificationFailed',
                request_serializer=monitor__pb2.QRCodeVerificationMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onStudentNotAllowed = channel.unary_unary(
                '/MonitorService/onStudentNotAllowed',
                request_serializer=monitor__pb2.StudentFraudMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onFaceNotRecognized = channel.unary_unary(
                '/MonitorService/onFaceNotRecognized',
                request_serializer=monitor__pb2.FaceRecognitionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onWebCameraObjectsRecognized = channel.unary_unary(
                '/MonitorService/onWebCameraObjectsRecognized',
                request_serializer=monitor__pb2.WebCameraRecognitionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onPhoneCameraObjectsRecognized = channel.unary_unary(
                '/MonitorService/onPhoneCameraObjectsRecognized',
                request_serializer=monitor__pb2.PhoneCameraRecognitionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onUnAuthorizedMonitor = channel.unary_unary(
                '/MonitorService/onUnAuthorizedMonitor',
                request_serializer=monitor__pb2.UnAuthorizedMonitorMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onHighAccelerationNoticed = channel.unary_unary(
                '/MonitorService/onHighAccelerationNoticed',
                request_serializer=monitor__pb2.HighAccelerationMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onHandDeviceStateChanged = channel.unary_unary(
                '/MonitorService/onHandDeviceStateChanged',
                request_serializer=monitor__pb2.HandDeviceMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )
        self.onStudentDisconnected = channel.unary_unary(
                '/MonitorService/onStudentDisconnected',
                request_serializer=monitor__pb2.StudentDisconnectionMessage.SerializeToString,
                response_deserializer=monitor__pb2.EmptyResponse.FromString,
                )


class MonitorServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def fetchKnownStudents(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onStudentConnected(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onMovementDetected(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onMicrophoneSpeechRecognized(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onBrowserSizeNotFittingScreenSize(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onScreenshotTextRecognized(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onQRCodeVerificationFailed(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onStudentNotAllowed(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onFaceNotRecognized(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onWebCameraObjectsRecognized(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onPhoneCameraObjectsRecognized(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onUnAuthorizedMonitor(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onHighAccelerationNoticed(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onHandDeviceStateChanged(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def onStudentDisconnected(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_MonitorServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'fetchKnownStudents': grpc.unary_stream_rpc_method_handler(
                    servicer.fetchKnownStudents,
                    request_deserializer=monitor__pb2.EmptyMessage.FromString,
                    response_serializer=monitor__pb2.KnownStudentResponse.SerializeToString,
            ),
            'onStudentConnected': grpc.unary_unary_rpc_method_handler(
                    servicer.onStudentConnected,
                    request_deserializer=monitor__pb2.StudentConnectionMessage.FromString,
                    response_serializer=monitor__pb2.StudentConnectionResponse.SerializeToString,
            ),
            'onMovementDetected': grpc.unary_unary_rpc_method_handler(
                    servicer.onMovementDetected,
                    request_deserializer=monitor__pb2.MovementDetectionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onMicrophoneSpeechRecognized': grpc.unary_unary_rpc_method_handler(
                    servicer.onMicrophoneSpeechRecognized,
                    request_deserializer=monitor__pb2.SpeechRecognitionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onBrowserSizeNotFittingScreenSize': grpc.unary_unary_rpc_method_handler(
                    servicer.onBrowserSizeNotFittingScreenSize,
                    request_deserializer=monitor__pb2.BrowserSizeMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onScreenshotTextRecognized': grpc.unary_unary_rpc_method_handler(
                    servicer.onScreenshotTextRecognized,
                    request_deserializer=monitor__pb2.ScreenshotTextRecognitionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onQRCodeVerificationFailed': grpc.unary_unary_rpc_method_handler(
                    servicer.onQRCodeVerificationFailed,
                    request_deserializer=monitor__pb2.QRCodeVerificationMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onStudentNotAllowed': grpc.unary_unary_rpc_method_handler(
                    servicer.onStudentNotAllowed,
                    request_deserializer=monitor__pb2.StudentFraudMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onFaceNotRecognized': grpc.unary_unary_rpc_method_handler(
                    servicer.onFaceNotRecognized,
                    request_deserializer=monitor__pb2.FaceRecognitionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onWebCameraObjectsRecognized': grpc.unary_unary_rpc_method_handler(
                    servicer.onWebCameraObjectsRecognized,
                    request_deserializer=monitor__pb2.WebCameraRecognitionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onPhoneCameraObjectsRecognized': grpc.unary_unary_rpc_method_handler(
                    servicer.onPhoneCameraObjectsRecognized,
                    request_deserializer=monitor__pb2.PhoneCameraRecognitionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onUnAuthorizedMonitor': grpc.unary_unary_rpc_method_handler(
                    servicer.onUnAuthorizedMonitor,
                    request_deserializer=monitor__pb2.UnAuthorizedMonitorMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onHighAccelerationNoticed': grpc.unary_unary_rpc_method_handler(
                    servicer.onHighAccelerationNoticed,
                    request_deserializer=monitor__pb2.HighAccelerationMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onHandDeviceStateChanged': grpc.unary_unary_rpc_method_handler(
                    servicer.onHandDeviceStateChanged,
                    request_deserializer=monitor__pb2.HandDeviceMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
            'onStudentDisconnected': grpc.unary_unary_rpc_method_handler(
                    servicer.onStudentDisconnected,
                    request_deserializer=monitor__pb2.StudentDisconnectionMessage.FromString,
                    response_serializer=monitor__pb2.EmptyResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'MonitorService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class MonitorService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def fetchKnownStudents(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(request, target, '/MonitorService/fetchKnownStudents',
            monitor__pb2.EmptyMessage.SerializeToString,
            monitor__pb2.KnownStudentResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onStudentConnected(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onStudentConnected',
            monitor__pb2.StudentConnectionMessage.SerializeToString,
            monitor__pb2.StudentConnectionResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onMovementDetected(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onMovementDetected',
            monitor__pb2.MovementDetectionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onMicrophoneSpeechRecognized(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onMicrophoneSpeechRecognized',
            monitor__pb2.SpeechRecognitionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onBrowserSizeNotFittingScreenSize(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onBrowserSizeNotFittingScreenSize',
            monitor__pb2.BrowserSizeMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onScreenshotTextRecognized(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onScreenshotTextRecognized',
            monitor__pb2.ScreenshotTextRecognitionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onQRCodeVerificationFailed(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onQRCodeVerificationFailed',
            monitor__pb2.QRCodeVerificationMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onStudentNotAllowed(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onStudentNotAllowed',
            monitor__pb2.StudentFraudMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onFaceNotRecognized(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onFaceNotRecognized',
            monitor__pb2.FaceRecognitionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onWebCameraObjectsRecognized(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onWebCameraObjectsRecognized',
            monitor__pb2.WebCameraRecognitionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onPhoneCameraObjectsRecognized(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onPhoneCameraObjectsRecognized',
            monitor__pb2.PhoneCameraRecognitionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onUnAuthorizedMonitor(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onUnAuthorizedMonitor',
            monitor__pb2.UnAuthorizedMonitorMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onHighAccelerationNoticed(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onHighAccelerationNoticed',
            monitor__pb2.HighAccelerationMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onHandDeviceStateChanged(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onHandDeviceStateChanged',
            monitor__pb2.HandDeviceMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def onStudentDisconnected(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/MonitorService/onStudentDisconnected',
            monitor__pb2.StudentDisconnectionMessage.SerializeToString,
            monitor__pb2.EmptyResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
