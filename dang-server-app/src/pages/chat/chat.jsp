<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello WebSocket</title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/main.css" rel="stylesheet" />
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="/app.js"></script>
  </head>
  <body>
    <noscript
      ><h2 style="color: #ff0000">
        Seems your browser doesn't support Javascript! Websocket relies on
        Javascript being enabled. Please enable Javascript and reload this page!
      </h2></noscript
    >
    <div id="chat-room" class="container">
      <div class="row">
        <div class="col-md-6">
          <form class="form-inline">
            <div class="form-group">
              <label for="connect">연결하기:</label>
              <button id="connect" class="btn btn-default" type="submit">
                대화연결
              </button>
              <button
                id="disconnect"
                class="btn btn-default"
                type="submit"
                disabled="disabled"
              >
                연결해제
              </button>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <table id="conversation" class="table">
            <thead>
              <tr>
                <th>대화창</th>
              </tr>
            </thead>
            <tbody id="greetings"></tbody>
          </table>
        </div>
      </div>
      <div class="input-box">
        <form class="form-inline">
          <div class="form-group">
            <label for="name"></label>
            <input
              type="text"
              id="name"
              class="form-control"
              placeholder="메시지 입력"
            />
          </div>
          <button id="send" class="btn btn-default" type="submit">전송</button>
        </form>
      </div>
    </div>
  </body>
</html>

<script>
  var stompClient = null;

  function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
      $("#conversation").show();
    } else {
      $("#conversation").hide();
    }
    $("#greetings").html("");
  }

  function connect() {
    var socket = new SockJS("/gs-guide-websocket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
      setConnected(true);
      console.log("Connected: " + frame);
      stompClient.subscribe("/topic/greetings", function (greeting) {
        showGreeting(JSON.parse(greeting.body).content);
      });
    });
  }

  function disconnect() {
    if (stompClient !== null) {
      stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
  }

  function sendName() {
    stompClient.send(
      "/app/hello",
      {},
      JSON.stringify({ name: $("#name").val() }),
    );
  }

  function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
  }

  $(function () {
    $("form").on("submit", function (e) {
      e.preventDefault();
    });
    $("#connect").click(function () {
      connect();
    });
    $("#disconnect").click(function () {
      disconnect();
    });
    $("#send").click(function () {
      sendName();
    });
  });
</script>
