<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello WebSocket</title>
<!--     <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="/main.css" rel="stylesheet">
<!--     <script src="/webjars/jquery/jquery.min.js"></script> -->
<!--     <script src="/webjars/sockjs-client/sockjs.min.js"></script> -->
<!--     <script src="/webjars/stomp-websocket/stomp.min.js"></script> -->
<!--     <script src="/app.js"></script> -->
</head>
<body>
	<div id="container" class="container"> 

		<h1>채팅</h1>
		<div class="card">
			<div class="card-container">
				<img src="/resources/images/${product.fileName}"/>
				<div class="content-container">
					<h4>상품명:</h4><p>${product.itemname}</p>&nbsp;&nbsp;&nbsp;
					<h4>판매자명:</h4><p>${product.user.username}</p>
					<h4>상품가격:</h4><p>${product.price}</p>
				</div>
			</div>
		</div>
		
		<input type="hidden" id="sessionId" value="" />
		
		
		<div class="chatroom" id="chatroom">
			<div id="chating" class="chating">
			</div>
			
			<span id="yourName">
				<input type="hidden" id="userName" name="userName" value="${principal.user.username}"/>
				<button onclick="chatName()" id="sendBtn">연결하기</button>
			</span>
			
			<div id="yourMsg">
				<table class="inputTable">
					<tr>
						<th>메시지</th>
						<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
						<th><button onclick="send()" id="sendBtn">보내기</button></th>
					</tr>
				</table>
			</div>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	var ws;

	var now = new Date();
	var hour = now.getHours();
	var min = now.getMinutes();
	var str = "";
	
	if(hour < 12){
		str = "오전";
	}else{
		str = "오후";
	}
	
	function wsOpen(){
		ws = new WebSocket("ws://" + location.host + "/chating");
		wsEvt();
	}
		
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 동작
		}
		
		ws.onmessage = function(data) {
			//메시지를 받으면 동작
			var msg = data.data;
			if(msg != null && msg.trim() != ''){
				var d = JSON.parse(msg);
				if(d.type == "getId"){
					var si = d.sessionId != null ? d.sessionId : "";
					if(si != ''){
						$("#sessionId").val(si); 
					}
				}else if(d.type == "message"){
					if(d.sessionId == $("#sessionId").val()){
						$("#chating").append("<p class='me'>나 :" + d.msg + "</p>" + str + ":" + hour + "시" + min + "분");	
					}else{
						$("#chating").append("<p class='others'>" + d.userName + " :" + d.msg + "</p>" + str + ":" + hour + "시" + min + "분");
					}
						
				}else{
					console.warn("unknown type!")
				}
			}
		}

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}
	
	function chatName(){
		
		var userName = $("#userName").val();
		
		if(userName == null || userName.trim() == ""){
			//alert("사용자 이름을 입력해주세요.");
			$("#userName").focus();
		}else{
			wsOpen();
			$("#yourName").hide();
			$("#yourMsg").show();
		}
		
	}

	function send() {
		var option ={
			type: "message",
			sessionId : $("#sessionId").val(),
			userName : $("#userName").val(),
			msg : $("#chatting").val()
		}
		ws.send(JSON.stringify(option))
		$('#chatting').val("");
	}
	
	function chatStart(){
		
		chatName();
		send();
	}
</script>
</html>
