<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>이메일을 확인해주세요</p>
	<form action="code" method="post">
		<label for="code">인증번호 입력</label>
		<input type="text" id="code" name="code">
		<input type="submit" value="인증">
	</form>
</body>
</html>