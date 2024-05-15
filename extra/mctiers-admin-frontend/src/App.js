import { useEffect, useState } from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AnnouncementsPage from "./pages/announcements/AnnouncementsPage";
import Header from "./components/header/Header";
import HomePage from "./pages/home/HomePage";
import NotAllowed from "./pages/notallowed/NotAllowed";
import HofPage from "./pages/hof/HofPage";
import Restrictions from "./pages/restrictions/Restrictions";
import { BACKEND_URL } from "./components/Constants";

function App() {
	const [message, setMessage] = useState();
	const [admin, setAdmin] = useState(null);

	const getMessage = async () => {
		const response = await fetch(BACKEND_URL + "/api/dummy", {
			method: "GET",
			redirect: "follow",
			credentials: "include",
		}).then((response) => response);

		if (response.redirected) {
			document.location = response.url;
		}

		const data = await response.json();
		setMessage(data.message);
	};

	const getAdmin = async () => {
		const response = await fetch(BACKEND_URL + "/user/isAdmin", {
			method: "GET",
			redirect: "follow",
			credentials: "include",
		}).then((response) => response);

		if (response.redirected) {
			document.location = response.url;
		}

		const data = await response.json();
		setAdmin(data);
	};

	getAdmin();

	return (
		<>
			{admin && admin === true ? (
				<div>
					<Header />
					<BrowserRouter>
						<Routes>
							<Route path="/announcements" element={<AnnouncementsPage />} />
							<Route path="/hofs" element={<HofPage />} />
							<Route path="/restrictions" element={<Restrictions />} />
							<Route path="/" element={<HomePage />} />
						</Routes>
					</BrowserRouter>
				</div>
			) : (
				<NotAllowed />
			)}
		</>
	);
}

export default App;
