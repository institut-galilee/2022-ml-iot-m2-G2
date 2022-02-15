package mliot.monitor.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: monitor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MonitorServiceGrpc {

  private MonitorServiceGrpc() {}

  public static final String SERVICE_NAME = "MonitorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.EmptyMessage,
      mliot.monitor.generated.KnownStudentResponse> getFetchKnownStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchKnownStudents",
      requestType = mliot.monitor.generated.EmptyMessage.class,
      responseType = mliot.monitor.generated.KnownStudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.EmptyMessage,
      mliot.monitor.generated.KnownStudentResponse> getFetchKnownStudentsMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.EmptyMessage, mliot.monitor.generated.KnownStudentResponse> getFetchKnownStudentsMethod;
    if ((getFetchKnownStudentsMethod = MonitorServiceGrpc.getFetchKnownStudentsMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getFetchKnownStudentsMethod = MonitorServiceGrpc.getFetchKnownStudentsMethod) == null) {
          MonitorServiceGrpc.getFetchKnownStudentsMethod = getFetchKnownStudentsMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.EmptyMessage, mliot.monitor.generated.KnownStudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchKnownStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.KnownStudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("fetchKnownStudents"))
              .build();
        }
      }
    }
    return getFetchKnownStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.StudentConnectionMessage,
      mliot.monitor.generated.StudentConnectionResponse> getOnStudentConnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onStudentConnected",
      requestType = mliot.monitor.generated.StudentConnectionMessage.class,
      responseType = mliot.monitor.generated.StudentConnectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.StudentConnectionMessage,
      mliot.monitor.generated.StudentConnectionResponse> getOnStudentConnectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.StudentConnectionMessage, mliot.monitor.generated.StudentConnectionResponse> getOnStudentConnectedMethod;
    if ((getOnStudentConnectedMethod = MonitorServiceGrpc.getOnStudentConnectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnStudentConnectedMethod = MonitorServiceGrpc.getOnStudentConnectedMethod) == null) {
          MonitorServiceGrpc.getOnStudentConnectedMethod = getOnStudentConnectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.StudentConnectionMessage, mliot.monitor.generated.StudentConnectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onStudentConnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.StudentConnectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.StudentConnectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onStudentConnected"))
              .build();
        }
      }
    }
    return getOnStudentConnectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.MovementDetectionMessage,
      mliot.monitor.generated.EmptyResponse> getOnMovementDetectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onMovementDetected",
      requestType = mliot.monitor.generated.MovementDetectionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.MovementDetectionMessage,
      mliot.monitor.generated.EmptyResponse> getOnMovementDetectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.MovementDetectionMessage, mliot.monitor.generated.EmptyResponse> getOnMovementDetectedMethod;
    if ((getOnMovementDetectedMethod = MonitorServiceGrpc.getOnMovementDetectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnMovementDetectedMethod = MonitorServiceGrpc.getOnMovementDetectedMethod) == null) {
          MonitorServiceGrpc.getOnMovementDetectedMethod = getOnMovementDetectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.MovementDetectionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onMovementDetected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.MovementDetectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onMovementDetected"))
              .build();
        }
      }
    }
    return getOnMovementDetectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.SpeechRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnMicrophoneSpeechRecognizedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onMicrophoneSpeechRecognized",
      requestType = mliot.monitor.generated.SpeechRecognitionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.SpeechRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnMicrophoneSpeechRecognizedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.SpeechRecognitionMessage, mliot.monitor.generated.EmptyResponse> getOnMicrophoneSpeechRecognizedMethod;
    if ((getOnMicrophoneSpeechRecognizedMethod = MonitorServiceGrpc.getOnMicrophoneSpeechRecognizedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnMicrophoneSpeechRecognizedMethod = MonitorServiceGrpc.getOnMicrophoneSpeechRecognizedMethod) == null) {
          MonitorServiceGrpc.getOnMicrophoneSpeechRecognizedMethod = getOnMicrophoneSpeechRecognizedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.SpeechRecognitionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onMicrophoneSpeechRecognized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.SpeechRecognitionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onMicrophoneSpeechRecognized"))
              .build();
        }
      }
    }
    return getOnMicrophoneSpeechRecognizedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.BrowserSizeMessage,
      mliot.monitor.generated.EmptyResponse> getOnBrowserSizeNotFittingScreenSizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onBrowserSizeNotFittingScreenSize",
      requestType = mliot.monitor.generated.BrowserSizeMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.BrowserSizeMessage,
      mliot.monitor.generated.EmptyResponse> getOnBrowserSizeNotFittingScreenSizeMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.BrowserSizeMessage, mliot.monitor.generated.EmptyResponse> getOnBrowserSizeNotFittingScreenSizeMethod;
    if ((getOnBrowserSizeNotFittingScreenSizeMethod = MonitorServiceGrpc.getOnBrowserSizeNotFittingScreenSizeMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnBrowserSizeNotFittingScreenSizeMethod = MonitorServiceGrpc.getOnBrowserSizeNotFittingScreenSizeMethod) == null) {
          MonitorServiceGrpc.getOnBrowserSizeNotFittingScreenSizeMethod = getOnBrowserSizeNotFittingScreenSizeMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.BrowserSizeMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onBrowserSizeNotFittingScreenSize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.BrowserSizeMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onBrowserSizeNotFittingScreenSize"))
              .build();
        }
      }
    }
    return getOnBrowserSizeNotFittingScreenSizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.ScreenshotTextRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnScreenshotTextRecognizedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onScreenshotTextRecognized",
      requestType = mliot.monitor.generated.ScreenshotTextRecognitionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.ScreenshotTextRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnScreenshotTextRecognizedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.ScreenshotTextRecognitionMessage, mliot.monitor.generated.EmptyResponse> getOnScreenshotTextRecognizedMethod;
    if ((getOnScreenshotTextRecognizedMethod = MonitorServiceGrpc.getOnScreenshotTextRecognizedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnScreenshotTextRecognizedMethod = MonitorServiceGrpc.getOnScreenshotTextRecognizedMethod) == null) {
          MonitorServiceGrpc.getOnScreenshotTextRecognizedMethod = getOnScreenshotTextRecognizedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.ScreenshotTextRecognitionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onScreenshotTextRecognized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.ScreenshotTextRecognitionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onScreenshotTextRecognized"))
              .build();
        }
      }
    }
    return getOnScreenshotTextRecognizedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.QRCodeVerificationMessage,
      mliot.monitor.generated.EmptyResponse> getOnQRCodeVerificationFailedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onQRCodeVerificationFailed",
      requestType = mliot.monitor.generated.QRCodeVerificationMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.QRCodeVerificationMessage,
      mliot.monitor.generated.EmptyResponse> getOnQRCodeVerificationFailedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.QRCodeVerificationMessage, mliot.monitor.generated.EmptyResponse> getOnQRCodeVerificationFailedMethod;
    if ((getOnQRCodeVerificationFailedMethod = MonitorServiceGrpc.getOnQRCodeVerificationFailedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnQRCodeVerificationFailedMethod = MonitorServiceGrpc.getOnQRCodeVerificationFailedMethod) == null) {
          MonitorServiceGrpc.getOnQRCodeVerificationFailedMethod = getOnQRCodeVerificationFailedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.QRCodeVerificationMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onQRCodeVerificationFailed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.QRCodeVerificationMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onQRCodeVerificationFailed"))
              .build();
        }
      }
    }
    return getOnQRCodeVerificationFailedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.StudentFraudMessage,
      mliot.monitor.generated.EmptyResponse> getOnStudentNotAllowedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onStudentNotAllowed",
      requestType = mliot.monitor.generated.StudentFraudMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.StudentFraudMessage,
      mliot.monitor.generated.EmptyResponse> getOnStudentNotAllowedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.StudentFraudMessage, mliot.monitor.generated.EmptyResponse> getOnStudentNotAllowedMethod;
    if ((getOnStudentNotAllowedMethod = MonitorServiceGrpc.getOnStudentNotAllowedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnStudentNotAllowedMethod = MonitorServiceGrpc.getOnStudentNotAllowedMethod) == null) {
          MonitorServiceGrpc.getOnStudentNotAllowedMethod = getOnStudentNotAllowedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.StudentFraudMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onStudentNotAllowed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.StudentFraudMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onStudentNotAllowed"))
              .build();
        }
      }
    }
    return getOnStudentNotAllowedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.FaceRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnFaceNotRecognizedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onFaceNotRecognized",
      requestType = mliot.monitor.generated.FaceRecognitionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.FaceRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnFaceNotRecognizedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.FaceRecognitionMessage, mliot.monitor.generated.EmptyResponse> getOnFaceNotRecognizedMethod;
    if ((getOnFaceNotRecognizedMethod = MonitorServiceGrpc.getOnFaceNotRecognizedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnFaceNotRecognizedMethod = MonitorServiceGrpc.getOnFaceNotRecognizedMethod) == null) {
          MonitorServiceGrpc.getOnFaceNotRecognizedMethod = getOnFaceNotRecognizedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.FaceRecognitionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onFaceNotRecognized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.FaceRecognitionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onFaceNotRecognized"))
              .build();
        }
      }
    }
    return getOnFaceNotRecognizedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.WebCameraRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnWebCameraObjectsRecognizedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onWebCameraObjectsRecognized",
      requestType = mliot.monitor.generated.WebCameraRecognitionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.WebCameraRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnWebCameraObjectsRecognizedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.WebCameraRecognitionMessage, mliot.monitor.generated.EmptyResponse> getOnWebCameraObjectsRecognizedMethod;
    if ((getOnWebCameraObjectsRecognizedMethod = MonitorServiceGrpc.getOnWebCameraObjectsRecognizedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnWebCameraObjectsRecognizedMethod = MonitorServiceGrpc.getOnWebCameraObjectsRecognizedMethod) == null) {
          MonitorServiceGrpc.getOnWebCameraObjectsRecognizedMethod = getOnWebCameraObjectsRecognizedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.WebCameraRecognitionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onWebCameraObjectsRecognized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.WebCameraRecognitionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onWebCameraObjectsRecognized"))
              .build();
        }
      }
    }
    return getOnWebCameraObjectsRecognizedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.PhoneCameraRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnPhoneCameraObjectsRecognizedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onPhoneCameraObjectsRecognized",
      requestType = mliot.monitor.generated.PhoneCameraRecognitionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.PhoneCameraRecognitionMessage,
      mliot.monitor.generated.EmptyResponse> getOnPhoneCameraObjectsRecognizedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.PhoneCameraRecognitionMessage, mliot.monitor.generated.EmptyResponse> getOnPhoneCameraObjectsRecognizedMethod;
    if ((getOnPhoneCameraObjectsRecognizedMethod = MonitorServiceGrpc.getOnPhoneCameraObjectsRecognizedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnPhoneCameraObjectsRecognizedMethod = MonitorServiceGrpc.getOnPhoneCameraObjectsRecognizedMethod) == null) {
          MonitorServiceGrpc.getOnPhoneCameraObjectsRecognizedMethod = getOnPhoneCameraObjectsRecognizedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.PhoneCameraRecognitionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onPhoneCameraObjectsRecognized"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.PhoneCameraRecognitionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onPhoneCameraObjectsRecognized"))
              .build();
        }
      }
    }
    return getOnPhoneCameraObjectsRecognizedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.UnAuthorizedMonitorMessage,
      mliot.monitor.generated.EmptyResponse> getOnUnAuthorizedMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onUnAuthorizedMonitor",
      requestType = mliot.monitor.generated.UnAuthorizedMonitorMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.UnAuthorizedMonitorMessage,
      mliot.monitor.generated.EmptyResponse> getOnUnAuthorizedMonitorMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.UnAuthorizedMonitorMessage, mliot.monitor.generated.EmptyResponse> getOnUnAuthorizedMonitorMethod;
    if ((getOnUnAuthorizedMonitorMethod = MonitorServiceGrpc.getOnUnAuthorizedMonitorMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnUnAuthorizedMonitorMethod = MonitorServiceGrpc.getOnUnAuthorizedMonitorMethod) == null) {
          MonitorServiceGrpc.getOnUnAuthorizedMonitorMethod = getOnUnAuthorizedMonitorMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.UnAuthorizedMonitorMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onUnAuthorizedMonitor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.UnAuthorizedMonitorMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onUnAuthorizedMonitor"))
              .build();
        }
      }
    }
    return getOnUnAuthorizedMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.HighAccelerationMessage,
      mliot.monitor.generated.EmptyResponse> getOnHighAccelerationNoticedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onHighAccelerationNoticed",
      requestType = mliot.monitor.generated.HighAccelerationMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.HighAccelerationMessage,
      mliot.monitor.generated.EmptyResponse> getOnHighAccelerationNoticedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.HighAccelerationMessage, mliot.monitor.generated.EmptyResponse> getOnHighAccelerationNoticedMethod;
    if ((getOnHighAccelerationNoticedMethod = MonitorServiceGrpc.getOnHighAccelerationNoticedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnHighAccelerationNoticedMethod = MonitorServiceGrpc.getOnHighAccelerationNoticedMethod) == null) {
          MonitorServiceGrpc.getOnHighAccelerationNoticedMethod = getOnHighAccelerationNoticedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.HighAccelerationMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onHighAccelerationNoticed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.HighAccelerationMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onHighAccelerationNoticed"))
              .build();
        }
      }
    }
    return getOnHighAccelerationNoticedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.HandDeviceMessage,
      mliot.monitor.generated.EmptyResponse> getOnHandDeviceStateChangedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onHandDeviceStateChanged",
      requestType = mliot.monitor.generated.HandDeviceMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.HandDeviceMessage,
      mliot.monitor.generated.EmptyResponse> getOnHandDeviceStateChangedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.HandDeviceMessage, mliot.monitor.generated.EmptyResponse> getOnHandDeviceStateChangedMethod;
    if ((getOnHandDeviceStateChangedMethod = MonitorServiceGrpc.getOnHandDeviceStateChangedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnHandDeviceStateChangedMethod = MonitorServiceGrpc.getOnHandDeviceStateChangedMethod) == null) {
          MonitorServiceGrpc.getOnHandDeviceStateChangedMethod = getOnHandDeviceStateChangedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.HandDeviceMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onHandDeviceStateChanged"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.HandDeviceMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onHandDeviceStateChanged"))
              .build();
        }
      }
    }
    return getOnHandDeviceStateChangedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.StudentDisconnectionMessage,
      mliot.monitor.generated.EmptyResponse> getOnStudentDisconnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onStudentDisconnected",
      requestType = mliot.monitor.generated.StudentDisconnectionMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.StudentDisconnectionMessage,
      mliot.monitor.generated.EmptyResponse> getOnStudentDisconnectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.StudentDisconnectionMessage, mliot.monitor.generated.EmptyResponse> getOnStudentDisconnectedMethod;
    if ((getOnStudentDisconnectedMethod = MonitorServiceGrpc.getOnStudentDisconnectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnStudentDisconnectedMethod = MonitorServiceGrpc.getOnStudentDisconnectedMethod) == null) {
          MonitorServiceGrpc.getOnStudentDisconnectedMethod = getOnStudentDisconnectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.StudentDisconnectionMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onStudentDisconnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.StudentDisconnectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onStudentDisconnected"))
              .build();
        }
      }
    }
    return getOnStudentDisconnectedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorServiceStub>() {
        @java.lang.Override
        public MonitorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorServiceStub(channel, callOptions);
        }
      };
    return MonitorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorServiceBlockingStub>() {
        @java.lang.Override
        public MonitorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorServiceBlockingStub(channel, callOptions);
        }
      };
    return MonitorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitorServiceFutureStub>() {
        @java.lang.Override
        public MonitorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitorServiceFutureStub(channel, callOptions);
        }
      };
    return MonitorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MonitorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchKnownStudents(mliot.monitor.generated.EmptyMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.KnownStudentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchKnownStudentsMethod(), responseObserver);
    }

    /**
     */
    public void onStudentConnected(mliot.monitor.generated.StudentConnectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.StudentConnectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnStudentConnectedMethod(), responseObserver);
    }

    /**
     */
    public void onMovementDetected(mliot.monitor.generated.MovementDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMovementDetectedMethod(), responseObserver);
    }

    /**
     */
    public void onMicrophoneSpeechRecognized(mliot.monitor.generated.SpeechRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMicrophoneSpeechRecognizedMethod(), responseObserver);
    }

    /**
     */
    public void onBrowserSizeNotFittingScreenSize(mliot.monitor.generated.BrowserSizeMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnBrowserSizeNotFittingScreenSizeMethod(), responseObserver);
    }

    /**
     */
    public void onScreenshotTextRecognized(mliot.monitor.generated.ScreenshotTextRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnScreenshotTextRecognizedMethod(), responseObserver);
    }

    /**
     */
    public void onQRCodeVerificationFailed(mliot.monitor.generated.QRCodeVerificationMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnQRCodeVerificationFailedMethod(), responseObserver);
    }

    /**
     */
    public void onStudentNotAllowed(mliot.monitor.generated.StudentFraudMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnStudentNotAllowedMethod(), responseObserver);
    }

    /**
     */
    public void onFaceNotRecognized(mliot.monitor.generated.FaceRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnFaceNotRecognizedMethod(), responseObserver);
    }

    /**
     */
    public void onWebCameraObjectsRecognized(mliot.monitor.generated.WebCameraRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnWebCameraObjectsRecognizedMethod(), responseObserver);
    }

    /**
     */
    public void onPhoneCameraObjectsRecognized(mliot.monitor.generated.PhoneCameraRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnPhoneCameraObjectsRecognizedMethod(), responseObserver);
    }

    /**
     */
    public void onUnAuthorizedMonitor(mliot.monitor.generated.UnAuthorizedMonitorMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnUnAuthorizedMonitorMethod(), responseObserver);
    }

    /**
     */
    public void onHighAccelerationNoticed(mliot.monitor.generated.HighAccelerationMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnHighAccelerationNoticedMethod(), responseObserver);
    }

    /**
     */
    public void onHandDeviceStateChanged(mliot.monitor.generated.HandDeviceMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnHandDeviceStateChangedMethod(), responseObserver);
    }

    /**
     */
    public void onStudentDisconnected(mliot.monitor.generated.StudentDisconnectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnStudentDisconnectedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchKnownStudentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                mliot.monitor.generated.EmptyMessage,
                mliot.monitor.generated.KnownStudentResponse>(
                  this, METHODID_FETCH_KNOWN_STUDENTS)))
          .addMethod(
            getOnStudentConnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.StudentConnectionMessage,
                mliot.monitor.generated.StudentConnectionResponse>(
                  this, METHODID_ON_STUDENT_CONNECTED)))
          .addMethod(
            getOnMovementDetectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.MovementDetectionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_MOVEMENT_DETECTED)))
          .addMethod(
            getOnMicrophoneSpeechRecognizedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.SpeechRecognitionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_MICROPHONE_SPEECH_RECOGNIZED)))
          .addMethod(
            getOnBrowserSizeNotFittingScreenSizeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.BrowserSizeMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_BROWSER_SIZE_NOT_FITTING_SCREEN_SIZE)))
          .addMethod(
            getOnScreenshotTextRecognizedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.ScreenshotTextRecognitionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_SCREENSHOT_TEXT_RECOGNIZED)))
          .addMethod(
            getOnQRCodeVerificationFailedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.QRCodeVerificationMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_QRCODE_VERIFICATION_FAILED)))
          .addMethod(
            getOnStudentNotAllowedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.StudentFraudMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_STUDENT_NOT_ALLOWED)))
          .addMethod(
            getOnFaceNotRecognizedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.FaceRecognitionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_FACE_NOT_RECOGNIZED)))
          .addMethod(
            getOnWebCameraObjectsRecognizedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.WebCameraRecognitionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_WEB_CAMERA_OBJECTS_RECOGNIZED)))
          .addMethod(
            getOnPhoneCameraObjectsRecognizedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.PhoneCameraRecognitionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_PHONE_CAMERA_OBJECTS_RECOGNIZED)))
          .addMethod(
            getOnUnAuthorizedMonitorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.UnAuthorizedMonitorMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_UN_AUTHORIZED_MONITOR)))
          .addMethod(
            getOnHighAccelerationNoticedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.HighAccelerationMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_HIGH_ACCELERATION_NOTICED)))
          .addMethod(
            getOnHandDeviceStateChangedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.HandDeviceMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_HAND_DEVICE_STATE_CHANGED)))
          .addMethod(
            getOnStudentDisconnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.StudentDisconnectionMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_STUDENT_DISCONNECTED)))
          .build();
    }
  }

  /**
   */
  public static final class MonitorServiceStub extends io.grpc.stub.AbstractAsyncStub<MonitorServiceStub> {
    private MonitorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchKnownStudents(mliot.monitor.generated.EmptyMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.KnownStudentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFetchKnownStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onStudentConnected(mliot.monitor.generated.StudentConnectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.StudentConnectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnStudentConnectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMovementDetected(mliot.monitor.generated.MovementDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMovementDetectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMicrophoneSpeechRecognized(mliot.monitor.generated.SpeechRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMicrophoneSpeechRecognizedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onBrowserSizeNotFittingScreenSize(mliot.monitor.generated.BrowserSizeMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnBrowserSizeNotFittingScreenSizeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onScreenshotTextRecognized(mliot.monitor.generated.ScreenshotTextRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnScreenshotTextRecognizedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onQRCodeVerificationFailed(mliot.monitor.generated.QRCodeVerificationMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnQRCodeVerificationFailedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onStudentNotAllowed(mliot.monitor.generated.StudentFraudMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnStudentNotAllowedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onFaceNotRecognized(mliot.monitor.generated.FaceRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnFaceNotRecognizedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onWebCameraObjectsRecognized(mliot.monitor.generated.WebCameraRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnWebCameraObjectsRecognizedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onPhoneCameraObjectsRecognized(mliot.monitor.generated.PhoneCameraRecognitionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnPhoneCameraObjectsRecognizedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onUnAuthorizedMonitor(mliot.monitor.generated.UnAuthorizedMonitorMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnUnAuthorizedMonitorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onHighAccelerationNoticed(mliot.monitor.generated.HighAccelerationMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnHighAccelerationNoticedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onHandDeviceStateChanged(mliot.monitor.generated.HandDeviceMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnHandDeviceStateChangedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onStudentDisconnected(mliot.monitor.generated.StudentDisconnectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnStudentDisconnectedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MonitorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MonitorServiceBlockingStub> {
    private MonitorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<mliot.monitor.generated.KnownStudentResponse> fetchKnownStudents(
        mliot.monitor.generated.EmptyMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFetchKnownStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.StudentConnectionResponse onStudentConnected(mliot.monitor.generated.StudentConnectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnStudentConnectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onMovementDetected(mliot.monitor.generated.MovementDetectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMovementDetectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onMicrophoneSpeechRecognized(mliot.monitor.generated.SpeechRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMicrophoneSpeechRecognizedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onBrowserSizeNotFittingScreenSize(mliot.monitor.generated.BrowserSizeMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnBrowserSizeNotFittingScreenSizeMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onScreenshotTextRecognized(mliot.monitor.generated.ScreenshotTextRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnScreenshotTextRecognizedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onQRCodeVerificationFailed(mliot.monitor.generated.QRCodeVerificationMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnQRCodeVerificationFailedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onStudentNotAllowed(mliot.monitor.generated.StudentFraudMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnStudentNotAllowedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onFaceNotRecognized(mliot.monitor.generated.FaceRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnFaceNotRecognizedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onWebCameraObjectsRecognized(mliot.monitor.generated.WebCameraRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnWebCameraObjectsRecognizedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onPhoneCameraObjectsRecognized(mliot.monitor.generated.PhoneCameraRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnPhoneCameraObjectsRecognizedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onUnAuthorizedMonitor(mliot.monitor.generated.UnAuthorizedMonitorMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnUnAuthorizedMonitorMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onHighAccelerationNoticed(mliot.monitor.generated.HighAccelerationMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnHighAccelerationNoticedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onHandDeviceStateChanged(mliot.monitor.generated.HandDeviceMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnHandDeviceStateChangedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onStudentDisconnected(mliot.monitor.generated.StudentDisconnectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnStudentDisconnectedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MonitorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MonitorServiceFutureStub> {
    private MonitorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.StudentConnectionResponse> onStudentConnected(
        mliot.monitor.generated.StudentConnectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnStudentConnectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onMovementDetected(
        mliot.monitor.generated.MovementDetectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMovementDetectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onMicrophoneSpeechRecognized(
        mliot.monitor.generated.SpeechRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMicrophoneSpeechRecognizedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onBrowserSizeNotFittingScreenSize(
        mliot.monitor.generated.BrowserSizeMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnBrowserSizeNotFittingScreenSizeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onScreenshotTextRecognized(
        mliot.monitor.generated.ScreenshotTextRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnScreenshotTextRecognizedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onQRCodeVerificationFailed(
        mliot.monitor.generated.QRCodeVerificationMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnQRCodeVerificationFailedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onStudentNotAllowed(
        mliot.monitor.generated.StudentFraudMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnStudentNotAllowedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onFaceNotRecognized(
        mliot.monitor.generated.FaceRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnFaceNotRecognizedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onWebCameraObjectsRecognized(
        mliot.monitor.generated.WebCameraRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnWebCameraObjectsRecognizedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onPhoneCameraObjectsRecognized(
        mliot.monitor.generated.PhoneCameraRecognitionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnPhoneCameraObjectsRecognizedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onUnAuthorizedMonitor(
        mliot.monitor.generated.UnAuthorizedMonitorMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnUnAuthorizedMonitorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onHighAccelerationNoticed(
        mliot.monitor.generated.HighAccelerationMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnHighAccelerationNoticedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onHandDeviceStateChanged(
        mliot.monitor.generated.HandDeviceMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnHandDeviceStateChangedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onStudentDisconnected(
        mliot.monitor.generated.StudentDisconnectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnStudentDisconnectedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_KNOWN_STUDENTS = 0;
  private static final int METHODID_ON_STUDENT_CONNECTED = 1;
  private static final int METHODID_ON_MOVEMENT_DETECTED = 2;
  private static final int METHODID_ON_MICROPHONE_SPEECH_RECOGNIZED = 3;
  private static final int METHODID_ON_BROWSER_SIZE_NOT_FITTING_SCREEN_SIZE = 4;
  private static final int METHODID_ON_SCREENSHOT_TEXT_RECOGNIZED = 5;
  private static final int METHODID_ON_QRCODE_VERIFICATION_FAILED = 6;
  private static final int METHODID_ON_STUDENT_NOT_ALLOWED = 7;
  private static final int METHODID_ON_FACE_NOT_RECOGNIZED = 8;
  private static final int METHODID_ON_WEB_CAMERA_OBJECTS_RECOGNIZED = 9;
  private static final int METHODID_ON_PHONE_CAMERA_OBJECTS_RECOGNIZED = 10;
  private static final int METHODID_ON_UN_AUTHORIZED_MONITOR = 11;
  private static final int METHODID_ON_HIGH_ACCELERATION_NOTICED = 12;
  private static final int METHODID_ON_HAND_DEVICE_STATE_CHANGED = 13;
  private static final int METHODID_ON_STUDENT_DISCONNECTED = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MonitorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MonitorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_KNOWN_STUDENTS:
          serviceImpl.fetchKnownStudents((mliot.monitor.generated.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.KnownStudentResponse>) responseObserver);
          break;
        case METHODID_ON_STUDENT_CONNECTED:
          serviceImpl.onStudentConnected((mliot.monitor.generated.StudentConnectionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.StudentConnectionResponse>) responseObserver);
          break;
        case METHODID_ON_MOVEMENT_DETECTED:
          serviceImpl.onMovementDetected((mliot.monitor.generated.MovementDetectionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_MICROPHONE_SPEECH_RECOGNIZED:
          serviceImpl.onMicrophoneSpeechRecognized((mliot.monitor.generated.SpeechRecognitionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_BROWSER_SIZE_NOT_FITTING_SCREEN_SIZE:
          serviceImpl.onBrowserSizeNotFittingScreenSize((mliot.monitor.generated.BrowserSizeMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_SCREENSHOT_TEXT_RECOGNIZED:
          serviceImpl.onScreenshotTextRecognized((mliot.monitor.generated.ScreenshotTextRecognitionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_QRCODE_VERIFICATION_FAILED:
          serviceImpl.onQRCodeVerificationFailed((mliot.monitor.generated.QRCodeVerificationMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_STUDENT_NOT_ALLOWED:
          serviceImpl.onStudentNotAllowed((mliot.monitor.generated.StudentFraudMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_FACE_NOT_RECOGNIZED:
          serviceImpl.onFaceNotRecognized((mliot.monitor.generated.FaceRecognitionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_WEB_CAMERA_OBJECTS_RECOGNIZED:
          serviceImpl.onWebCameraObjectsRecognized((mliot.monitor.generated.WebCameraRecognitionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_PHONE_CAMERA_OBJECTS_RECOGNIZED:
          serviceImpl.onPhoneCameraObjectsRecognized((mliot.monitor.generated.PhoneCameraRecognitionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_UN_AUTHORIZED_MONITOR:
          serviceImpl.onUnAuthorizedMonitor((mliot.monitor.generated.UnAuthorizedMonitorMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_HIGH_ACCELERATION_NOTICED:
          serviceImpl.onHighAccelerationNoticed((mliot.monitor.generated.HighAccelerationMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_HAND_DEVICE_STATE_CHANGED:
          serviceImpl.onHandDeviceStateChanged((mliot.monitor.generated.HandDeviceMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        case METHODID_ON_STUDENT_DISCONNECTED:
          serviceImpl.onStudentDisconnected((mliot.monitor.generated.StudentDisconnectionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return mliot.monitor.generated.Monitor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MonitorService");
    }
  }

  private static final class MonitorServiceFileDescriptorSupplier
      extends MonitorServiceBaseDescriptorSupplier {
    MonitorServiceFileDescriptorSupplier() {}
  }

  private static final class MonitorServiceMethodDescriptorSupplier
      extends MonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MonitorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MonitorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitorServiceFileDescriptorSupplier())
              .addMethod(getFetchKnownStudentsMethod())
              .addMethod(getOnStudentConnectedMethod())
              .addMethod(getOnMovementDetectedMethod())
              .addMethod(getOnMicrophoneSpeechRecognizedMethod())
              .addMethod(getOnBrowserSizeNotFittingScreenSizeMethod())
              .addMethod(getOnScreenshotTextRecognizedMethod())
              .addMethod(getOnQRCodeVerificationFailedMethod())
              .addMethod(getOnStudentNotAllowedMethod())
              .addMethod(getOnFaceNotRecognizedMethod())
              .addMethod(getOnWebCameraObjectsRecognizedMethod())
              .addMethod(getOnPhoneCameraObjectsRecognizedMethod())
              .addMethod(getOnUnAuthorizedMonitorMethod())
              .addMethod(getOnHighAccelerationNoticedMethod())
              .addMethod(getOnHandDeviceStateChangedMethod())
              .addMethod(getOnStudentDisconnectedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
