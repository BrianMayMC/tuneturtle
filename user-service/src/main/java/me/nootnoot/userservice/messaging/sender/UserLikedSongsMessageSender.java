package me.nootnoot.userservice.messaging.sender;

import com.google.gson.Gson;
import me.nootnoot.userservice.entities.Song;
import me.nootnoot.userservice.messaging.obj.GetLikedSongsMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserLikedSongsMessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String queue = "LIKED_SONGS_REQUEST_QUEUE";
    private String responseQueue = "LIKED_SONGS_RECEIVE_QUEUE";

    public List<Song> getLikedSongs(UUID userId, List<UUID> songIds){
        String correlationId = UUID.randomUUID().toString();

        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId(correlationId);
        properties.setReplyTo(responseQueue);

        List<String> songs = new ArrayList<>();
        for(UUID uuid : songIds){
            songs.add(uuid.toString());
        }
        Message message = new Message(new Gson().toJson(new GetLikedSongsMsg(userId.toString(), songs)).getBytes(), properties);

        System.out.println(message.getMessageProperties().getReplyTo());

        Message receivedMessage = rabbitTemplate.sendAndReceive(queue, message);
        return (List<Song>) rabbitTemplate.getMessageConverter().fromMessage(receivedMessage);
    }
}
