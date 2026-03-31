import React, { useState } from "react";

function StudentManager() {

  // Initial students
  const [students, setStudents] = useState([
    { id: 1, name: "Hemanth", course: "Java" },
    { id: 2, name: "Rahul", course: "Python" },
    { id: 3, name: "Anu", course: "React" },
    { id: 4, name: "Priya", course: "DBMS" },
    { id: 5, name: "Kiran", course: "Spring" }
  ]);

  // New student object
  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const addStudent = () => {

  if (!newStudent.id || !newStudent.name || !newStudent.course) {
    alert("Please fill all fields");
    return;
  }

  setStudents([...students, newStudent]);

  // Clear inputs
  setNewStudent({
    id: "",
    name: "",
    course: ""
  });
};
  return (
  <div style={{ padding: "20px" }}>
    <h2>Student Manager</h2>

    {/* Input Fields */}
    <input
      type="number"
      placeholder="Enter ID"
      value={newStudent.id}
      onChange={(e) =>
        setNewStudent({ ...newStudent, id: e.target.value })
      }
    />

    <input
      type="text"
      placeholder="Enter Name"
      value={newStudent.name}
      onChange={(e) =>
        setNewStudent({ ...newStudent, name: e.target.value })
      }
    />

    <input
      type="text"
      placeholder="Enter Course"
      value={newStudent.course}
      onChange={(e) =>
        setNewStudent({ ...newStudent, course: e.target.value })
      }
    />

    <br /><br />
    <button onClick={addStudent}>Add Student</button>
    <h3>Student List</h3>

    <ul>
      {students.map((s, index) => (
        <li key={index}>
          ID: {s.id} | Name: {s.name} | Course: {s.course}
        </li>
      ))}
    </ul>
  </div>
);
}

export default StudentManager;