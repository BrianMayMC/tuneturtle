package me.nootnoot.songservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import me.nootnoot.songservice.services.GrpcSongService;

import java.io.IOException;

public class SongService {

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(9090)
                .addService(new GrpcSongService())
                .maxInboundMessageSize(1000000000)
                .maxInboundMetadataSize(1000000000).build();

        System.out.println("Starting server... Accepting any incoming gRPC requests through port 9090");
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
