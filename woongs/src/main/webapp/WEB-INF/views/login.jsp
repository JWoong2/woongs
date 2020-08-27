<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
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
		<label for="email">아이디</label> <input type="text" id="email"
			name="email"> <label for="password">비밀번호</label> <input
			type="password" id="password" name="password"> <input
			type="submit" value="확인">
	</form>
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
	<div id="naver_id_login"></div>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("0p6LW5qw5EK27UHCTfDZ",
				"http://localhost:8080/callback"); // Client ID, CallBack URL 삽입
		// 단 'localhost'가 포함된 CallBack URL
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("white", 4, 40);
		naver_id_login.setDomain("http://localhost:8080/login"); //  URL
		naver_id_login.setState(state);
		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>
	<a
		href="https://kauth.kakao.com/oauth/authorize?client_id=21af7be4191313b13cf6bdcfe9845dc0&redirect_uri=http://localhost:8080/kakaologin&response_type=code">
		<img src="/resources/kakao_login_medium_narrow.png">
	</a>
</html>
