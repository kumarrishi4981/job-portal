import React, { useState } from "react";

function ApplyForm() {
  const [userId, setUserId] = useState("");
  const [jobId, setJobId] = useState("");
  const [message, setMessage] = useState("");

  const handleApply = () => {
    fetch(`http://localhost:8080/api/applications/apply?userId=${userId}&jobId=${jobId}`, {
      method: "POST",
    })
      .then((res) => res.json())
      .then(() => setMessage("Application submitted successfully!"))
      .catch(() => setMessage("Error submitting application."));
  };

  return (
    <div>
      <h2>Apply for a Job</h2>
      <input
        type="text"
        placeholder="User ID"
        value={userId}
        onChange={(e) => setUserId(e.target.value)}
      />
      <input
        type="text"
        placeholder="Job ID"
        value={jobId}
        onChange={(e) => setJobId(e.target.value)}
      />
      <button onClick={handleApply}>Apply</button>
      <p>{message}</p>
    </div>
  );
}

export default ApplyForm;
