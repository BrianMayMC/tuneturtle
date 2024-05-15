package me.nootnoot.mctiersadminbackend.generated;

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
    comments = "Source: tierplayer.proto")
public final class tierplayerGrpc {

  private tierplayerGrpc() {}

  public static final String SERVICE_NAME = "tierplayer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest.class,
      responseType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> getGetMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest, me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> getGetMethod;
    if ((getGetMethod = tierplayerGrpc.getGetMethod) == null) {
      synchronized (tierplayerGrpc.class) {
        if ((getGetMethod = tierplayerGrpc.getGetMethod) == null) {
          tierplayerGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest, me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tierplayer", "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new tierplayerMethodDescriptorSupplier("get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAll",
      requestType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty.class,
      responseType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> getGetAllMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty, me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> getGetAllMethod;
    if ((getGetAllMethod = tierplayerGrpc.getGetAllMethod) == null) {
      synchronized (tierplayerGrpc.class) {
        if ((getGetAllMethod = tierplayerGrpc.getGetAllMethod) == null) {
          tierplayerGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty, me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tierplayer", "getAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList.getDefaultInstance()))
                  .setSchemaDescriptor(new tierplayerMethodDescriptorSupplier("getAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "save",
      requestType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO.class,
      responseType = me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO,
      me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> getSaveMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO, me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> getSaveMethod;
    if ((getSaveMethod = tierplayerGrpc.getSaveMethod) == null) {
      synchronized (tierplayerGrpc.class) {
        if ((getSaveMethod = tierplayerGrpc.getSaveMethod) == null) {
          tierplayerGrpc.getSaveMethod = getSaveMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO, me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tierplayer", "save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new tierplayerMethodDescriptorSupplier("save"))
                  .build();
          }
        }
     }
     return getSaveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static tierplayerStub newStub(io.grpc.Channel channel) {
    return new tierplayerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static tierplayerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new tierplayerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static tierplayerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new tierplayerFutureStub(channel);
  }

  /**
   */
  public static abstract class tierplayerImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void getAll(me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }

    /**
     */
    public void save(me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest,
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO>(
                  this, METHODID_GET)))
          .addMethod(
            getGetAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty,
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO,
                me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty>(
                  this, METHODID_SAVE)))
          .build();
    }
  }

  /**
   */
  public static final class tierplayerStub extends io.grpc.stub.AbstractStub<tierplayerStub> {
    private tierplayerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private tierplayerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tierplayerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new tierplayerStub(channel, callOptions);
    }

    /**
     */
    public void get(me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAll(me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO request,
        io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class tierplayerBlockingStub extends io.grpc.stub.AbstractStub<tierplayerBlockingStub> {
    private tierplayerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private tierplayerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tierplayerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new tierplayerBlockingStub(channel, callOptions);
    }

    /**
     */
    public me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO get(me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList getAll(me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty save(me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class tierplayerFutureStub extends io.grpc.stub.AbstractStub<tierplayerFutureStub> {
    private tierplayerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private tierplayerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tierplayerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new tierplayerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO> get(
        me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList> getAll(
        me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty> save(
        me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_GET_ALL = 1;
  private static final int METHODID_SAVE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final tierplayerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(tierplayerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((me.nootnoot.mctiersadminbackend.generated.Tierplayer.GetRequest) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTOList>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((me.nootnoot.mctiersadminbackend.generated.Tierplayer.TierPlayerDTO) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.mctiersadminbackend.generated.Tierplayer.Empty>) responseObserver);
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

  private static abstract class tierplayerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    tierplayerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return me.nootnoot.mctiersadminbackend.generated.Tierplayer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("tierplayer");
    }
  }

  private static final class tierplayerFileDescriptorSupplier
      extends tierplayerBaseDescriptorSupplier {
    tierplayerFileDescriptorSupplier() {}
  }

  private static final class tierplayerMethodDescriptorSupplier
      extends tierplayerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    tierplayerMethodDescriptorSupplier(String methodName) {
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
      synchronized (tierplayerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new tierplayerFileDescriptorSupplier())
              .addMethod(getGetMethod())
              .addMethod(getGetAllMethod())
              .addMethod(getSaveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
