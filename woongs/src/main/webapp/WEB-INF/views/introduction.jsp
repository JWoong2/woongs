<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전문가 소개</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<script type="text/javascript">
	//닉네임 keyup
	$(document).ready(function() {
		$("#nick_name").keyup(function() {
			$("#nick_name1").text($("#nick_name").val());
		});
	});

	//자기소개 keyup
	$(document).ready(function() {
		$("#introduce").keyup(function() {
			$("#introduce1").text($("#introduce").val());
		});
	});
</script>

<body>
	<form action="/intro" method="post" enctype="multipart/form-data">
		<img alt="" src="resources/Images/ra.jpg" height="120" width="120">
		image : <input type="file" name="report" method="post">
		<br>닉네임 <br> <input type="text" id="nick_name"
			name="nick_name"><br> 자기소개<br>
		<textarea rows="20" cols="50" id="introduce" name="introduce"></textarea>
		<br> <input type="submit" value="저장후다음"><br>
		<br> 전문가 소개
		<div id="nick_name1">닉네임 출력</div>
		<div id="introduce1">자기소개 출력</div>
	</form>








</body>
</html>