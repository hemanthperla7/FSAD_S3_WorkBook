import React, { useEffect, useState } from "react";

function FetchList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => {
        if (!res.ok) {
          throw new Error("Failed to fetch data");
        }
        return res.json();
      })
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <h3>Loading...</h3>;
  if (error) return <h3>Error: {error}</h3>;

  return (
    <div>
      <h2>Users List</h2>
      <ul>
        {users.map((u) => (
          <li key={u.id}>
            {u.name} | {u.email} | {u.phone}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FetchList;