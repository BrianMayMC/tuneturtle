package me.nootnoot.playlistservice.messaging.sender;

import com.google.gson.Gson;
import me.nootnoot.playlistservice.entities.Song;
import me.nootnoot.playlistservice.messaging.obj.GetPlaylistSongsRequestObj;
import me.nootnoot.playlistservice.messaging.obj.GetPlaylistSongsResponseObj;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetPlaylistSongsSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String queue = "PLAYLIST_SONGS_REQUEST_QUEUE";
    private String responseQueue = "PLAYLIST_SONGS_RECEIVE_QUEUE";

    public List<Song> getPlaylistSongs(List<UUID> songIds){
        String correlationId = UUID.randomUUID().toString();

        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId(correlationId);
        properties.setReplyTo(responseQueue);

        List<String> songIdsStrings = new ArrayList<>();
        for(UUID uuid : songIds){
            songIdsStrings.add(uuid.toString());
        }

        System.out.println(songIdsStrings);
        Message message = new Message(new Gson().toJson(new GetPlaylistSongsRequestObj(songIdsStrings)).getBytes(), properties);


        Message receivedMessage = rabbitTemplate.sendAndReceive(queue, message);
        GetPlaylistSongsResponseObj received = new Gson().fromJson(new String(receivedMessage.getBody()), GetPlaylistSongsResponseObj.class);
//        GetListenAmountRequestResponseMsg received = (GetListenAmountRequestResponseMsg) rabbitTemplate.getMessageConverter().fromMessage(receivedMessage);
        return received.getSongs();
    }

}
