<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3> Update </h3>
    ItemID : <input type="text" name="id" id="id" value="${product.itemid}"> <br>
    UserName : <input type="text" name="username" id="username" value="${principal.user.username}" readonly="readonly"> <br>
	ItemName : <input type="text" name="itemname" id="itemname" value="${product.itemname}"><br>
	Content : <textarea rows="5" cols="50" name="content" id="content">${product.content}</textarea><br>
	Price: <input type="text" name="price" id="price" value="${product.price}"><br>
	
    <button type="button" id="btnUpdate">수정하기</button>
    <script>
    $("#btnDelete").click(function(){
    	$.ajax({
    		type:"DELETE",
    		url:"/delete/"+$("#id").text()
    	})
    	.done(function(resp){
    		if(resp == "success"){
    		alert("삭제성공")
    		location.href="/product/list";
    		}
    	})
    })

    $("#btnUpdate").click(function(){
    	
    	var dataParam={
    		"itemname" : $("#itemname").val(),
    		"content" : $("#content").val(),
    		"price" : $("#price").val(),
    		"id" : $("#id").val()
    	}
    	$.ajax({
    		type:"PUT",
    		url :"/product/update/${product.itemid}",
    		data: JSON.stringify(dataParam),
    		contentType:"application/json;charset=utf-8"
    	})
    	.done(function(resp){
    		if(resp == "success"){
    		alert("성공")
    		location.href="/product/list";
    		}
    	})
    	.fail(function(e){
    		alert("수정실패");
    	})
    })

    </script>
</body>
</html>