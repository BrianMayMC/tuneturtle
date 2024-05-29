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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaylistControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlaylistManager playlistManager;

    @BeforeEach
    void setUp() {
        // Clear any existing playlists
//        playlistManager.getAll().forEach(playlist -> playlistManager.remove(playlist.getId()));
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
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Get the playlist ID
        UUID playlistId = playlistManager.getPlaylists(UUID.fromString(request.getOwner())).get(0).getId();

        // Perform DELETE request
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/playlist/{id}", playlistId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddSongToPlaylist() throws Exception {
        // Create a test playlist
        PlaylistCreateRequest createRequest = new PlaylistCreateRequest("Test Playlist", UUID.randomUUID().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playlist/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Get the playlist ID
        UUID playlistId = playlistManager.getPlaylists(UUID.fromString(createRequest.getOwner())).get(0).getId();

        // Create a test song
        UUID songId = UUID.randomUUID();

        // Create a request to add song to playlist
        AddSongToPlaylistRequest addSongRequest = new AddSongToPlaylistRequest(playlistId.toString(), songId.toString());

        // Perform PUT request
        mockMvc.perform(MockMvcRequestBuilders.put("/api/playlist/song")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addSongRequest)))
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

        // Get the playlist ID
        UUID playlistId = playlistManager.getPlaylists(UUID.fromString(createRequest.getOwner())).get(0).getId();

        // Create a test song
        UUID songId = UUID.randomUUID();

        // Add the song to the playlist
        playlistManager.addSong(playlistId, songId);

        // Create a request to remove song from playlist
        RemoveSongFromPlaylistRequest removeSongRequest = new RemoveSongFromPlaylistRequest(playlistId.toString(), songId.toString());

        // Perform DELETE request
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/playlist/song")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(removeSongRequest)))
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

        // Get the playlist ID
        UUID playlistId = playlistManager.getPlaylists(UUID.fromString(createRequest.getOwner())).get(0).getId();

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/playlist/songs/{id}", playlistId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
