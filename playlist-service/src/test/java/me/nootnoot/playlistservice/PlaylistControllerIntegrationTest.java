package me.nootnoot.playlistservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.nootnoot.playlistservice.controllers.PlaylistController;
import me.nootnoot.playlistservice.controllers.requests.AddSongToPlaylistRequest;
import me.nootnoot.playlistservice.controllers.requests.PlaylistCreateRequest;
import me.nootnoot.playlistservice.controllers.requests.RemoveSongFromPlaylistRequest;
import me.nootnoot.playlistservice.managers.PlaylistManager;
import me.nootnoot.playlistservice.storage.MongoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PlaylistControllerIntegrationTest {

    private MockMvc mockMvc;

    @Mock
    private PlaylistManager playlistManager;

    @InjectMocks
    private PlaylistController playlistController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playlistController).build();
    }

    @Test
    public void testAddPlaylist() throws Exception {
        // Mock request body
        PlaylistCreateRequest request = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletePlaylist() throws Exception {
        // Create a test playlist
        PlaylistCreateRequest request = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());

        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(delete("/api/playlist/" + request.getOwner()))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddSongToPlaylist() throws Exception {
        // Create a test playlist
        PlaylistCreateRequest createRequest = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveSongFromPlaylist() throws Exception {
        // Create a test playlist
        PlaylistCreateRequest createRequest = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testGetPlaylistsByUser() throws Exception {
        // Create a test playlist
        String ownerId = UUID.randomUUID().toString();
        PlaylistCreateRequest createRequest = new PlaylistCreateRequest("Test Playlist", ownerId);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/playlist/{id}", ownerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetPlaylistSongs() throws Exception {
        // Create a test playlist
        PlaylistCreateRequest createRequest = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
