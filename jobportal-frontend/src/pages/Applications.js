import React, { useEffect, useState } from "react";
import axios from "axios";

const Applications = () => {
  const [applications, setApplications] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/applications")
      .then(response => setApplications(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h2>Applications</h2>
      <ul>
        {applications.map(app => (
          <li key={app.id}>
            User: {app.user?.name} applied for {app.job?.title} → Status: {app.status}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Applications;
