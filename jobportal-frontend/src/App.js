import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import UserList from "./components/UserList";
import JobList from "./components/JobList";
import ApplicationList from "./components/ApplicationList";
import ApplyForm from "./components/ApplyForm";

function App() {
  return (
    <Router>
      <Navbar />
      <div style={{ padding: "20px" }}>
        <Routes>
          <Route path="/" element={<h1>Welcome to Job Portal</h1>} />
          <Route path="/users" element={<UserList />} />
          <Route path="/jobs" element={<JobList />} />
          <Route path="/applications" element={<ApplicationList />} />
          <Route path="/apply" element={<ApplyForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
