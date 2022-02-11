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
      mliot.monitor.generated.MonitorResponse> getOnMovementDetectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onMovementDetected",
      requestType = mliot.monitor.generated.MovementDetectionMessage.class,
      responseType = mliot.monitor.generated.MonitorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<mliot.monitor.generated.MovementDetectionMessage,
      mliot.monitor.generated.MonitorResponse> getOnMovementDetectedMethod() {
    io.grpc.MethodDescriptor<mliot.monitor.generated.MovementDetectionMessage, mliot.monitor.generated.MonitorResponse> getOnMovementDetectedMethod;
    if ((getOnMovementDetectedMethod = MonitorServiceGrpc.getOnMovementDetectedMethod) == null) {
      synchronized (MonitorServiceGrpc.class) {
        if ((getOnMovementDetectedMethod = MonitorServiceGrpc.getOnMovementDetectedMethod) == null) {
          MonitorServiceGrpc.getOnMovementDetectedMethod = getOnMovementDetectedMethod =
              io.grpc.MethodDescriptor.<mliot.monitor.generated.MovementDetectionMessage, mliot.monitor.generated.MonitorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onMovementDetected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.MovementDetectionMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mliot.monitor.generated.MonitorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MonitorServiceMethodDescriptorSupplier("onMovementDetected"))
              .build();
        }
      }
    }
    return getOnMovementDetectedMethod;
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
        io.grpc.stub.StreamObserver<mliot.monitor.generated.MonitorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMovementDetectedMethod(), responseObserver);
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
                mliot.monitor.generated.MonitorResponse>(
                  this, METHODID_ON_MOVEMENT_DETECTED)))
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
        io.grpc.stub.StreamObserver<mliot.monitor.generated.MonitorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMovementDetectedMethod(), getCallOptions()), request, responseObserver);
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
    public mliot.monitor.generated.MonitorResponse onMovementDetected(mliot.monitor.generated.MovementDetectionMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMovementDetectedMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<mliot.monitor.generated.MonitorResponse> onMovementDetected(
        mliot.monitor.generated.MovementDetectionMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMovementDetectedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_KNOWN_STUDENTS = 0;
  private static final int METHODID_ON_STUDENT_CONNECTED = 1;
  private static final int METHODID_ON_MOVEMENT_DETECTED = 2;

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
              (io.grpc.stub.StreamObserver<mliot.monitor.generated.MonitorResponse>) responseObserver);
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
              .build();
        }
      }
    }
    return result;
  }
}
