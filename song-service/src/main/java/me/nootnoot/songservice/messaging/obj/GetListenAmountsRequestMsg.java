package me.nootnoot.songservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetListenAmountsRequestMsg {
    private UUID songId;
}
