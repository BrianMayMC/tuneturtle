package me.nootnoot.mctiersadminbackend.managers;

import com.mongodb.client.MongoClient;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import me.nootnoot.mctiersadminbackend.controller.responses.NameAndUuid;
import me.nootnoot.mctiersadminbackend.entities.Restriction;
import me.nootnoot.mctiersadminbackend.entities.pubsub.BanRequestObj;
import me.nootnoot.mctiersadminbackend.generated.Tierplayer;
import me.nootnoot.mctiersadminbackend.generated.tierplayerGrpc;
import me.nootnoot.mctiersadminbackend.storage.MongoManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestrictionsManager {
    private final RedisManager redisManager;
    private final MongoManager mongoManager;
    private final tierplayerGrpc.tierplayerBlockingStub tierplayerBlockingStub;

    public RestrictionsManager(MongoManager mongoManager) {
        redisManager = new RedisManager();
        this.mongoManager = mongoManager;
        Channel channel = ManagedChannelBuilder.forAddress("23.139.82.139", 25572)
                .usePlaintext()
                .maxInboundMessageSize(1000000000).build();

        tierplayerBlockingStub = tierplayerGrpc.newBlockingStub(channel);
    }

    public void restrict(String username, long duration, String reason, String banStatement, String uuid){
        redisManager.send(new BanRequestObj(mongoManager.getDiscordId(UUID.fromString(uuid))), "bot_channel");

        mongoManager.restrict(username, duration, reason, banStatement, uuid);
    }




    public List<NameAndUuid> getAllUsernameAndUuids() {
        List<NameAndUuid> uuids = new ArrayList<>();
        Tierplayer.TierPlayerDTOList list = tierplayerBlockingStub.getAll(Tierplayer.Empty.newBuilder().build());
        System.out.println("list received");

        for(Tierplayer.TierPlayerDTO dto : list.getListList()){
            if(dto.getUsername().equalsIgnoreCase("NO0TNOOT")){
                System.out.println("found one");
            }
            Restriction restriction = mongoManager.getRestriction(UUID.fromString(dto.getUuid()));
            uuids.add(new NameAndUuid(dto.getUsername(), dto.getUuid(), restriction != null ? restriction.getReason() : null,
                    restriction != null ? restriction.getStatement() : null));
        }
        System.out.println("returning");
        return uuids;
    }
}
