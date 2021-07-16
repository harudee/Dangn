import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div>
      <h3>Header</h3>
      <ul>
        <li>
          <Link to="/product/list">상품목록</Link>
        </li>
        <li>
          <Link to="/product/insert">상품등록</Link>
        </li>
        
      </ul>
      <hr />
    </div>
  );
};

export default Header;
