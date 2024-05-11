package me.nootnoot.userservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class GetListenAmountRequestResponseMsg implements Serializable {
    private long listenAmount;
}
