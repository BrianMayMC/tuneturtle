package me.nootnoot.artistservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import me.nootnoot.artistservice.services.GrpcArtistService;

import java.io.IOException;

public class ArtistService {

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(9080)
                .addService(new GrpcArtistService())
                .maxInboundMessageSize(1000000000)
                .maxInboundMetadataSize(1000000000).build();

        System.out.println("Starting ARTIST server... Accepting any incoming gRPC requests through port 9080");
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
