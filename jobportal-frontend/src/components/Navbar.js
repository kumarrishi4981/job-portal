import React from "react";
import "./Navbar.css";

function Navbar() {
  return (
    <nav className="navbar">
      <h1 className="logo">JobPortal</h1>
      <div className="nav-links">
        <a href="/">Jobs</a>
        <a href="/post-job">Post Job</a>
        <a href="/register">Register</a>
      </div>
    </nav>
  );
}

export default Navbar;
