package me.nootnoot.songservice.messaging.receiver;

import com.google.gson.Gson;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.managers.SongManager;
import me.nootnoot.songservice.messaging.obj.GetLikedSongsMsg;
import me.nootnoot.songservice.messaging.obj.GetPlaylistSongsRequestObj;
import me.nootnoot.songservice.messaging.obj.GetPlaylistSongsResponseObj;
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
public class GetPlaylistSongsReceiver {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SongManager songManager;

    @RabbitListener(queues = "PLAYLIST_SONGS_REQUEST_QUEUE")
    public void handleLikedSongs(Message message){
        GetPlaylistSongsRequestObj getPlaylistSongsRequestObj = new Gson().fromJson(new String(message.getBody()), GetPlaylistSongsRequestObj.class);

        List<Song> songs = new ArrayList<>();
        for(String id : getPlaylistSongsRequestObj.getSongIds()){
            songs.add(songManager.getSong(UUID.fromString(id)));
        }
        System.out.println("sending: " + new Gson().toJson(new GetPlaylistSongsResponseObj(songs)));
        Message m = new Message(new Gson().toJson(new GetPlaylistSongsResponseObj(songs)).getBytes(), message.getMessageProperties());

        rabbitTemplate.convertAndSend(message.getMessageProperties().getReplyTo(), m);
    }


    @Bean
    public Queue playlistSongsRequestQueue(){
        return new Queue("PLAYLIST_SONGS_REQUEST_QUEUE", true, false, false);
    }
}
