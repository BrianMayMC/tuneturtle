package me.nootnoot.artistservice;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import me.nootnoot.artistservice.generated.Artist;
import me.nootnoot.artistservice.generated.artistGrpc;

public class Test {

    public static void main(String[] args){
        System.out.println("Initializing channel");
        Channel channel = ManagedChannelBuilder.forTarget("127.0.0.1/artist")
                .maxInboundMessageSize(1000000000).build();

        System.out.println("Finished initializing");
        artistGrpc.artistBlockingStub stub = artistGrpc.newBlockingStub(channel);

        System.out.println("Made stub: " + stub);
        Artist.TestResponse response = stub.test(Artist.Empty.newBuilder().build());

        System.out.println("response: " + response);
    }
}
