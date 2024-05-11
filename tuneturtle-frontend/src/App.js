import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import HomePage from "./pages/home/HomePage";
import Header from "./components/header/Header";

function App() {
	return (
		<div>
			<Helmet>
				<title>TuneTurtle</title>
				<meta property="og:title" content="TuneTurtle" />
				<meta property="og:description" content="The brand new Spotify!" />
				<meta property="og:url" content="https://www.tuneturtle.com" />
				<meta property="og:type" content="website" />
			</Helmet>
			<Header />
			<BrowserRouter>
				<Routes>
					<Route path="/" element={<HomePage />} />
				</Routes>
			</BrowserRouter>
		</div>
	);
}

export default App;
