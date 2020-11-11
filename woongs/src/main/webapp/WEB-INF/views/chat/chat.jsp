<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-grid.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-reboot.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<!-- <link rel="stylesheet" type="text/css" href="resources/css/page.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" type="text/css" href="resources/css/style.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/sockjs.min.js"></script>
<style>
	.my{width: auto; float: right; clear: both;}
	.my_chat{background-color:#a5cfcf; padding : 10px 5px; float:left; border-radius:10px;}
	.your{background-color: #ACF3FF; padding: 10px 50px 10px 20px; border-radius: 10px; width: auto; display: inline-block; min-width: 130px;}
	.time{font-size:9px; text-align:right; float:right; position:absolute; bottom: -18px; right: -10px;}
</style>
</head>
<body>
<c:set var="profile" value='<%=session.getAttribute("login")%>' />
 	<div class="col-12 row justify-content-center align-items-center my-5 ">
		<a href=""><img src="resources/Temp_ung_Logo.PNG"
			alt="Ung Logo" width="180px" class="img-fluid" /></a>
	</div>
	<div class="col-12">
		<div class="col-2" style="float: left">
			<span> 목록 </span>
		</div>
		<div class="col-8" style="float: left; text-align: center;">
			${partnerInfo.nick_name } 님과 대화</div>
		<div class="col-2" style="float: right">
			<span> 닫기 </span>
		</div>

	</div>
	<div class="col-12" style="margin-top: 40px; clear: both;">
		<div class="col-10" style="margin: 20px auto; text-align: center; color: white; background-color: #01D1FE; border: 1px solid #01D1FE; padding: 10px 10px; border-radius: 8px;">
			일정과 작업내용에 대해 문의해보세요. <br>(연락처 문의 또는 직접 계좌를 알려주는 것은 불가)
		</div>

	</div>
	<!-- 채팅 내용 -->
	<div class="col-12">
		<div class="col-11"
			style="margin: 0 auto; border: 1px solid #01D1FE; height: 400px; border-radius: 10px; overflow:scroll" id = "chatArea">
			<div id="chatMessageArea" style = "margin-top : 10px; margin-left:10px;"></div>
		</div>
	</div>

	<!-- 채팅 입력창 -->
	<div class="col-12" style="margin-top: 20px; margin-bottom: 15px;">
		<div class="col-12" style="float: left">
			<textarea class="form-control" style="border: 1px solid #01D1FE; height: 65px; float: left; width: 80%" placeholder="Enter ..." id = "message"> </textarea>
			<span style="float: right; width: 18%; height: 65px; text-align: center; background-color: #01D1FE; border-radius: 5px;">
				<a style="margin-top: 30px; text-align: center; color: white; font-weight: bold;" id = "sendBtn"><br>전송</a>
			</span>
		</div>
	</div>

<img id="profileImg" class="img-fluid" src="${partnerInfo.image} " style = "display:none">
<input type="text" id="nickname" value = "${partnerInfo.nick_name }" style = "display:none">
 <input type="button" id="enterBtn" value="입장" style = "display:none">
 <input type="button" id="exitBtn" value="나가기" style = "display:none">
<script type="text/javascript">
 connect();
 function connect() {
	    sock = new SockJS('/chat');

	    sock.onopen = function() {
	        console.log('Info : connection opened.');
	        var params = {
	    	        chatroom_id : ${roomInfo.chatroom_id},
	    	        user_id : '${profile.user_id}',
	        }
	        
	        $.ajax({
	    		type:"post"
	    		,url:"chatPreviousContent"	
	    		,data:params
	    		,dataType:"json" })
	    		.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
		    		for(var i=0; i<args.length; i++) {
		    			appendMessage(args[i]);	
			    		}
	    				})
	        	.fail(function(e) {
	    	    	alert(e.responseText);
	        })
	    };
	    
	    sock.onmessage = function(evt) {
		    console.log("메세지 받음!");
    	 	var data = evt.data;
    	   console.log(data)
  		   var obj = JSON.parse(data)  	   
    	   console.log(obj)
    	   appendMessage(obj);
	    };
	    
	    sock.onclose = function() {
	        console.log('Info : connection closed.');
	    };
	}

 function send() {
  var msg = $("#message").val();
  if(msg != ""){
	  message = {};
	  message.message_content = $("#message").val()
  	  message.worker_id = '${profile.worker_id}'
  	  message.client_id = '${profile.client_id}'
  	  message.post_no = '${profile.post_no}'
  	  message.message_sender = '${profile.user_id}'
  }

  sock.send(JSON.stringify(message));
  $("#message").val("");
 }

 function getTimeStamp() {
   var d = new Date();
   var s =
     leadingZeros(d.getFullYear(), 4) + '-' +
     leadingZeros(d.getMonth() + 1, 2) + '-' +
     leadingZeros(d.getDate(), 2) + ' ' +

     leadingZeros(d.getHours(), 2) + ':' +
     leadingZeros(d.getMinutes(), 2) + ':' +
     leadingZeros(d.getSeconds(), 2);

   return s;
 }

 function leadingZeros(n, digits) {
   var zero = '';
   n = n.toString();

   if (n.length < digits) {
     for (i = 0; i < digits - n.length; i++)
       zero += '0';
   }
   return zero + n;
 }

 function appendMessage(obj) {
	 if(obj.message_content== ""){
		 return false;
	 }else{
// 만약에 자기가 보낸거면 오른쪽
// 다른 사람이 보낸거면 왼쪽으로 붙이고 색상 다르게
		 if(obj.message_sender == "${profile.user_id}") {
			 var t = obj.message_sendTime;
			 $("#chatMessageArea").append("<div class='col-12 row my' style = 'height : auto; margin-top : 5px;'><div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'></div><div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'><div class = 'col-12 my_chat'><span style = 'font-size : 12px;'>"+obj.message_content+"</span></div><div col-12 style = 'font-size:9px; text-align:right; float:right;'><span style ='float:right; font-size:9px; text-align:right;' >"+t+"</span></div></div></div>")		 

			  var chatAreaHeight = $("#chatArea").height();
			  var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
			  $("#chatArea").scrollTop(maxScroll);
			  
		}else if(obj.message_sender == "${partnerInfo.email}"	){
			 var t = obj.message_sendTime;
			 $("#chatMessageArea").append("<div class='col-12 row' style = 'height : auto; margin-top : 5px;'><div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'><img id='profileImg' class='img-fluid' src='${partnerInfo.image}' style = 'width:50px; height:50px; '><div style='font-size:9px; clear:both;'>${partnerInfo.nick_name}</div></div><div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'><div class = 'col-12 your'><div class='col-12 time'><span style ='float:right; font-size:9px; text-align:right;' >"+t+"</span></div><span style = 'font-size : 12px;'>"+obj.message_content+"</span></div></div></div>")		 

			  var chatAreaHeight = $("#chatArea").height();
			  var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
			  $("#chatArea").scrollTop(maxScroll);
		}
	 }
 }
 
 $(document).ready(function() {
  $('#message').keypress(function(event){
   var keycode = (event.keyCode ? event.keyCode : event.which);
   if(keycode == '13'){
    send();
   }
   event.stopPropagation();
  });

  $('#sendBtn').click(function() { send(); });

  /* $('#enterBtn').click(function() { connect(); }); $('#exitBtn').click(function() { disconnect(); }); */
 });
</script>

</body>
</html>
