import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {

  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("https://dummyjson.com/posts")
      .then((res) => {
        setPosts(res.data.posts);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
  <div>
    <h2>Posts</h2>

    {posts.length === 0 ? (
      <p>Loading Posts...</p>
    ) : (
      <ul>
        {posts.map((p) => (
          <li key={p.id}>
            {p.title}
          </li>
        ))}
      </ul>
    )}
  </div>
  );
}

export default FakePostList;