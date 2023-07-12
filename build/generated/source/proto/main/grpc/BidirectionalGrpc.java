import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.0)",
    comments = "Source: bidirectional.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BidirectionalGrpc {

  private BidirectionalGrpc() {}

  public static final String SERVICE_NAME = "Bidirectional";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<BidirectionalOuterClass.Message,
      BidirectionalOuterClass.Message> getGetServerResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerResponse",
      requestType = BidirectionalOuterClass.Message.class,
      responseType = BidirectionalOuterClass.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<BidirectionalOuterClass.Message,
      BidirectionalOuterClass.Message> getGetServerResponseMethod() {
    io.grpc.MethodDescriptor<BidirectionalOuterClass.Message, BidirectionalOuterClass.Message> getGetServerResponseMethod;
    if ((getGetServerResponseMethod = BidirectionalGrpc.getGetServerResponseMethod) == null) {
      synchronized (BidirectionalGrpc.class) {
        if ((getGetServerResponseMethod = BidirectionalGrpc.getGetServerResponseMethod) == null) {
          BidirectionalGrpc.getGetServerResponseMethod = getGetServerResponseMethod =
              io.grpc.MethodDescriptor.<BidirectionalOuterClass.Message, BidirectionalOuterClass.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BidirectionalOuterClass.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BidirectionalOuterClass.Message.getDefaultInstance()))
              .setSchemaDescriptor(new BidirectionalMethodDescriptorSupplier("GetServerResponse"))
              .build();
        }
      }
    }
    return getGetServerResponseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BidirectionalStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalStub>() {
        @java.lang.Override
        public BidirectionalStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalStub(channel, callOptions);
        }
      };
    return BidirectionalStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BidirectionalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalBlockingStub>() {
        @java.lang.Override
        public BidirectionalBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalBlockingStub(channel, callOptions);
        }
      };
    return BidirectionalBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BidirectionalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalFutureStub>() {
        @java.lang.Override
        public BidirectionalFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalFutureStub(channel, callOptions);
        }
      };
    return BidirectionalFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BidirectionalImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<BidirectionalOuterClass.Message> getServerResponse(
        io.grpc.stub.StreamObserver<BidirectionalOuterClass.Message> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetServerResponseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetServerResponseMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                BidirectionalOuterClass.Message,
                BidirectionalOuterClass.Message>(
                  this, METHODID_GET_SERVER_RESPONSE)))
          .build();
    }
  }

  /**
   */
  public static final class BidirectionalStub extends io.grpc.stub.AbstractAsyncStub<BidirectionalStub> {
    private BidirectionalStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<BidirectionalOuterClass.Message> getServerResponse(
        io.grpc.stub.StreamObserver<BidirectionalOuterClass.Message> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetServerResponseMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BidirectionalBlockingStub extends io.grpc.stub.AbstractBlockingStub<BidirectionalBlockingStub> {
    private BidirectionalBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class BidirectionalFutureStub extends io.grpc.stub.AbstractFutureStub<BidirectionalFutureStub> {
    private BidirectionalFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_SERVER_RESPONSE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BidirectionalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BidirectionalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVER_RESPONSE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getServerResponse(
              (io.grpc.stub.StreamObserver<BidirectionalOuterClass.Message>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BidirectionalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BidirectionalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return BidirectionalOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bidirectional");
    }
  }

  private static final class BidirectionalFileDescriptorSupplier
      extends BidirectionalBaseDescriptorSupplier {
    BidirectionalFileDescriptorSupplier() {}
  }

  private static final class BidirectionalMethodDescriptorSupplier
      extends BidirectionalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BidirectionalMethodDescriptorSupplier(String methodName) {
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
      synchronized (BidirectionalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BidirectionalFileDescriptorSupplier())
              .addMethod(getGetServerResponseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
