<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div.logintool{
	    margin:auto;
   		width: 100%; 
   		height: 100vh; 
   		display: -webkit-box; 
   		display: -ms-flexbox; 
   		display: flex; 
   		-webkit-box-align: center; 
   		-ms-flex-align: center; 
   		align-items: center; 
   		-webkit-box-pack: center; 
   		-ms-flex-pack: center; 
   		justify-content: center;


	}
</style>
</head>
<body>

	<h2>�α���</h2>
	<div class="logintool" >
		<h2>�α���</h2>
	<form action="login" method="post">
		<label for="email">���̵�</label> <input type="text" id="email"
			name="email"> <label for="password">��й�ȣ</label> <input
			type="password" id="password" name="password"> <input
			type="submit" value="Ȯ��">
	</form>
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
	<div id="naver_id_login"></div>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("0p6LW5qw5EK27UHCTfDZ",
				"http://localhost:8080/callback"); // Client ID, CallBack URL ����
		// �� 'localhost'�� ���Ե� CallBack URL
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
	</div>
	</body>
</html>
