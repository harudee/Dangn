<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<section id="content">
	<article id="container">
		<h3>Product View</h3>
		<br />
		
		<img src="/resources/images/${product.fileName}" width="600" height="600">
		
		<div class="form-group">
			<label for="itemid">상품번호:</label> <input type="text"
				class="form-control" id="itemid" name="itemid"
				value="${product.itemid}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="username">판매자명:</label> <input type="text"
				class="form-control" id="username" name="username"
				value="${product.user.username}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="itemname">상품명:</label> <input type="text"
				class="form-control" id="itemname" name="itemname"
				value="${product.itemname}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="content">상품내용:</label>
			<textarea id="content" name="content" id="content"
				class="form-control" readonly="readonly">${product.content }</textarea>
		</div>

		<div class="form-group">
			<label for="price">가격:</label> <input type="number"
				class="form-control" id="price" name="price"
				value="${product.price}" readonly="readonly">
		</div>

	</article>

	<c:choose>
		<c:when test="${product.user.id eq principal.user.id}">
			<button type="button" id="btnUpdate" class="btn btn-primary  btn-sm">수정</button>
			<button type="button" id="btnDelete" class="btn btn-danger  btn-sm">삭제</button>
			<button type="button" id="btnChat" class="btn btn-danger  btn-sm">채팅으로
				거래하기</button>
		</c:when>
		<c:otherwise>
			<button type="button" id="btnChat" class="btn btn-danger  btn-sm">채팅으로
				거래하기</button>
		</c:otherwise>
	</c:choose>

	<!-- 댓글추가 -->
	<br /> <br />
	<div align="center">
		<div>
			<label for="username">로그인한 유저: </label> <input type="text"
				value="${principal.user.username }" readonly="readonly">
		</div>
		<textarea rows="3" cols="50" id="msg"></textarea>
		<input type="button" class="btn btn-secondary btn-sm" id="btnComment"
			value="댓글쓰기">
	</div>
	<hr />
<div>
	<table class="table table-borderless">
		<c:forEach items="${product.comments}" var="comment">
		<tr>
			<td>${comment.commentid }</td>
			<td>${comment.user.username}</td>
			<td>${comment.content }</td>
			<td><fmt:formatDate value="${comment.regdate }" pattern="yyyy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</table>
</div>
	<hr />
</section>

<br />
<br />

<script>
	$("#btnUpdate").click(function() {
		if (!confirm("수정하시겠습니까?"))
			return false
		location.href = "/product/update/${product.itemid}"

	});//글 수정

	$("#btnDelete").click(function() {
		if (!confirm("삭제하시겠습니까?"))
			return false
		$.ajax({
			type : "DELETE",
			url : "/product/delete/${product.itemid}",
			success : function(resp) {
				if (resp == "success") {
					alert("삭제성공");
					location.href = "/"
				}
			}
		})
	});//글 삭제

	$("#btnChat").click(function() {
		alert("채팅");
		location.href = "/hello/chat";
	})//채팅
	
	
	/* 댓글처리로직 */
	$("#btnComment").click(function(){
		console.log($("#itemid").val());
		
		if(${empty principal.user}){
			alert("로그인 먼저 하세요");
			location.href="/login";
			return;
		}
		if($("#msg").val()==""){
			alert("댓글을 적으세요");
			return;
		}
		data = {
				"id":$("#username").val(),
				"itemid":$("#itemid").val(),
				
				"content":$("#msg").val()
		}
		$.ajax({
			type:"POST",
			url:"/reply/insert/"+$("#itemid").val(),
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(data),
		})
		.done(function(){
			alert("댓글 추가 성공");
			location.href="/product/view/${product.itemid}";
			//init();
		})
		.fail(function(){
			alert("댓글 추가 실패");
		})
	})//댓글 입력
	
	//댓글 list
	/* var init = function(){
		$.ajax({
			type:"get",
			url:"/reply/commentList/"+$("#itemid").val()
		})
		.done(function(resp){
			//alert(resp.length);
			var str="";
			$.each(resp, function(key, val){
				str += val.user.id+""
				str += val.content+""
				str += val.regdate+"<br>"
			})
			$("#replyResult").html(str);
		})
		.fail(function(e){
			alert("error:"+e);
		})//ajax */
	//}댓글리스트 init function

//init();
</script>
</body>
</html>