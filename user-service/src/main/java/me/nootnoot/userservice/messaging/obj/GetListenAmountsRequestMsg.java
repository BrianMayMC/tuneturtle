package me.nootnoot.userservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetListenAmountsRequestMsg {
    private String songId;
}
