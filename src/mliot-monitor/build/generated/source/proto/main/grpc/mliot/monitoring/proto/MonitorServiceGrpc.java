package mliot.monitoring.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: monitoring.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MonitorServiceGrpc {

  private MonitorServiceGrpc() {}

  public static final String SERVICE_NAME = "MonitorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<mliot.monitoring.proto.StepDetectionMessage,
      mliot.monitoring.proto.Response> getOnStepDetectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onStepDetected",
      requestType = mliot.monitoring.proto.StepDetectionMessage.class,
      responseType = mliot.monitoring.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitoring.proto.StepDetectionMessage,
      mliot.monitoring.proto.Response> getOnStepDetectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitoring.proto.StepDetectionMessage, mliot.monitoring.proto.Response> getOnStepDetectedMethod;
    if ((getOnStepDetectedMethod = MonitorServiceGrpc.getOnStepDetectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnStepDetectedMethod = MonitorServiceGrpc.getOnStepDetectedMethod) == null) {
          MonitorServiceGrpc.getOnStepDetectedMethod = getOnStepDetectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitoring.proto.StepDetectionMessage, mliot.monitoring.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onStepDetected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.StepDetectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onStepDetected"))
              .build();
        }
      }
    }
    return getOnStepDetectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitoring.proto.ProximityMessage,
      mliot.monitoring.proto.Response> getOnProximityDetectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onProximityDetected",
      requestType = mliot.monitoring.proto.ProximityMessage.class,
      responseType = mliot.monitoring.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitoring.proto.ProximityMessage,
      mliot.monitoring.proto.Response> getOnProximityDetectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitoring.proto.ProximityMessage, mliot.monitoring.proto.Response> getOnProximityDetectedMethod;
    if ((getOnProximityDetectedMethod = MonitorServiceGrpc.getOnProximityDetectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnProximityDetectedMethod = MonitorServiceGrpc.getOnProximityDetectedMethod) == null) {
          MonitorServiceGrpc.getOnProximityDetectedMethod = getOnProximityDetectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitoring.proto.ProximityMessage, mliot.monitoring.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onProximityDetected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.ProximityMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onProximityDetected"))
              .build();
        }
      }
    }
    return getOnProximityDetectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mliot.monitoring.proto.MotionDetectionMessage,
      mliot.monitoring.proto.Response> getOnMotionDetectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onMotionDetected",
      requestType = mliot.monitoring.proto.MotionDetectionMessage.class,
      responseType = mliot.monitoring.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitoring.proto.MotionDetectionMessage,
      mliot.monitoring.proto.Response> getOnMotionDetectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitoring.proto.MotionDetectionMessage, mliot.monitoring.proto.Response> getOnMotionDetectedMethod;
    if ((getOnMotionDetectedMethod = MonitorServiceGrpc.getOnMotionDetectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnMotionDetectedMethod = MonitorServiceGrpc.getOnMotionDetectedMethod) == null) {
          MonitorServiceGrpc.getOnMotionDetectedMethod = getOnMotionDetectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitoring.proto.MotionDetectionMessage, mliot.monitoring.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onMotionDetected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.MotionDetectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitoring.proto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onMotionDetected"))
              .build();
        }
      }
    }
    return getOnMotionDetectedMethod;
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
    public void onStepDetected(mliot.monitoring.proto.StepDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnStepDetectedMethod(), responseObserver);
    }

    /**
     */
    public void onProximityDetected(mliot.monitoring.proto.ProximityMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnProximityDetectedMethod(), responseObserver);
    }

    /**
     */
    public void onMotionDetected(mliot.monitoring.proto.MotionDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMotionDetectedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnStepDetectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitoring.proto.StepDetectionMessage,
                mliot.monitoring.proto.Response>(
                  this, METHODID_ON_STEP_DETECTED)))
          .addMethod(
            getOnProximityDetectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitoring.proto.ProximityMessage,
                mliot.monitoring.proto.Response>(
                  this, METHODID_ON_PROXIMITY_DETECTED)))
          .addMethod(
            getOnMotionDetectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitoring.proto.MotionDetectionMessage,
                mliot.monitoring.proto.Response>(
                  this, METHODID_ON_MOTION_DETECTED)))
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
    public void onStepDetected(mliot.monitoring.proto.StepDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnStepDetectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onProximityDetected(mliot.monitoring.proto.ProximityMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnProximityDetectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMotionDetected(mliot.monitoring.proto.MotionDetectionMessage request,
        io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMotionDetectedMethod(), getCallOptions()), request, responseObserver);
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
    public mliot.monitoring.proto.Response onStepDetected(mliot.monitoring.proto.StepDetectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnStepDetectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitoring.proto.Response onProximityDetected(mliot.monitoring.proto.ProximityMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnProximityDetectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public mliot.monitoring.proto.Response onMotionDetected(mliot.monitoring.proto.MotionDetectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMotionDetectedMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitoring.proto.Response> onStepDetected(
        mliot.monitoring.proto.StepDetectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnStepDetectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitoring.proto.Response> onProximityDetected(
        mliot.monitoring.proto.ProximityMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnProximityDetectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitoring.proto.Response> onMotionDetected(
        mliot.monitoring.proto.MotionDetectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMotionDetectedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_STEP_DETECTED = 0;
  private static final int METHODID_ON_PROXIMITY_DETECTED = 1;
  private static final int METHODID_ON_MOTION_DETECTED = 2;

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
        case METHODID_ON_STEP_DETECTED:
          serviceImpl.onStepDetected((mliot.monitoring.proto.StepDetectionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response>) responseObserver);
          break;
        case METHODID_ON_PROXIMITY_DETECTED:
          serviceImpl.onProximityDetected((mliot.monitoring.proto.ProximityMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response>) responseObserver);
          break;
        case METHODID_ON_MOTION_DETECTED:
          serviceImpl.onMotionDetected((mliot.monitoring.proto.MotionDetectionMessage) request,
              (io.grpc.stub.StreamObserver<mliot.monitoring.proto.Response>) responseObserver);
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
      return mliot.monitoring.proto.Monitoring.getDescriptor();
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
              .addMethod(getOnStepDetectedMethod())
              .addMethod(getOnProximityDetectedMethod())
              .addMethod(getOnMotionDetectedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
