import React, { useState } from "react";
import StudentManager from "./StudentManager";
import FetchList from "./FetchList";
import FakePostList from "./FakePostList";

function App() {

  const [page, setPage] = useState("home");

  return (
    <div>
      <h1>Dashboard</h1>

      <button onClick={() => setPage("students")}>Student Manager</button>
      <button onClick={() => setPage("users")}>Users API</button>
      <button onClick={() => setPage("posts")}>Posts API</button>

      <hr />

      {page === "students" && <StudentManager />}
      {page === "users" && <FetchList />}
      {page === "posts" && <FakePostList />}
    </div>
  );
}

export default App;