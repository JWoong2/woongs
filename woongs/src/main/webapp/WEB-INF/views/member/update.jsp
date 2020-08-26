<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#update').submit(function(){
			var password1 = $("#new_password").val();
			var password2 = $("#new_password2").val();
			if(password1 == password2){
				alert('비밀번호 변경')
			}else{
				alert('입력하신 비밀번호가 다릅니다')
				return false;
			}
		})
	})
</script>
</head>
<body>
	<form action="update" method="post" id="update">
		<label for="new_password">새로운 비밀번호 입력 : </label>
		<input type="text" id="new_password" name="password"><br>
		<label for="new_password2">새로운 비밀번호 확인 : </label>
		<input type="text" id="new_password2">
		<input type="submit" value="확인">
	</form>
</body>
</html>