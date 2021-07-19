<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">
	<h1>로그인</h1>
		<br>
	<form action="/login" method="post">
	
		<div class="form-group">
			<label for="username">아이디</label> <input type="text"
				class="form-control" id="username" placeholder="아이디를 입력해 주세요"
				name="username">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password"
				class="form-control" id="password" placeholder="비밀번호를 입력해 주세요"
				name="password">
		</div>
		<button class="btn btn-primary">로그인</button>
	</form>
	</div>
 </body>
</html>	