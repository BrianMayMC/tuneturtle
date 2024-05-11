package me.nootnoot.songservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateSongRequest {
    private UUID artistId;
    private String pictureData;
    private String title;
    private MultipartFile songData;
}
