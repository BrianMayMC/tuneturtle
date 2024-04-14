package me.nootnoot.artistservice.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: artist.proto")
public final class artistGrpc {

  private artistGrpc() {}

  public static final String SERVICE_NAME = "artist";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<me.nootnoot.artistservice.generated.Artist.Empty,
      me.nootnoot.artistservice.generated.Artist.TestResponse> getTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "test",
      requestType = me.nootnoot.artistservice.generated.Artist.Empty.class,
      responseType = me.nootnoot.artistservice.generated.Artist.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.artistservice.generated.Artist.Empty,
      me.nootnoot.artistservice.generated.Artist.TestResponse> getTestMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.artistservice.generated.Artist.Empty, me.nootnoot.artistservice.generated.Artist.TestResponse> getTestMethod;
    if ((getTestMethod = artistGrpc.getTestMethod) == null) {
      synchronized (artistGrpc.class) {
        if ((getTestMethod = artistGrpc.getTestMethod) == null) {
          artistGrpc.getTestMethod = getTestMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.artistservice.generated.Artist.Empty, me.nootnoot.artistservice.generated.Artist.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "artist", "test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.artistservice.generated.Artist.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.artistservice.generated.Artist.TestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new artistMethodDescriptorSupplier("test"))
                  .build();
          }
        }
     }
     return getTestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static artistStub newStub(io.grpc.Channel channel) {
    return new artistStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static artistBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new artistBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static artistFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new artistFutureStub(channel);
  }

  /**
   */
  public static abstract class artistImplBase implements io.grpc.BindableService {

    /**
     */
    public void test(me.nootnoot.artistservice.generated.Artist.Empty request,
        io.grpc.stub.StreamObserver<me.nootnoot.artistservice.generated.Artist.TestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.artistservice.generated.Artist.Empty,
                me.nootnoot.artistservice.generated.Artist.TestResponse>(
                  this, METHODID_TEST)))
          .build();
    }
  }

  /**
   */
  public static final class artistStub extends io.grpc.stub.AbstractStub<artistStub> {
    private artistStub(io.grpc.Channel channel) {
      super(channel);
    }

    private artistStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected artistStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new artistStub(channel, callOptions);
    }

    /**
     */
    public void test(me.nootnoot.artistservice.generated.Artist.Empty request,
        io.grpc.stub.StreamObserver<me.nootnoot.artistservice.generated.Artist.TestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class artistBlockingStub extends io.grpc.stub.AbstractStub<artistBlockingStub> {
    private artistBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private artistBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected artistBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new artistBlockingStub(channel, callOptions);
    }

    /**
     */
    public me.nootnoot.artistservice.generated.Artist.TestResponse test(me.nootnoot.artistservice.generated.Artist.Empty request) {
      return blockingUnaryCall(
          getChannel(), getTestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class artistFutureStub extends io.grpc.stub.AbstractStub<artistFutureStub> {
    private artistFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private artistFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected artistFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new artistFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.artistservice.generated.Artist.TestResponse> test(
        me.nootnoot.artistservice.generated.Artist.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final artistImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(artistImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST:
          serviceImpl.test((me.nootnoot.artistservice.generated.Artist.Empty) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.artistservice.generated.Artist.TestResponse>) responseObserver);
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

  private static abstract class artistBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    artistBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return me.nootnoot.artistservice.generated.Artist.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("artist");
    }
  }

  private static final class artistFileDescriptorSupplier
      extends artistBaseDescriptorSupplier {
    artistFileDescriptorSupplier() {}
  }

  private static final class artistMethodDescriptorSupplier
      extends artistBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    artistMethodDescriptorSupplier(String methodName) {
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
      synchronized (artistGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new artistFileDescriptorSupplier())
              .addMethod(getTestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
