<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>네이버로그인</title>
</head>

<body>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("0p6LW5qw5EK27UHCTfDZ",
				"http://localhost/callback"); // Client ID, CallBack URL 삽입

		// 접근 토큰 값 출력
		alert(naver_id_login.oauthParams.access_token);

		// 네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");

		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			alert(naver_id_login.getProfileData('email'));
			alert(naver_id_login.getProfileData('nickname'));
			alert(naver_id_login.getProfileData('age'));

			window.opener.document.location.href = "main";
			window.close();
		}
	</script>
</body>
</html>