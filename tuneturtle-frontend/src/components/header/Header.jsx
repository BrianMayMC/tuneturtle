import React from "react";
import Logo from "../../images/logo.png";
import User from "../../images/user.png";
import "../header/style.css";

const Header = () => {
	return (
		<div className="header-container">
			<img
				className="header-logo"
				src={Logo}
				alt=""
				onClick={() => {
					window.location.assign("/");
				}}
			/>
			<div
				className="header-text"
				style={{ marginLeft: "100px" }}
				onClick={() => {
					window.location.assign("/library");
				}}
			>
				Your Library
			</div>
			<div
				className="header-text"
				onClick={() => {
					window.location.assign("/search");
				}}
			>
				Search
			</div>
			<div
				className="header-text"
				onClick={() => {
					window.location.assign("/register");
				}}
			>
				Register As Artist
			</div>
			<img
				className="header-logo"
				style={{ marginLeft: "70px" }}
				src={User}
				alt=""
			/>
		</div>
	);
};

export default Header;
