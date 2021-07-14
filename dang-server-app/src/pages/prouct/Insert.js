import axios from "axios";
import React, { useState } from "react";

const Insert = (props) => {
  const [productDto, setProductDto] = useState({
    itemname: "",
    content: "",
    price: "",
  });

  console.log(productDto);

  const changeValue = (e) => {
    setProductDto({
      ...productDto,
      [e.target.name]: e.target.value,
    });
  };

  const submit = (e) => {
    e.preventDefault();

    axios({
      method: "POST",
      headers: { "content-type": "application/json; charset=utf-8" },
      data: JSON.stringify(productDto),
      url: "http://localhost:7777/product/insert",
    })
      .then((res) => {
        console.log(res);
        props.history.push("/product/list");
      })
      .catch((error) => {
        alert("등록 실패");
        console.log(error);
      });
  };

  return (
    <div>
      <h3>Insert</h3>
      <label>itemname: </label>
      <input type="text" name="itemname" onChange={changeValue} />
      <br />
      <label>content: </label>
      <input type="text" name="content" onChange={changeValue} />
      <br />
      <label>price: </label>
      <input type="text" name="price" onChange={changeValue} />
      <br />

      <button onClick={submit}>상품등록 </button>
    </div>
  );
};

export default Insert;
