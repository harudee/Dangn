import axios from "axios";
import React, { useEffect, useState } from "react";

const Home = ({ match, props }) => {
  const [user, setUser] = useState("홍길동"); //초기값 홍길동

  useEffect(() => {
    axios({
      method: "GET",
      url: "http://localhost:7777/user/3",
    })
      .then((res) => {
        console.log(res);
        res.json();
      })
      .then((res) => {
        console.log(res);
        setUser(res);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>HOME</h1>
      <h3>접속한 유저는: {user.username}</h3>
      <h3>비밀번호: {user.password}</h3>
      <h3>주소: {user.address}</h3>
    </div>
  );
};
export default Home;
