import React from "react";
import "../home/style.css";

const NotAllowed = () => {
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
			<h1 className="title">
				You are NOT allowed to view this website! If you need permissions, ask
				one of the owners of MCTiers
			</h1>
		</div>
	);
};

export default NotAllowed;
