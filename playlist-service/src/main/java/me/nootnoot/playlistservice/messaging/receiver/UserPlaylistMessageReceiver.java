package me.nootnoot.playlistservice.messaging.receiver;

import com.google.gson.Gson;
import me.nootnoot.playlistservice.managers.PlaylistManager;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserPlaylistMessageReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PlaylistManager playlistManager;

    @RabbitListener(queues = "PLAYLIST_REQUEST_QUEUE")
    public void getUserPlaylists(Message message){
        System.out.println("receiving message");
        UUID userId = UUID.fromString(new String(message.getBody()));

        Message m = new Message(new Gson().toJson(playlistManager.getPlaylists(userId)).getBytes(), message.getMessageProperties());

        rabbitTemplate.convertAndSend(message.getMessageProperties().getReplyTo(), m);
    }

    @Bean
    public Queue playlistReceiveQueue(){
        return new Queue("PLAYLIST_RECEIVE_QUEUE", true, false, false);
    }

    @Bean
    public Queue playlistRequestQueue(){
        return new Queue("PLAYLIST_REQUEST_QUEUE", true, false, false);
    }
    
}
