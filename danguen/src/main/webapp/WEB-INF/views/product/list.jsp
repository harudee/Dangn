<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>상품내용</th>
				<th>가격</th>
				<th>좋아요수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${product}" var="product" varStatus="st">
				<tr>
					<td>${product.itemid}</td>
					<td><a href="/product/view/${product.itemid}">${product.itemname}</a></td>
					<td>${product.content}</td>
					<td>${product.price}</td>
					<td>${product.replycnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>