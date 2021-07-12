<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<html>
<head>
<meta charset="UTF-8">
<head>
  <title>Main Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3"  >
   <ul class="navbar-nav">
   <sec:authorize access="isAnonymous()"> 
    <li class="nav-item">
      <a class="nav-link" href="/register">회원가입</a>
    </li>
    <li class="nav-item" >
      <a class="nav-link" href="/login">로그인</a>
    </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
     <li class="nav-item" >
     <a class="nav-link" href="/update/${principal.user.id}">회원정보수정</a>
      <a class="nav-link" href="/logout">
      로그아웃(<sec:authentication property="principal.user.username"/>)
      </a>
    </li>
    <li class="nav-item" >
      <a class="nav-link" href="/product/insert">상품등록</a>
    </li>
    <li class="nav-item" >
      <a class="nav-link" href="/product/list">상품목록</a>
    </li>
    </sec:authorize>
  </ul>
</nav>
