<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<div class="form-group">
			<label for="itemname">상품명:</label> <input type="text"
				class="form-control" id="itemname" name="itemname"
				placeholder="Enter itemid">

		</div>
		<div class="form-group">
			<label for="content">상품내용:</label>
			<textarea id="content" name="content" id="content"
				class="form-control"></textarea>
		</div>
		<div class="form-group">
			<label for="price">가격:</label> <input type="number"
				class="form-control" id="price" placeholder="Enter price"
				name="price">
		</div>
		

		<button type="submit" class="btn btn-primary">상품등록</button>
	</form>


</body>
</html>