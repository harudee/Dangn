import React from "react";
import './chat.css';
import $ from "jquery";


const chat = () => {

  

  var ws;

  const wsOpen = () => {
    ws = new WebSocket("ws://" + window.location.href + "/chating");
		wsEvt();
  }

  const wsEvt = () => {
    ws.onopen = function(data){

    }

    ws.onmessage = function(data){
      var msg = data.data;
      if(msg != null && msg.trim() !==''){
        var d = JSON.parse(msg);
        if(d.type === "getId"){
          var si = d.sessionId != null ? d.sessionId : "";
          if(si !== ''){
            $("#sessionId").var(si);
          }
        }else if(d.type === "message"){
          if(d.sessionId === $("#sessionId").val()){
            $("#chating").append("<p className='me'>나 :" + d.msg + "</p>");
          }else{
            $("#chating").append("<p className='others'>나 :" + d.userName + d.msg + "</p>");
          }

        } else {
          console.warn("잘못된 형식입니다!");
        }
      }
    }
  }

  const chatName = () => {
    var userName = $("#userName").val();
    if(userName == null || userName.trim() === ""){
      alert("사용자 이름을 입력해주세요.");
      $("#userName");
    }else {
      wsOpen();
      $("#yourName").hide();
      $("#yourMsg").show();
    }
  }

  const send = () => {
    var option ={
      type : "message",
      sessionId : $("#sessionId").val(),
      userName : $("#userName").val(),
      msg : $("#chatting").val()
    }
    
    $('#chatting').val();
  }

  
  return <div id="container" className="container">
    <h1>채팅</h1>
    <input type="hidden" id="sessionId" value=""/>

    <div id="chating" className="chating"></div>

    <div id="yourName">
      <table className="inputTable">
        <tr>
          <th>사용자명</th>
          <th><input type="text" name="userName" id="userName"/></th>
          <th><button onClick={chatName} id="startBtn">이름등록</button></th>
        </tr>
      </table>
    </div>
    <div id="yourMsg">
      <table className="inputTable">
        <tr>
          <th>메시지</th>
          <th><input id="chatting" placeholder="메시지를 입력하세요." /></th>
          <th><button onClick={send} id="sendBtn">보내기</button></th>
        </tr>
      </table>
    </div>
  </div>;
};

export default chat;
