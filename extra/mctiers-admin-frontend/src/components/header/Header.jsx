import React from "react";
import "./style.css";

const Header = () => {
	return (
		<div className="header-container">
			<div
				className="header-text"
				onClick={() => {
					window.location.assign("/announcements");
				}}
			>
				Announcements
			</div>
			<div
				className="header-text"
				onClick={() => {
					window.location.assign("/hofs");
				}}
			>
				HOF Entries
			</div>
			<div
				className="header-text"
				onClick={() => {
					window.location.assign("/restrictions");
				}}
			>
				Restrictions
			</div>
		</div>
	);
};

export default Header;
