<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<section id="content" class="text-m">
	<div class="container">
		<br /> <br /> <br /> <br />
		<div>
			<h1>๐ฅ๐ฅ๋ก๊ทธ์ธ๐ฅ๐ฅ</h1>
			<br>
		</div>
		<div class="description-sub">
			<form action="/loginProc" method="post">

				<div class="form-group">
					<label for="username">์์ด๋</label> <input type="text"
						class="form-control" id="username" placeholder="์์ด๋๋ฅผ ์๋ ฅํด ์ฃผ์ธ์"
						name="username">
				</div>

				<div class="form-group">
					<label for="password">๋น๋ฐ๋ฒํธ</label> <input type="password"
						class="form-control" id="password" placeholder="๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํด ์ฃผ์ธ์"
						name="password">
				</div>
				<button class="btn btn-primary">๋ก๊ทธ์ธ</button>
				<button type="button" class="btn btn-primary"
			onclick="location.href='/register'">ํ์๊ฐ์ํ๋ฌ ๊ฐ๊ธฐ</button>
			</form>
		</div>
	</div>
</section>
</body>
</html>
