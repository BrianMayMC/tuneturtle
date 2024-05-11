import React from "react";
import "../musicplayer/style.css";
import Heart from "../../images/heart.png";
import Left from "../../images/left.png";
import Pause from "../../images/pause.png";
import Right from "../../images/right.png";
import Loop from "../../images/loop.png";
import Slider from "@mui/material/Slider";

const MusicPlayer = (
	{ currentlyPlaying } = {
		name: "American Idiot",
		image: "",
		artist: {
			name: "Green Day",
			image: "",
			monthlyListeners: 30016991,
		},
	}
) => {
	return (
		<div className="music-player-container">
			<div className="music-player-current-container">
				<img
					src={currentlyPlaying.image}
					alt=""
					className="music-player-current-image"
				/>
				<div className="music-player-current-subcontainer">
					<div className="music-player-current-title">
						{currentlyPlaying.name}
					</div>
					<div className="music-player-current-subtitle">
						{currentlyPlaying.artist.name}
					</div>
				</div>
				<img src={Heart} alt="" className="music-player-current-heart-image" />
			</div>
			<div className="music-player-controls">
				<div className="music-player-controls-container">
					<img src={Left} alt="" className="music-player-controls-image" />
					<img src={Pause} alt="" className="music-player-controls-image" />
					<img src={Right} alt="" className="music-player-controls-image" />
					<img src={Loop} alt="" className="music-player-controls-image" />
				</div>
				<Slider defaultValue={30} />
			</div>
		</div>
	);
};

export default MusicPlayer;
