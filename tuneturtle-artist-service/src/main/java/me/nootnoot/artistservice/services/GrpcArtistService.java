package me.nootnoot.artistservice.services;

import io.grpc.stub.StreamObserver;
import me.nootnoot.artistservice.generated.Artist;
import me.nootnoot.artistservice.generated.artistGrpc;

public class GrpcArtistService extends artistGrpc.artistImplBase {

    @Override
    public void test(Artist.Empty request, StreamObserver<Artist.TestResponse> responseObserver) {

        responseObserver.onNext(Artist.TestResponse.newBuilder()
                .setMessage("Hey there! Greetings from the Artist Service!").build());
        responseObserver.onCompleted();
    }
}
