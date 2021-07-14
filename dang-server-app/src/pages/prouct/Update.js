import axios from "axios";
import React, { useState } from "react";

const Update = ({ match, props }) => {
  const itemid = match.params.itemid;
  console.log(itemid);

  const [updaPro, setUpdaPro] = useState({
    itemname: "",
    content: "",
    price: "",
  });

  console.log(updaPro);

  const changeValue = (e) => {
    setUpdaPro({
      ...updaPro,
      [e.target.name]: e.target.value,
    });
  };

  const submit = (e) => {
    e.preventDefault();

    axios({
      method: "PUT",
      headers: { "content-type": "application/json; charset=utf-8" },
      data: JSON.stringify(updaPro),
      url: "http://localhost:7777/product/update/" + itemid,
    })
      .then((res) => {
        setUpdaPro(res);
        //props.history.push("/product/list");
      })
      .catch((error) => {
        alert("등록실패");
        console.log(error);
      });
  };

  return (
    <div>
      <h1>Update</h1>
      <label>itemname: </label>
      <input type="text" name="itemname" onChange={changeValue} />
      <br />
      <label>content: </label>
      <input type="text" name="content" onChange={changeValue} />
      <br />
      <label>price: </label>
      <input type="text" name="price" onChange={changeValue} />
      <br />

      <button onClick={submit}> 수정완료 </button>
    </div>
  );
};

export default Update;
