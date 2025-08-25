import React, { useEffect, useState } from "react";

function ApplicationList() {
  const [apps, setApps] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/applications")
      .then((res) => res.json())
      .then((data) => setApps(data));
  }, []);

  return (
    <div>
      <h2>Applications</h2>
      <ul>
        {apps.map((a) => (
          <li key={a.id}>
            User: {a.user?.name} → Job: {a.job?.title} → Status: {a.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ApplicationList;
