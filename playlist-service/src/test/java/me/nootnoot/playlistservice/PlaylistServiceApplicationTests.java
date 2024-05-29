package me.nootnoot.playlistservice;

import me.nootnoot.playlistservice.entities.Playlist;
import me.nootnoot.playlistservice.entities.Song;
import me.nootnoot.playlistservice.managers.PlaylistManager;
import me.nootnoot.playlistservice.messaging.sender.GetPlaylistSongsSender;
import me.nootnoot.playlistservice.storage.MongoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlaylistServiceApplicationTests {


	@Mock
	private MongoManager mongoManager;

	@Mock
	private GetPlaylistSongsSender getPlaylistSongsSender;

	@InjectMocks
	private PlaylistManager playlistManager;

	private List<Playlist> playlistList;
	private Playlist playlist1;
	private Playlist playlist2;

	@BeforeEach
	public void setUp() {
		playlist1 = new Playlist("Playlist 1", UUID.randomUUID(), new ArrayList<>());
		playlist2 = new Playlist("Playlist 2", UUID.randomUUID(), new ArrayList<>());

		playlistList = new ArrayList<>();
		playlistList.add(playlist1);
		playlistList.add(playlist2);

		when(mongoManager.getAll()).thenReturn(playlistList);

		// Manually initialize PlaylistManager to call the constructor with mocks
		playlistManager = new PlaylistManager(mongoManager, getPlaylistSongsSender);
	}

	@Test
	public void testAddPlaylist() {
		Playlist newPlaylist = new Playlist("Test Playlist", UUID.randomUUID(), new ArrayList<>());

		playlistManager.add(newPlaylist);

		verify(mongoManager).add(newPlaylist);
		assertTrue(playlistList.contains(newPlaylist));
	}

	@Test
	public void testRemovePlaylist() {
		UUID playlistId = playlist1.getId();
		playlistManager.remove(playlistId);

		verify(mongoManager).delete(playlistId);
		assertFalse(playlistList.contains(playlist1));
	}

	@Test
	public void testAddSong() {
		UUID songId = UUID.randomUUID();
		UUID playlistId = playlist1.getId();

		playlistManager.addSong(playlistId, songId);

		assertTrue(playlist1.getSongIds().contains(songId));
		verify(mongoManager).update(playlist1);
	}

	@Test
	public void testRemoveSong() {
		UUID songId = UUID.randomUUID();
		playlist1.getSongIds().add(songId);
		UUID playlistId = playlist1.getId();

		playlistManager.removeSong(playlistId, songId);

		assertFalse(playlist1.getSongIds().contains(songId));
		verify(mongoManager).update(playlist1);
	}

	@Test
	public void testGetPlaylistsByOwnerId() {
		UUID ownerId = playlist1.getOwnerId();

		List<Playlist> result = playlistManager.getPlaylists(ownerId);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertTrue(result.contains(playlist1));
		assertFalse(result.contains(playlist2));
	}

	@Test
	public void testGetSongs() {
		UUID playlistId = playlist1.getId();
		playlist1.getSongIds().add(UUID.randomUUID());
		List<Song> songs = new ArrayList<>();

		when(getPlaylistSongsSender.getPlaylistSongs(playlist1.getSongIds())).thenReturn(songs);

		List<Song> result = playlistManager.getSongs(playlistId);

		assertNotNull(result);
		assertEquals(songs, result);
	}

}
