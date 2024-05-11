package me.nootnoot.userservice.messaging.sender;

import me.nootnoot.userservice.entities.Playlist;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class UserPlaylistMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String queue = "PLAYLIST_REQUEST_QUEUE";
    private String responseQueue = "PLAYLIST_RECEIVE_QUEUE";

    public List<Playlist> getUserPlaylists(UUID userId){
        String correlationId = UUID.randomUUID().toString();

        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId(correlationId);
        properties.setReplyTo(responseQueue);

        Message message = new Message(userId.toString().getBytes(), properties);

        System.out.println(message.getMessageProperties().getReplyTo());

        Message receivedMessage = rabbitTemplate.sendAndReceive(queue, message);
        return (List<Playlist>) rabbitTemplate.getMessageConverter().fromMessage(receivedMessage);
    }
}
