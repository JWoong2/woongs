<%@page import="com.woongjin.woongs.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
		UserDto dto = (UserDto) session.getAttribute("userInfo");
	
		// 만약 dto 가 null이라면 자동 로그인 페이지로 리 다이렉트
		if(dto == null) {
			response.sendRedirect("login");
		}
	%>
<body>
<a href="seller">판매자로 전환</a>
</body>
</html>