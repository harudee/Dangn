<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<section id="content" class="text-m">


	<div class="container">
		<br /> <br /> <br /> <br />
		<div>
			<h1>회원 가입</h1>
			<br>
		</div>
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

		<div class="form-group">
			<label for="address">주소</label> <input type="text" id="address"
				name="address" class="form-control" placeholder="주소를 입력해 주세요">
		</div>
		<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
		<button type="button" class="btn btn-primary"
			onclick="location.href='/'">돌아가기</button>
	</div>
	<script>
		$("#btnJoin").click(function() {
			if ($("#username").val() == "") {
				alert("아이디를 입력하세요");
				$("#username").focus();
				return false;
			}
			if ($("#password").val() == "") {
				alert("비밀번호를 입력하세요");
				$("#password").focus();
				return false;
			}
			var data = {
				"username" : $("#username").val(),
				"password" : $("#password").val(),
				"address" : $("#address").val()
			}
			$.ajax({
				type : "POST",
				ur : "/register",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(data)
			}).done(function(resp) {
				if (resp == "success") {
					alert("회원가입 성공");
					location.href = "/login";
				} else if (resp == "fail") {
					alert("아이디 중복");
					$("#username").val("");
				}
			}).fail(function() {
				alert("회원가입실패");
			})

		})
	</script>
	</body>
	</html>