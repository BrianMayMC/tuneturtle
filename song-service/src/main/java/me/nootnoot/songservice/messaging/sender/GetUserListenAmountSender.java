package me.nootnoot.songservice.messaging.sender;

import com.google.gson.Gson;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.messaging.obj.GetLikedSongsMsg;
import me.nootnoot.songservice.messaging.obj.GetListenAmountRequestResponseMsg;
import me.nootnoot.songservice.messaging.obj.GetListenAmountsRequestMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetUserListenAmountSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String queue = "LISTEN_AMOUNT_REQUEST_QUEUE";
    private String responseQueue = "LISTEN_AMOUNT_RECEIVE_QUEUE";

    public int getListenAmount(UUID songId){
        String correlationId = UUID.randomUUID().toString();

        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId(correlationId);
        properties.setReplyTo(responseQueue);

        Message message = new Message(new Gson().toJson(new GetListenAmountsRequestMsg(songId)).getBytes(), properties);


        Message receivedMessage = rabbitTemplate.sendAndReceive(queue, message);
        GetListenAmountRequestResponseMsg received = new Gson().fromJson(new String(receivedMessage.getBody()), GetListenAmountRequestResponseMsg.class);
//        GetListenAmountRequestResponseMsg received = (GetListenAmountRequestResponseMsg) rabbitTemplate.getMessageConverter().fromMessage(receivedMessage);
        System.out.println("received: " + received.getListenAmount());
        return (int) received.getListenAmount();
    }

}
