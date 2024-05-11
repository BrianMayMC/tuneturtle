import React, { useState } from "react";
import "../home/style.css";
import MusicPlayer from "../../components/musicplayer/MusicPlayer";

const HomePage = () => {
	const [playlists, setPlaylists] = useState([
		{
			name: "Liked Songs",
			songs: [],
		},
	]);

	const [currentlyPlaying, setCurrentlyPlaying] = useState({
		name: "American Idiot",
		image: "",
		artist: {
			name: "Green Day",
			image: "",
			monthlyListeners: 30016991,
		},
	});

	return (
		<>
			<div className="home-container">
				<div className="playlists-container">
					<div className="playlists-container-title">Playlists</div>
					{playlists.map((playlist) => (
						<div className="playlist-container">
							<div className="playlist-name">{playlist.name}</div>
							<div className="playlist-songamount">
								({playlist.songs.length} songs)
							</div>
						</div>
					))}
				</div>
				<div className="currentlyplaying-container">
					<img
						src={currentlyPlaying.image}
						alt=""
						className="currentlyplaying-image"
					/>
					<div
						className="currentlyplaying-container-text"
						style={{ marginTop: "20px" }}
					>
						{currentlyPlaying.name}
					</div>
					<div
						className="currentlyplaying-container-subtext"
						style={{ marginTop: "10px" }}
					>
						{currentlyPlaying.artist.name}
					</div>
					<img
						src={currentlyPlaying.artist.image}
						alt=""
						className="currentlyplaying-image"
						style={{ marginTop: "40px" }}
					/>
					<div
						className="currentlyplaying-container-text"
						style={{ marginTop: "20px" }}
					>
						{currentlyPlaying.artist.name}
					</div>
					<div
						className="currentlyplaying-container-subtext"
						style={{ marginTop: "10px" }}
					>
						{currentlyPlaying.artist.monthlyListeners
							.toString()
							.replace(/\B(?=(\d{3})+(?!\d))/g, ",")}
					</div>
					<div className="currentlyplaying-container-subtext">
						Monthly Listeners
					</div>
				</div>
			</div>
			<MusicPlayer currentlyPlaying={currentlyPlaying} />
		</>
	);
};

export default HomePage;
