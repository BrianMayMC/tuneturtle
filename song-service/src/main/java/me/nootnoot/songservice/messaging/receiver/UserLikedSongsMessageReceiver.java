package me.nootnoot.songservice.messaging.receiver;

import com.google.gson.Gson;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.managers.SongManager;
import me.nootnoot.songservice.messaging.obj.GetLikedSongsMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserLikedSongsMessageReceiver {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SongManager songManager;

    @RabbitListener(queues = "LIKED_SONGS_REQUEST_QUEUE")
    public void handleLikedSongs(Message message){
        System.out.println("received message in liked songs");
        GetLikedSongsMsg getLikedSongsMsg = new Gson().fromJson(new String(message.getBody()), GetLikedSongsMsg.class);


        List<Song> songs = new ArrayList<>();
        for(String id : getLikedSongsMsg.getSongIds()){
            songs.add(songManager.getSong(UUID.fromString(id)));
        }
        Message m = new Message(new Gson().toJson(songs).getBytes(), message.getMessageProperties());

        rabbitTemplate.convertAndSend(message.getMessageProperties().getReplyTo(), m);
    }


    @Bean
    public Queue likedSongsRequestQueue(){
        return new Queue("LIKED_SONGS_REQUEST_QUEUE", true, false, false);
    }

    @Bean
    public Queue likedSongsReceiveQueue(){
        return new Queue("LIKED_SONGS_RECEIVE_QUEUE", true, false, false);
    }
}
