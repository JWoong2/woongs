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
				alert('��й�ȣ ����')
			}else{
				alert('�Է��Ͻ� ��й�ȣ�� �ٸ��ϴ�')
				return false;
			}
		})
	})
</script>
</head>
<body>
	<form action="update" method="post" id="update">
		<label for="new_password">���ο� ��й�ȣ �Է� : </label>
		<input type="text" id="new_password" name="password"><br>
		<label for="new_password2">���ο� ��й�ȣ Ȯ�� : </label>
		<input type="text" id="new_password2">
		<input type="submit" value="Ȯ��">
	</form>
</body>
</html>