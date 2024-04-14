package me.nootnoot.songservice.generated;

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
    comments = "Source: song.proto")
public final class songGrpc {

  private songGrpc() {}

  public static final String SERVICE_NAME = "song";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.SongDTO> getGetSongByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSongById",
      requestType = me.nootnoot.songservice.generated.Song.GetRequest.class,
      responseType = me.nootnoot.songservice.generated.Song.SongDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.SongDTO> getGetSongByIdMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.SongDTO> getGetSongByIdMethod;
    if ((getGetSongByIdMethod = songGrpc.getGetSongByIdMethod) == null) {
      synchronized (songGrpc.class) {
        if ((getGetSongByIdMethod = songGrpc.getGetSongByIdMethod) == null) {
          songGrpc.getGetSongByIdMethod = getGetSongByIdMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.SongDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "song", "getSongById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.SongDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new songMethodDescriptorSupplier("getSongById"))
                  .build();
          }
        }
     }
     return getGetSongByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.SongDTO,
      me.nootnoot.songservice.generated.Song.Empty> getAddSongMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSong",
      requestType = me.nootnoot.songservice.generated.Song.SongDTO.class,
      responseType = me.nootnoot.songservice.generated.Song.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.SongDTO,
      me.nootnoot.songservice.generated.Song.Empty> getAddSongMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.SongDTO, me.nootnoot.songservice.generated.Song.Empty> getAddSongMethod;
    if ((getAddSongMethod = songGrpc.getAddSongMethod) == null) {
      synchronized (songGrpc.class) {
        if ((getAddSongMethod = songGrpc.getAddSongMethod) == null) {
          songGrpc.getAddSongMethod = getAddSongMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.songservice.generated.Song.SongDTO, me.nootnoot.songservice.generated.Song.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "song", "addSong"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.SongDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new songMethodDescriptorSupplier("addSong"))
                  .build();
          }
        }
     }
     return getAddSongMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.DeleteRequest,
      me.nootnoot.songservice.generated.Song.Empty> getDeleteSongMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteSong",
      requestType = me.nootnoot.songservice.generated.Song.DeleteRequest.class,
      responseType = me.nootnoot.songservice.generated.Song.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.DeleteRequest,
      me.nootnoot.songservice.generated.Song.Empty> getDeleteSongMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.DeleteRequest, me.nootnoot.songservice.generated.Song.Empty> getDeleteSongMethod;
    if ((getDeleteSongMethod = songGrpc.getDeleteSongMethod) == null) {
      synchronized (songGrpc.class) {
        if ((getDeleteSongMethod = songGrpc.getDeleteSongMethod) == null) {
          songGrpc.getDeleteSongMethod = getDeleteSongMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.songservice.generated.Song.DeleteRequest, me.nootnoot.songservice.generated.Song.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "song", "deleteSong"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new songMethodDescriptorSupplier("deleteSong"))
                  .build();
          }
        }
     }
     return getDeleteSongMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.ListenAmountDTO> getGetListenAmountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListenAmount",
      requestType = me.nootnoot.songservice.generated.Song.GetRequest.class,
      responseType = me.nootnoot.songservice.generated.Song.ListenAmountDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.ListenAmountDTO> getGetListenAmountMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.ListenAmountDTO> getGetListenAmountMethod;
    if ((getGetListenAmountMethod = songGrpc.getGetListenAmountMethod) == null) {
      synchronized (songGrpc.class) {
        if ((getGetListenAmountMethod = songGrpc.getGetListenAmountMethod) == null) {
          songGrpc.getGetListenAmountMethod = getGetListenAmountMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.ListenAmountDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "song", "getListenAmount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.ListenAmountDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new songMethodDescriptorSupplier("getListenAmount"))
                  .build();
          }
        }
     }
     return getGetListenAmountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.Empty> getAddListenAmountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addListenAmount",
      requestType = me.nootnoot.songservice.generated.Song.GetRequest.class,
      responseType = me.nootnoot.songservice.generated.Song.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest,
      me.nootnoot.songservice.generated.Song.Empty> getAddListenAmountMethod() {
    io.grpc.MethodDescriptor<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.Empty> getAddListenAmountMethod;
    if ((getAddListenAmountMethod = songGrpc.getAddListenAmountMethod) == null) {
      synchronized (songGrpc.class) {
        if ((getAddListenAmountMethod = songGrpc.getAddListenAmountMethod) == null) {
          songGrpc.getAddListenAmountMethod = getAddListenAmountMethod = 
              io.grpc.MethodDescriptor.<me.nootnoot.songservice.generated.Song.GetRequest, me.nootnoot.songservice.generated.Song.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "song", "addListenAmount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.nootnoot.songservice.generated.Song.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new songMethodDescriptorSupplier("addListenAmount"))
                  .build();
          }
        }
     }
     return getAddListenAmountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static songStub newStub(io.grpc.Channel channel) {
    return new songStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static songBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new songBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static songFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new songFutureStub(channel);
  }

  /**
   */
  public static abstract class songImplBase implements io.grpc.BindableService {

    /**
     */
    public void getSongById(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.SongDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSongByIdMethod(), responseObserver);
    }

    /**
     */
    public void addSong(me.nootnoot.songservice.generated.Song.SongDTO request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddSongMethod(), responseObserver);
    }

    /**
     */
    public void deleteSong(me.nootnoot.songservice.generated.Song.DeleteRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSongMethod(), responseObserver);
    }

    /**
     */
    public void getListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.ListenAmountDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListenAmountMethod(), responseObserver);
    }

    /**
     */
    public void addListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddListenAmountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSongByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.songservice.generated.Song.GetRequest,
                me.nootnoot.songservice.generated.Song.SongDTO>(
                  this, METHODID_GET_SONG_BY_ID)))
          .addMethod(
            getAddSongMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.songservice.generated.Song.SongDTO,
                me.nootnoot.songservice.generated.Song.Empty>(
                  this, METHODID_ADD_SONG)))
          .addMethod(
            getDeleteSongMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.songservice.generated.Song.DeleteRequest,
                me.nootnoot.songservice.generated.Song.Empty>(
                  this, METHODID_DELETE_SONG)))
          .addMethod(
            getGetListenAmountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.songservice.generated.Song.GetRequest,
                me.nootnoot.songservice.generated.Song.ListenAmountDTO>(
                  this, METHODID_GET_LISTEN_AMOUNT)))
          .addMethod(
            getAddListenAmountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.nootnoot.songservice.generated.Song.GetRequest,
                me.nootnoot.songservice.generated.Song.Empty>(
                  this, METHODID_ADD_LISTEN_AMOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class songStub extends io.grpc.stub.AbstractStub<songStub> {
    private songStub(io.grpc.Channel channel) {
      super(channel);
    }

    private songStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected songStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new songStub(channel, callOptions);
    }

    /**
     */
    public void getSongById(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.SongDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSongByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addSong(me.nootnoot.songservice.generated.Song.SongDTO request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddSongMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSong(me.nootnoot.songservice.generated.Song.DeleteRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSongMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.ListenAmountDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListenAmountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request,
        io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddListenAmountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class songBlockingStub extends io.grpc.stub.AbstractStub<songBlockingStub> {
    private songBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private songBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected songBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new songBlockingStub(channel, callOptions);
    }

    /**
     */
    public me.nootnoot.songservice.generated.Song.SongDTO getSongById(me.nootnoot.songservice.generated.Song.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSongByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.songservice.generated.Song.Empty addSong(me.nootnoot.songservice.generated.Song.SongDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddSongMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.songservice.generated.Song.Empty deleteSong(me.nootnoot.songservice.generated.Song.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSongMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.songservice.generated.Song.ListenAmountDTO getListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetListenAmountMethod(), getCallOptions(), request);
    }

    /**
     */
    public me.nootnoot.songservice.generated.Song.Empty addListenAmount(me.nootnoot.songservice.generated.Song.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddListenAmountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class songFutureStub extends io.grpc.stub.AbstractStub<songFutureStub> {
    private songFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private songFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected songFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new songFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.songservice.generated.Song.SongDTO> getSongById(
        me.nootnoot.songservice.generated.Song.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSongByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.songservice.generated.Song.Empty> addSong(
        me.nootnoot.songservice.generated.Song.SongDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddSongMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.songservice.generated.Song.Empty> deleteSong(
        me.nootnoot.songservice.generated.Song.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSongMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.songservice.generated.Song.ListenAmountDTO> getListenAmount(
        me.nootnoot.songservice.generated.Song.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListenAmountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.nootnoot.songservice.generated.Song.Empty> addListenAmount(
        me.nootnoot.songservice.generated.Song.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddListenAmountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SONG_BY_ID = 0;
  private static final int METHODID_ADD_SONG = 1;
  private static final int METHODID_DELETE_SONG = 2;
  private static final int METHODID_GET_LISTEN_AMOUNT = 3;
  private static final int METHODID_ADD_LISTEN_AMOUNT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final songImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(songImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SONG_BY_ID:
          serviceImpl.getSongById((me.nootnoot.songservice.generated.Song.GetRequest) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.SongDTO>) responseObserver);
          break;
        case METHODID_ADD_SONG:
          serviceImpl.addSong((me.nootnoot.songservice.generated.Song.SongDTO) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty>) responseObserver);
          break;
        case METHODID_DELETE_SONG:
          serviceImpl.deleteSong((me.nootnoot.songservice.generated.Song.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty>) responseObserver);
          break;
        case METHODID_GET_LISTEN_AMOUNT:
          serviceImpl.getListenAmount((me.nootnoot.songservice.generated.Song.GetRequest) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.ListenAmountDTO>) responseObserver);
          break;
        case METHODID_ADD_LISTEN_AMOUNT:
          serviceImpl.addListenAmount((me.nootnoot.songservice.generated.Song.GetRequest) request,
              (io.grpc.stub.StreamObserver<me.nootnoot.songservice.generated.Song.Empty>) responseObserver);
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

  private static abstract class songBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    songBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return me.nootnoot.songservice.generated.Song.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("song");
    }
  }

  private static final class songFileDescriptorSupplier
      extends songBaseDescriptorSupplier {
    songFileDescriptorSupplier() {}
  }

  private static final class songMethodDescriptorSupplier
      extends songBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    songMethodDescriptorSupplier(String methodName) {
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
      synchronized (songGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new songFileDescriptorSupplier())
              .addMethod(getGetSongByIdMethod())
              .addMethod(getAddSongMethod())
              .addMethod(getDeleteSongMethod())
              .addMethod(getGetListenAmountMethod())
              .addMethod(getAddListenAmountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
