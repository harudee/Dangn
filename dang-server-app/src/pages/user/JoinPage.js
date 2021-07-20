import React, { useState } from "react";

const JoinPage = (props) => {
  const [joinUser, setJoinUser] = useState({
    username: "",
    password: "",
    address: "",
  });

  const changeValue = (e) => {
    setJoinUser({
      ...joinUser,
      [e.target.name]: e.target.value,
    });
  };

  const submit = (e) => {
    e.preventDefault();

    fetch("http://localhost:7777/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(joinUser),
    })
      .then((res) => {
        console.log(res);
        props.history.push("/login");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1>JoinPage</h1>
      <label>username: </label>
      <input type="text" name="username" onChange={changeValue} />
      <br />
      <label>password: </label>
      <input type="text" name="password" onChange={changeValue} />
      <br />
      <label>address: </label>
      <input type="text" name="address" onChange={changeValue} />
      <br />

      <button onClick={submit}>상품등록 </button>
    </div>
  );
};

export default JoinPage;
