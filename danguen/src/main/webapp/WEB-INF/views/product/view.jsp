<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="../includes/header.jsp"%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
<div class="container">
	<h3>Product View</h3>
	<br />
	<div class="form-group">
			<label for="itemid">상품번호:</label> 
			<input type="text" class="form-control" id="itemid" name="itemid" value="${product.itemid}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="username">판매자명:</label> 
			<input type="text" class="form-control" id="username" name="username" value="${principal.user.username}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="itemname">상품명:</label> 
			<input type="text" class="form-control" id="itemname" name="itemname" value="${product.itemname}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="content">상품내용:</label>
			<textarea id="content" name="content" id="content" class="form-control" readonly="readonly">${product.content }</textarea>
		</div>
		
		<div class="form-group">
			<label for="price">가격:</label> 
			<input type="number" class="form-control" id="price" name="price" value="${product.price}" readonly="readonly">
		</div>
		<c:choose>
		<c:when test="${product.user.id eq principal.user.id}">
		<button type="button" id="btnUpdate" class="btn btn-primary  btn-sm">수정</button>
 		<button type="button" id="btnDelete" class="btn btn-danger  btn-sm">삭제</button> 
 		<button type="button" id="btnChat" class="btn btn-danger  btn-sm">채팅으로 거래하기</button> 
		</c:when>
		<c:otherwise>
		<button type="button" id="btnChat" class="btn btn-danger  btn-sm">채팅으로 거래하기</button> 
		</c:otherwise>
		</c:choose>
 		

</div>
<br/><br/>

<script>
$("#btnUpdate").click(function(){
	if(!confirm("수정하시겠습니까?")) return false
	location.href="/product/update/${product.itemid}"
	
});

$("#btnDelete").click(function(){
	if(!confirm("삭제하시겠습니까?") )  return false
	$.ajax({
		type :"DELETE",
		url : "/product/delete/${product.itemid}",
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공");
				location.href="/"
			}
		} 
	})
})  

$("#btnChat").click(function(){
	alert("채팅");
	location.href="/hello/chat";
})

</script>
</body>
</html>