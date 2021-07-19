import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div>
      <div id="fixed-bar">
        <div id="fixed-bar-wrap">
          <h1 id="fixed-bar-logo-title">
            <a href="/">
              <span className="sr-only">당근당근</span>
              <img
                className="fixed-logo"
                alt="당근"
                src="https://d1unjqcospf8gs.cloudfront.net/assets/home/base/header/logo-basic-24b18257ac4ef693c02233bf21e9cb7ecbf43ebd8d5b40c24d99e14094a44c81.svg"
              />
            </a>
          </h1>
        </div>
      </div>
      <ul>
        <li>
          <Link to="/register">회원가입</Link>
        </li>
        <li>
          <Link to="/login">로그인</Link>
        </li>

        <li>
          <Link to="/user/update/:id">회원수정</Link>
        </li>
        <li>
          <Link to="/list">상품목록</Link>
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
