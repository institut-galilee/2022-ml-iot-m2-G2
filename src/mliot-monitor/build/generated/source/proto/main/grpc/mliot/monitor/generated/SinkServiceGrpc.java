package mliot.monitor.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.0)",
    comments = "Source: sink.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SinkServiceGrpc {

  private SinkServiceGrpc() {}

  public static final String SERVICE_NAME = "SinkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<mliot.monitor.generated.FeedbackMessage,
      mliot.monitor.generated.EmptyResponse> getOnMonitorFeedbackAvailableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onMonitorFeedbackAvailable",
      requestType = mliot.monitor.generated.FeedbackMessage.class,
      responseType = mliot.monitor.generated.EmptyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.FeedbackMessage,
      mliot.monitor.generated.EmptyResponse> getOnMonitorFeedbackAvailableMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.FeedbackMessage, mliot.monitor.generated.EmptyResponse> getOnMonitorFeedbackAvailableMethod;
    if ((getOnMonitorFeedbackAvailableMethod = SinkServiceGrpc.getOnMonitorFeedbackAvailableMethod) == null) {
      synchronized (SinkServiceGrpc.class) {
        if ((getOnMonitorFeedbackAvailableMethod = SinkServiceGrpc.getOnMonitorFeedbackAvailableMethod) == null) {
          SinkServiceGrpc.getOnMonitorFeedbackAvailableMethod = getOnMonitorFeedbackAvailableMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.FeedbackMessage, mliot.monitor.generated.EmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onMonitorFeedbackAvailable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.FeedbackMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.EmptyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SinkServiceMethodDescriptorSupplier("onMonitorFeedbackAvailable"))
              .build();
        }
      }
    }
    return getOnMonitorFeedbackAvailableMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SinkServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SinkServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SinkServiceStub>() {
        @java.lang.Override
        public SinkServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SinkServiceStub(channel, callOptions);
        }
      };
    return SinkServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SinkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SinkServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SinkServiceBlockingStub>() {
        @java.lang.Override
        public SinkServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SinkServiceBlockingStub(channel, callOptions);
        }
      };
    return SinkServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SinkServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SinkServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SinkServiceFutureStub>() {
        @java.lang.Override
        public SinkServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SinkServiceFutureStub(channel, callOptions);
        }
      };
    return SinkServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SinkServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void onMonitorFeedbackAvailable(mliot.monitor.generated.FeedbackMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMonitorFeedbackAvailableMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnMonitorFeedbackAvailableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                mliot.monitor.generated.FeedbackMessage,
                mliot.monitor.generated.EmptyResponse>(
                  this, METHODID_ON_MONITOR_FEEDBACK_AVAILABLE)))
          .build();
    }
  }

  /**
   */
  public static final class SinkServiceStub extends io.grpc.stub.AbstractAsyncStub<SinkServiceStub> {
    private SinkServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SinkServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SinkServiceStub(channel, callOptions);
    }

    /**
     */
    public void onMonitorFeedbackAvailable(mliot.monitor.generated.FeedbackMessage request,
        io.grpc.stub.StreamObserver<mliot.monitor.generated.EmptyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMonitorFeedbackAvailableMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SinkServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SinkServiceBlockingStub> {
    private SinkServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SinkServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SinkServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public mliot.monitor.generated.EmptyResponse onMonitorFeedbackAvailable(mliot.monitor.generated.FeedbackMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMonitorFeedbackAvailableMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SinkServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SinkServiceFutureStub> {
    private SinkServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SinkServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SinkServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.EmptyResponse> onMonitorFeedbackAvailable(
        mliot.monitor.generated.FeedbackMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMonitorFeedbackAvailableMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_MONITOR_FEEDBACK_AVAILABLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SinkServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SinkServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_MONITOR_FEEDBACK_AVAILABLE:
          serviceImpl.onMonitorFeedbackAvailable((mliot.monitor.generated.FeedbackMessage) request,
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

  private static abstract class SinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SinkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return mliot.monitor.generated.Sink.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SinkService");
    }
  }

  private static final class SinkServiceFileDescriptorSupplier
      extends SinkServiceBaseDescriptorSupplier {
    SinkServiceFileDescriptorSupplier() {}
  }

  private static final class SinkServiceMethodDescriptorSupplier
      extends SinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SinkServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SinkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SinkServiceFileDescriptorSupplier())
              .addMethod(getOnMonitorFeedbackAvailableMethod())
              .build();
        }
      }
    }
    return result;
  }
}
