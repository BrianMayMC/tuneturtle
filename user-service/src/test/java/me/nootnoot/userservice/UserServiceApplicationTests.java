package me.nootnoot.userservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import me.nootnoot.userservice.entities.*;
import me.nootnoot.userservice.managers.UserManager;
import me.nootnoot.userservice.messaging.sender.UserLikedSongsMessageSender;
import me.nootnoot.userservice.messaging.sender.UserPlaylistMessageSender;
import me.nootnoot.userservice.storage.MongoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceApplicationTests {

	@MockBean
	private MongoManager mongoManager;

	@MockBean
	private UserPlaylistMessageSender messageHandler;

	@MockBean
	private UserLikedSongsMessageSender userLikedSongsMessageSender;

	@Autowired
	private UserManager userManager;

	private User user1;
	private User user2;

	@BeforeEach
	public void setUp() {
		user1 = new User("User 1", "user1@gmail.com", UserRole.ROLE_ADMIN, RegistrationSource.GITHUB);
		user2 = new User("User 2", "user2@gmail.com", UserRole.ROLE_ADMIN, RegistrationSource.GITHUB);

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		when(mongoManager.getUsers()).thenReturn(userList);
	}

	@Test
	public void testAddLikedSong() {
		UUID songId = UUID.randomUUID();
		String username = "User 1";

		userManager.addLikedSong(username, songId);

		assertTrue(user1.getLikedSongIds().contains(songId));
		verify(mongoManager).updateUser(user1);
		userManager.clear();
	}

	@Test
	public void testGetLikedSongs() {
		UUID userId = UUID.randomUUID();
		List<UUID> songIds = new ArrayList<>();
		songIds.add(UUID.randomUUID());
		songIds.add(UUID.randomUUID());
		List<Song> songs = new ArrayList<>();
		when(userLikedSongsMessageSender.getLikedSongs(eq(user1.getId()), anyList())).thenReturn(songs);

		user1 = new User(userId, "User 1", "user1@gmail.com", UserRole.ROLE_ADMIN, RegistrationSource.GITHUB, songIds,
				false, "", "");

		List<Song> result = userManager.getLikedSongs(user1.getName());

		assertEquals(songs, result);
		userManager.clear();
	}

	@Test
	public void testGetPlaylists() {
		UUID userId = user1.getId();
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(new Playlist("Test Playlist", userId, new ArrayList<>()));
		when(messageHandler.getUserPlaylists(eq(userId))).thenReturn(playlists); // Ensure correct userId is used

		user1 = new User(userId, "User 1", "user1@gmail.com", UserRole.ROLE_ADMIN, RegistrationSource.GITHUB, new ArrayList<>(),
				false, "", "");

		List<Playlist> result = userManager.getPlaylists(user1.getName());

		assertEquals(playlists, result);
		userManager.clear();
	}



	@Test
	public void testGetUser() {
		String username = "User 1";

		User result = userManager.getUser(username);

		assertEquals(user1, result);
		userManager.clear();
	}

	@Test
	public void testMakeArtist() {
		String username = "User 1";
		String artistName = "Test Artist";
		String artistProfilePicture = "profile.jpg";

		userManager.makeArtist(username, artistName, artistProfilePicture);

		assertTrue(user1.isArtist());
		assertEquals(artistName, user1.getArtistName());
		assertEquals(artistProfilePicture, user1.getArtistProfilePicture());
		verify(mongoManager).updateUser(user1);
		userManager.clear();
	}

	@Test
	public void testAddListen() {
		UUID songId = UUID.randomUUID();
		String username = "User 1";

		userManager.addListen(username, songId);

		assertEquals(1, user1.getSongListenAmounts().get(songId));
		verify(mongoManager).updateUser(user1);
		userManager.clear();
	}

	@Test
	public void testGetListenAmounts() {
		UUID songId = UUID.randomUUID();
		user1.getSongListenAmounts().put(songId, 5L);
		user2.getSongListenAmounts().put(songId, 3L);

		int result = userManager.getListenAmounts(songId);

		assertEquals(8, result);
		userManager.clear();
	}

	@Test
	public void testIsAdmin() {
		String username = "User 1";

		boolean result = userManager.isAdmin(username);

		assertFalse(result);
		userManager.clear();
	}

	@Test
	public void testIsArtist() {
		user1.setArtist(true);

		boolean result = userManager.isArtist(user1.getName());

		assertTrue(result);
		userManager.clear();
	}

	@Test
	public void testFindByName() {
		String name = "User 1";

		Optional<User> result = userManager.findByName(name);

		assertTrue(result.isPresent());
		assertEquals(user1, result.get());
		userManager.clear();
	}

	@Test
	public void testSave() {
		User user = new User("Test User", "testuser@gmail.com", UserRole.ROLE_USER, RegistrationSource.GITHUB);

		userManager.save(user);

		verify(mongoManager).saveUser(user);
		userManager.clear();
	}

}
