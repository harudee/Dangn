//import axios from "axios";
import axios from "axios";
import React, { useEffect, useState } from "react";

const LoginPage = (props) => {
  const [loginUser, setLoginUser] = useState({
    username: "",
    password: "",
  });

  const changeInput = (e) => {
    setLoginUser({
      ...loginUser,
      [e.target.name]: e.target.value,
    });
  };

  const loginPro = async (e) => {
    e.preventDefault();

    await alert("loginPro실행됨");
    axios({
      method: "POST",
      headers: { "content-type": "application/json; charset=utf-8" },
      data: JSON.stringify(loginUser),
      url: "http://localhost:7777/login",
    })
      .then((res) => {
        console.log(res);
      })
      .then((res) => {});
  };

  useEffect(() => {}, []);

  return (
    <div>
      <h1>Login</h1>
      <label>username: </label>
      <input type="text" name="username" onChange={changeInput} />
      <br />
      <label>password: </label>
      <input type="text" name="password" onChange={changeInput} />
      <br />

      <button type="submit" onClick={loginPro}>
        로그인
      </button>
    </div>
  );
};

export default LoginPage;
