package me.nootnoot.userservice.messaging.receiver;

import com.google.gson.Gson;
import me.nootnoot.userservice.entities.Song;
import me.nootnoot.userservice.managers.UserManager;
import me.nootnoot.userservice.messaging.obj.GetLikedSongsMsg;
import me.nootnoot.userservice.messaging.obj.GetListenAmountRequestResponseMsg;
import me.nootnoot.userservice.messaging.obj.GetListenAmountsRequestMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class GetUserListenAmountReceiver {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserManager userManager;

    @RabbitListener(queues = "LISTEN_AMOUNT_REQUEST_QUEUE")
    public void handleListenAmounts(Message message){
        System.out.println("handling listen amounts");

        GetListenAmountsRequestMsg msg = new Gson().fromJson(new String(message.getBody()), GetListenAmountsRequestMsg.class);
        int listenAmount = userManager.getListenAmounts(UUID.fromString(msg.getSongId()));

        System.out.println(new Gson().toJson(new GetListenAmountRequestResponseMsg(listenAmount)));
        Message m = new Message(new Gson().toJson(new GetListenAmountRequestResponseMsg(listenAmount)).getBytes(), message.getMessageProperties());

        rabbitTemplate.convertAndSend(message.getMessageProperties().getReplyTo(), m);
    }


    @Bean
    public Queue listenAmountRequestQueue(){
        return new Queue("LISTEN_AMOUNT_REQUEST_QUEUE", true, false, false);
    }
}
