package me.nootnoot.songservice;

import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.managers.SongManager;
import me.nootnoot.songservice.messaging.sender.GetUserListenAmountSender;
import me.nootnoot.songservice.storage.MongoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class SongServiceApplicationTests {

	@MockBean
	private GetUserListenAmountSender getUserListenAmountSender;

	@MockBean
	private MongoManager mongoManager;

	@Autowired
	private SongManager songManager;

	private List<Song> songList;
	private Song song1;
	private Song song2;
	@BeforeEach
	public void setUp() {
		song1 = new Song(UUID.randomUUID(), "picture_data", "Song 1", new byte[]{});
		song2 = new Song(UUID.randomUUID(), "picture_data", "Song 2", new byte[]{});

		songList = new ArrayList<>();
		songList.add(song1);
		songList.add(song2);

		when(mongoManager.getAll()).thenReturn(songList);
		when(mongoManager.getAll()).thenReturn(songList);


	}

	@Test
	public void testGetSongByTitle_Found() {
		when(getUserListenAmountSender.getListenAmount(song1.getId())).thenReturn(100);

		Song result = songManager.getSong("Song 1");

		assertNotNull(result);
		assertEquals(song1, result);
		assertEquals(100, result.getListenAmount());

		songManager.clear();
	}

	@Test
	public void testGetSongByTitle_NotFound() {
		Song result = songManager.getSong("Nonexistent Song");

		assertNull(result);
		songManager.clear();
	}

	@Test
	public void testGetSongById_Found() {
		when(getUserListenAmountSender.getListenAmount(song2.getId())).thenReturn(200);

		Song result = songManager.getSong(song2.getId());

		assertNotNull(result);
		assertEquals(song2, result);
		assertEquals(200, result.getListenAmount());
		songManager.clear();
	}

	@Test
	public void testGetSongById_NotFound() {
		Song result = songManager.getSong(UUID.randomUUID());

		assertNull(result);
		songManager.clear();
	}

	@Test
	public void testGetAllSongs() {
		when(getUserListenAmountSender.getListenAmount(any(UUID.class))).thenReturn(150);

		List<Song> result = songManager.getAllSongs();

		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals(150, result.get(0).getListenAmount());
		assertEquals(150, result.get(1).getListenAmount());
		songManager.clear();
	}

	@Test
	public void testAddSong() {
		Song newSong = new Song(UUID.randomUUID(), "picture_data", "New Song", new byte[]{});

		songManager.addSong(newSong);

		verify(mongoManager).add(newSong);
		assertTrue(songManager.getAllSongs().contains(newSong));
		songManager.clear();
	}

	@Test
	public void testDeleteSong() {
		songManager.deleteSong(song1);

		verify(mongoManager).delete(song1);
		assertFalse(songManager.getAllSongs().contains(song1));
		songManager.clear();
	}
}
