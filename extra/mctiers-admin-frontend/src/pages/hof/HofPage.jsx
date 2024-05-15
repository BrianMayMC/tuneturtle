import React, { useEffect, useState } from "react";
import { Button, MenuItem, TextField } from "@mui/material";

function HofPage() {
	const [username, setUsername] = useState("");
	const [playerUuid, setPlayerUuid] = useState("");
	const [timeframe, setTimeframe] = useState("");
	const [tier, setTier] = useState("");
	const [deed, setDeed] = useState("");
	const [gamemode, setGamemode] = useState("");

	const BACKEND_URL = process.env.REACT_APP_BACKEND_URL;

	async function create() {
		if (
			username === "" ||
			playerUuid === "" ||
			timeframe === "" ||
			tier === "" ||
			deed === "" ||
			gamemode === ""
		) {
			alert("Not all values are provided!");
			return;
		}

		var object = {
			username: username,
			uuid: playerUuid,
			timeframe: timeframe,
			tier: tier,
			deed: deed,
			type: gamemode,
		};

		await fetch(BACKEND_URL + "/api/hof/", {
			method: "POST",
			credentials: "include",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify(object),
		});
	}

	const gamemodes = [
		"OVERALL",
		"VANILLA",
		"SWORD",
		"POT",
		"NETHERITE_POT",
		"UHC",
		"AXE",
	];

	return (
		<>
			<h1 style={{ color: "#FFF" }}>Create HOF Card</h1>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>Username</h2>
				<TextField
					id="filled-basic"
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setUsername(e.target.value);
					}}
				/>
			</div>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>UUID</h2>
				<TextField
					id="filled-basic"
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setPlayerUuid(e.target.value);
					}}
				/>
			</div>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>Timeframe</h2>
				<TextField
					id="filled-basic"
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setTimeframe(e.target.value);
					}}
				/>
			</div>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>Tier</h2>
				<TextField
					id="filled-basic"
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setTier(e.target.value);
					}}
				/>
			</div>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>Deed</h2>
				<TextField
					id="filled-basic"
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setDeed(e.target.value);
					}}
				/>
			</div>
			<div style={{ display: "flex", gap: "30px" }}>
				<h2 style={{ color: "#FFF" }}>Gamemode</h2>
				<TextField
					id="filled-basic"
					select
					label=""
					style={{
						marginBottom: "10px",
						position: "absolute",
						marginLeft: "200px",
						color: "#FFF",
						backgroundColor: "#FFF",
					}}
					onChange={(e) => {
						setGamemode(e.target.value);
					}}
				>
					{gamemodes.map((gamemode, index) => (
						<MenuItem key={index} value={gamemode}>
							{gamemode}
						</MenuItem>
					))}
				</TextField>
			</div>

			<Button
				variant="contained"
				onClick={() => {
					create();
				}}
				style={{ marginTop: "20px" }}
			>
				Create
			</Button>
		</>
	);
}

export default HofPage;
