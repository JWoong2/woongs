<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="login" method="post">
		<label for="email">아이디</label>
		<input type="text" id="email" name="email">
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="password">
		<input type="submit" value="확인">
	</form>
</body>
</html>