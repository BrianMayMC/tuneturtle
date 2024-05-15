import React, { useEffect, useRef, useState } from "react";
import "froala-editor/css/froala_style.min.css";
import "froala-editor/css/froala_editor.pkgd.min.css";
import "froala-editor/js/plugins/image.min.js";
import "froala-editor/js/plugins/char_counter.min.js";
import "froala-editor/js/plugins/save.min.js";
import "froala-editor/js/plugins/video.min.js";
import "froala-editor/js/plugins/draggable.min.js";
import "froala-editor/js/plugins/colors.min.js";
import "froala-editor/js/plugins/font_size.min.js";
import "froala-editor/js/plugins/font_family.min.js";
import "froala-editor/js/plugins/inline_style.min.js";
import "froala-editor/js/plugins/line_height.min.js";
import "froala-editor/js/plugins/quote.min.js";
import "froala-editor/js/plugins/special_characters.min.js";
import "froala-editor/js/plugins/word_paste.min.js";
import "froala-editor/js/plugins/url.min.js";
import "froala-editor/js/third_party/font_awesome.min.js";

import FroalaEditorComponent from "react-froala-wysiwyg";
import { Button, Input, TextField } from "@mui/material";
import { BACKEND_URL } from "../../components/Constants";

const AnnouncementsPage = () => {
	const [model, setModel] = useState("");
	const [title, setTitle] = useState("");
	const [author, setAuthor] = useState("");
	const [authorUuid, setAuthorUuid] = useState("");
	const [shortDescription, setShortDescription] = useState("");
	const [image, setImage] = useState("");

	let config = {
		charCounterCount: true,
		key: "AVB8B-21B4C3A2E1D2D1A17vC2ve1xhbH1qb1vC2wgheC3I3C7C8C4B4B3A3B2G2==",
		saveInteral: 2000,
	};

	const handleImageChange = (event) => {
		console.log("changing image");
		const file = event.target.files[0];
		if (file) {
			const reader = new FileReader();
			reader.onloadend = () => {
				setImage(reader.result);
			};
			reader.readAsDataURL(file);
		}
	};

	const handleModelChange = (event) => {
		setModel(event);
	};

	async function create() {
		if (
			title === "" ||
			author === "" ||
			authorUuid === "" ||
			model === "" ||
			shortDescription === "" ||
			image === ""
		) {
			alert("There are fields left open!");
			return;
		}

		var object = {
			title: title,
			shortDescription: shortDescription,
			description: model,
			uuid: authorUuid,
			author: author,
			image: image,
		};

		await fetch(BACKEND_URL + "/api/announcement/", {
			method: "POST",
			credentials: "include",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify(object),
		});

		// document.location = "/";
	}

	return (
		<>
			<h1 style={{ color: "#FFF" }}>Announcement Creation</h1>
			<div style={{ display: "flex", gap: "40px" }}>
				<div>
					<h2 style={{ color: "#FFF" }}>Title</h2>
					<TextField
						id="filled-basic"
						label=""
						style={{
							marginBottom: "10px",
							color: "#FFF",
							backgroundColor: "#FFF",
						}}
						onChange={(e) => {
							setTitle(e.target.value);
						}}
					/>
				</div>

				<div>
					<h2 style={{ color: "#FFF" }}>Author Name</h2>
					<TextField
						id="filled-basic"
						label=""
						style={{
							marginBottom: "10px",
							color: "#FFF",
							backgroundColor: "#FFF",
						}}
						onChange={(e) => {
							setAuthor(e.target.value);
						}}
					/>
				</div>

				<div>
					<h2 style={{ color: "#FFF" }}>Author UUID</h2>
					<TextField
						id="filled-basic"
						label=""
						style={{
							marginBottom: "10px",
							color: "#FFF",
							backgroundColor: "#FFF",
							width: "400px",
						}}
						onChange={(e) => {
							setAuthorUuid(e.target.value);
						}}
					/>
				</div>

				<div>
					<h2 style={{ color: "#FFF" }}>Short Description</h2>
					<TextField
						id="filled-basic"
						label=""
						style={{
							marginBottom: "10px",
							color: "#FFF",
							backgroundColor: "#FFF",
							width: "400px",
						}}
						onChange={(e) => {
							setShortDescription(e.target.value);
						}}
					/>
				</div>

				<div>
					<h2 style={{ color: "#FFF" }}>Image</h2>
					<TextField
						type="file"
						variant="filled"
						style={{ background: "#FFF" }}
						label=""
						accept="image/*"
						onChange={handleImageChange}
					/>
					<img alt="" src={image} />
				</div>
			</div>

			<h2 style={{ color: "#FFF" }}>Description</h2>

			<FroalaEditorComponent
				tag="textarea"
				model={model}
				config={config}
				onModelChange={handleModelChange}
			/>
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
};

export default AnnouncementsPage;
