package me.nootnoot.songservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.nootnoot.songservice.controllers.SongController;
import me.nootnoot.songservice.controllers.requests.CreateSongRequest;
import me.nootnoot.songservice.controllers.responses.GetAllSongsResponse;
import me.nootnoot.songservice.controllers.responses.GetSongResponse;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.managers.SongManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SongControllerIntegrationTest {

    private MockMvc mockMvc;

    @Mock
    private SongManager songManager;

    @InjectMocks
    private SongController songController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(songController).build();
    }

    @Test
    public void testGetAllSongs() throws Exception {
        // Mock data
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(UUID.randomUUID(), UUID.randomUUID(), "picture1", "Song1", "", 0));
        songs.add(new Song(UUID.randomUUID(), UUID.randomUUID(), "picture2", "Song2", "", 0));

        // Mock service method
        when(songManager.getAllSongs()).thenReturn(songs);

        // Perform GET request
        mockMvc.perform(get("/api/song/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.songs.length()").value(2));
    }

    @Test
    public void testGetSong() throws Exception {
        // Mock data
        UUID songId = UUID.randomUUID();
        Song song = new Song(songId, UUID.randomUUID(), "picture", "Song", "", 0);

        // Mock service method
        when(songManager.getSong("Song")).thenReturn(song);

        // Perform GET request
        mockMvc.perform(get("/api/song/Song"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.song.title").value("Song"));
    }

    @Test
    public void testAddSong() throws Exception {
        // Mock request body
        CreateSongRequest request = new CreateSongRequest(UUID.randomUUID(), "picture", "New Song", "");

        // Perform POST request
        mockMvc.perform(post("/api/song/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteSong() throws Exception {
        mockMvc.perform(delete("/api/song/SongToDelete"))
                .andExpect(status().isOk());
    }
}
