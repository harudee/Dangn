import axios from "axios";
import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const View = ({ match, props }) => {
  const itemid = match.params.itemid;
  console.log(itemid);

  const [product, setproduct] = useState({}, []);

  useEffect(() => {
    axios({
      method: "GET",
      url: "http://localhost:7777/view/" + itemid,
    })
      .then((res) => {
        console.log(res);
        setproduct(res.data.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []); //io 멈춰 []

  console.log(product);

  //삭제하기
  const [proDel, setProdel] = useState(product);

  const deleteOne = (e) => {
    alert("삭제실행");
    axios({
      method: "DELETE",
      url: "http://localhost:7777/product/delete/" + itemid,
    })
      .then((res) => {
        setProdel(res);
        //화면동기화
      })
      .catch((error) => {
        alert("삭제실패");
        console.log(error);
      });
  };

  return (
    <div>
      <h3>Product View</h3>
      <hr />
      <Card border="success" style={{ width: "18rem" }}>
        <Card.Header>{product.itemid}</Card.Header>
        <Card.Body>
          <h4 className="card-title">{product.itemname}</h4>
          <div>{product.content}</div>

          <Link
            to={`/product/list`}
            type="submit"
            className="btn btn-danger"
            onClick={deleteOne}
          >
            삭제
          </Link>
          <Link
            to={`/product/update/${product.itemid}`}
            className="btn btn-info"
          >
            수정
          </Link>
        </Card.Body>
      </Card>
    </div>
  );
};

export default View;
