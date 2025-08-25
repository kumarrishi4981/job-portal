import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ padding: "10px", background: "#333", color: "white" }}>
      <Link to="/" style={{ margin: "10px", color: "white" }}>Home</Link>
      <Link to="/jobs" style={{ margin: "10px", color: "white" }}>Jobs</Link>
      <Link to="/users" style={{ margin: "10px", color: "white" }}>Users</Link>
      <Link to="/applications" style={{ margin: "10px", color: "white" }}>Applications</Link>
    </nav>
  );
};

export default Navbar;
