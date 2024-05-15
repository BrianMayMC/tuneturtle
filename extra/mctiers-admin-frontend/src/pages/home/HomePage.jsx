import React from "react";
import "./style.css";

const HomePage = () => {
	return (
		<div
			style={{
				marginLeft: "auto",
				marginRight: "auto",
				display: "flex",
				flexDirection: "column",
				marginTop: "50px",
			}}
		>
			<h1 className="title">Welcome to the MCTiers Admin Panel</h1>
			<h3 className="title">
				Edit Announcements, HOF Entries & Restrictions here!
			</h3>
		</div>
	);
};

export default HomePage;
