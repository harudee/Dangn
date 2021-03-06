<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<section id="content" class="text-m">
	<div class="container">
		<br /> <br /> <br /> <br />
		<div>
			<h1>π₯π₯νμμ λ³΄ μμ π₯π₯</h1>
			<br>
		</div>
		<div class="form-group">
			<label for="username">μμ΄λ</label> <input type="text"
				class="form-control" id="username" name="username"
				value="${user.username}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="password">λΉλ°λ²νΈ</label> <input type="password"
				class="form-control" id="password" name="password" value="">
		</div>

		<div class="form-group">
			<label for="address">μ£Όμ</label> <input type="text" id="address"
				name="address" class="form-control" value="${user.address}">
		</div>
		<button type="button" class="btn btn-primary" id="btnModify">μμ νκΈ°</button>
		<button type="button" class="btn btn-primary"
			onclick="location.href='/'">λμκ°κΈ°</button>
		<button type="button" class="btn btn-primary" id="btnDelete">νν΄νκΈ°</button>
	</div>

</section>
<script>
$("#btnModify").click(function(){
	data = {
		"id" : ${user.id},	 
		"password" : $("#password").val(),	 
		"email" : $("#email").val(),
		"phone" : $("#phone").val(),
		"address" : $("#address").val()
	}
	$.ajax({
		type : "PUT",
		url : "/update/${user.id}",
		contentType: "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp){
		if(resp=="success"){
			alert("μμ μ±κ³΅");
			location.href="/";
		}
	})
})


$("#btnDelete").click(function(){
	if(!confirm("μ λ§ μ­μ ν κΉμ?") )  return false
	$.ajax({
		type :"DELETE",
		url : "/delete/${user.id}",
		success:function(resp){
			if(resp=="success"){
				alert("μ­μ μ±κ³΅");
				location.href="/logout";
			}
		} //success
	})//ajax
})  //btnDelete
</script>

</body>
</html>