<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function() {
		$.ajax({
			type : "post",
			url : "chatClientRoom",
			dataType : "json"
		}).done(
				function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
					if (args.length == 0) {
						$("#client").append("<div> 채팅이 없습니다. </div>");

					} else {
						for (var i = 0; i < args.length; i++) {
							$("#client").append(
									"<div>"+ args[i].worker_name + " "
											+ "<img src='"+args[i].worker_image +"'/>" + " "
											+ args[i].title + " " 
											+ args[i].message_content + " "
											+ args[i].unReadCount + " "
											+ args[i].message_sendTime + " "
											+ "<a href='chatAsk?no="+args[i].post_no+"&&user_id="+ args[i].worker_id +"'>채팅</a>"
											+"</div>");
						}
					}
				}).fail(function(e) {
			alert(e.responseText);
		})

		$.ajax({
			type : "post",
			url : "chatWorkerRoom",
			dataType : "json"
		}).done(
				function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
					if (args.length == 0) {
						$("#worker").append("<div> 채팅이 없습니다. </div>");
					} else {
						for (var i = 0; i < args.length; i++) {
							$("#worker").append(
									"<div>"+ args[i].client_name + " "
									+ "<img src='"+args[i].client_image +"'/>" + " "
									+ args[i].title + " " 
									+ args[i].message_content + " "
									+ args[i].unReadCount + " "
									+ args[i].message_sendTime + " "
									+ "<a href='chatAnswer?no="+args[i].post_no+"&&user_id="+ args[i].client_id +"'>채팅</a>"
									+"</div>");
						}
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	});
</script>

<div id="client">의뢰인</div>
<div id="worker">작업자</div>

</body>
</html>