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
	
		// ���� dto �� null�̶�� �ڵ� �α��� �������� �� ���̷�Ʈ
		if(dto == null) {
			response.sendRedirect("login");
		}
	%>
<body>
<a href="seller">�Ǹ��ڷ� ��ȯ</a>
</body>
</html>