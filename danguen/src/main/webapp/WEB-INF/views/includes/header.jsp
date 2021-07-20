<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<html>
<head>
<meta charset="UTF-8">
<head>
<title>당근당근당근</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="/images/icons/shortcut_icon.png" rel="shortcut icon"
	type="image/x-icon">
<link rel="shortcut icon" type="image/x-icon"
	href="https://d1unjqcospf8gs.cloudfront.net/favicon.ico" />


<link rel="stylesheet" media="all"
	href="https://d1unjqcospf8gs.cloudfront.net/assets/home/home-8695fc9a40c1263ffd9b650de5ca008a147a650c5c559cac4c2eecb262b6baef.css" />


<link rel="apple-touch-icon" sizes="192x192"
	href="/images/icons/daangn_logo_192.png">

</head>
<body>

	<header id="fixed-bar">
		<div id="fixed-bar-wrap">
			<h1 id="fixed-bar-logo-title">
				<a href="/"> <span class="sr-only">당근마켓</span> <img
					class="fixed-logo" alt="당근마켓"
					src="https://d1unjqcospf8gs.cloudfront.net/assets/home/base/header/logo-basic-24b18257ac4ef693c02233bf21e9cb7ecbf43ebd8d5b40c24d99e14094a44c81.svg" />
				</a>
			</h1>

			<section id="fixed-bar-search">
				<div class="search-input-wrap">
					<span class="sr-only">검색</span> <input type="text"
						name="header-search-input" id="header-search-input"
						class="fixed-search-input text-m"
						placeholder="동네 이름, 물품명 등을 검색해보세요!" />
					<button id="header-search-button">
						<img class="fixed-search-icon" alt="Search"
							src="https://d1unjqcospf8gs.cloudfront.net/assets/home/base/header/search-icon-7008edd4f9aaa32188f55e65258f1c1905d7a9d1a3ca2a07ae809b5535380f14.svg" />
					</button>
				</div>
			</section>

			<section class="fixed-bar-menu">
				<sec:authorize access="isAnonymous()">
					<a href="/login" target="_blank">
						<button class="chat-button">
							<span class="button-text">로그인</span>
						</button>
					</a>
					<a href="/register" target="_blank">
						<button class="chat-button">
							<span class="button-text">회원가입</span>
						</button>
					</a>
				</sec:authorize>
			</section>

			<section class="fixed-bar-menu">
				<sec:authorize access="isAuthenticated()">
					<div class="btn-group">
						<a href="/hello/chat" target="_blank">
							<button class="chat-button ">
								<span class="button-text">채팅하기</span>
							</button>
						</a>
						<div class="btn-group">
							<button class="chat-button dropdown-toggle"
								data-toggle="dropdown">
								<span class="button-text">나의 당근</span>
							</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/update/${principal.user.id}"
									target="_blank">
									<button class="chat-button">
										<span class="button-text">회원정보수정</span>
									</button>
								</a> <a class="dropdown-item" href="/logout" target="_blank">
									<button class="chat-button">
										<span class="button-text">로그아웃(<sec:authentication
												property="principal.user.username" />)
										</span>
									</button>
								</a>
							</div>
						</div>

						<div class="btn-group">
							<button class="chat-button dropdown-toggle"
								data-toggle="dropdown">
								<span class="button-text">중고거래</span>
							</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/product/insert" target="_blank">
									<button class="chat-button">
										<span class="button-text">상품등록</span>
									</button>
								</a> 
								<a class="dropdown-item" href="/product/list" target="_blank">
									<button class="chat-button">
										<span class="button-text">상품목록</span>
									</button>
								</a>
							</div>
						</div>
					</div>
				</sec:authorize>
			</section>
		</div>
	</header>