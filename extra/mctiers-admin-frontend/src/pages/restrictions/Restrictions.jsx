import React, { useMemo, useState, StrictMode, useEffect } from "react";
import { createRoot } from "react-dom/client";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import { Button } from "@mui/material";
import { BACKEND_URL } from "../../components/Constants";

const Restrictions = () => {
	const [tableData, setTableData] = useState([]);
	const [changedData, setChangedData] = useState([]);

	const getData = async () => {
		const response = await fetch("http://localhost:8080/api/restrictions/", {
			method: "GET",
			redirect: "follow",
			credentials: "include",
		}).then((response) => response);

		if (response.redirected) {
			document.location = response.url;
		}

		const data = await response.json();
		getTableData(data.nameAndUuids);
	};

	function getTableData(data) {
		let objects = [];
		data.forEach((data) => {
			objects.push({
				name: data.username,
				reason: data.reason !== null ? data.reason : "Rigging",
				statement:
					data.banStatement !== null
						? data.banStatement
						: "Input statement here...",
				uuid: data.uuid,
			});
		});
		setTableData(objects);
	}

	const [columnDefs, setColumnDefs] = useState([
		{ field: "name" },
		{
			field: "reason",
			editable: true,
			cellEditor: "agSelectCellEditor",
			cellEditorParams: {
				values: ["Rigging", "Account Sharing", "Unfair Advantage"],
			},
		},
		{
			field: "statement",
			editable: true,
			cellEditor: "agSelectTextEditor",
			flex: "3",
		},
	]);

	const defaultColDef = useMemo(() => {
		return {
			filter: "agTextColumnFilter",
			floatingFilter: true,
		};
	}, []);

	function getCurrentTimePlus365Days() {
		// Get the current time in milliseconds
		let currentTimeInMillis = Date.now();

		// Calculate milliseconds in 365 days
		let millisecondsIn365Days = 365 * 24 * 60 * 60 * 1000;

		// Add 365 days to the current time
		let futureTimeInMillis = currentTimeInMillis + millisecondsIn365Days;

		return futureTimeInMillis;
	}

	async function handleSave() {
		var object = [];
		changedData.forEach((data) => {
			object.push({
				username: data.name,
				duration: getCurrentTimePlus365Days(),
				reason: data.reason,
				banStatement: data.statement,
				uuid: data.uuid,
			});
		});

		await fetch(BACKEND_URL + "/api/restrictions/", {
			method: "POST",
			credentials: "include",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({
				requests: object,
			}),
		});
		console.log(object);
	}

	const addElementToArray = (newElement) => {
		setChangedData((prevArray) => {
			// Check if an object with the same name exists
			const index = prevArray.findIndex(
				(item) => item.name === newElement.name
			);

			if (index !== -1) {
				// If the element already exists, replace it
				const newArray = [...prevArray];
				newArray[index] = newElement;
				return newArray;
			} else {
				// If the element doesn't exist, append it
				return [...prevArray, newElement];
			}
		});
	};

	useEffect(() => {
		getData();
	}, []);

	return (
		<>
			{tableData.length > 0 ? (
				<>
					<div
						className="ag-theme-quartz"
						style={{
							height: 500,
							width: "45%",
							marginLeft: "auto",
							marginRight: "auto",
							marginTop: "50px",
						}}
					>
						<h1 style={{ color: "#FFF", textAlign: "center" }}>
							Double click reason & statement to edit
						</h1>
						<h2
							style={{
								color: "#FFF",
								textAlign: "center",
								marginBottom: "30px",
							}}
						>
							Press enter after editing the statement to save!
						</h2>
						<AgGridReact
							rowData={tableData}
							columnDefs={columnDefs}
							defaultColDef={defaultColDef}
							rowSelection="multiple"
							suppressRowClickSelection={true}
							pagination={true}
							paginationPageSize={10}
							paginationPageSizeSelector={[10, 25, 50]}
							onCellEditingStopped={(e) => {
								addElementToArray(e.data);
							}}
						/>
					</div>
					<Button
						variant="contained"
						style={{
							width: "300px",
							height: "75px",
							marginLeft: "auto",
							marginRight: "auto",
							display: "flex",
							marginTop: "150px",
						}}
						onClick={() => {
							handleSave();
						}}
					>
						Save changed Data
					</Button>
				</>
			) : (
				<div
					style={{
						color: "#FFF",
						fontSize: "50px",
						marginLeft: "auto",
						marginRight: "auto",
						marginTop: "50px",
						display: "flex",
						textAlign: "center",
						justifyContent: "center",
					}}
				>
					Loading...
				</div>
			)}
		</>
	);
};

export default Restrictions;
