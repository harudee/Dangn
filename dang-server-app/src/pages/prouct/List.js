import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const List = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios({
      method: "GET",
      url: "http://localhost:7777/list",
    })
      .then((res) => {
        setProducts(res.data.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div className>
      <h3>Product List</h3>

      {products.map((product) => (
        <ul key={product.itemid}>
          {/* 링크 누르면 컨트롤러를 타야지! */}
          <li>
            <Link
              to={{
                pathname: `/product/view/${product.itemid}`,
              }}
            >
              {product.itemname}
            </Link>
          </li>
        </ul>
      ))}
    </div>
  );
};

export default List;
