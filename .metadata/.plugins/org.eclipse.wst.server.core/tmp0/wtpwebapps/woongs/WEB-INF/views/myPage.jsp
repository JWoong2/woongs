<%@page import="com.woongjin.woongs.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% UserDto dto = (UserDto) session.getAttribute("userInfo"); %>


<img src="<%= dto.getImage() %>">
<div><%= dto.getNick_name() %></div>
<a href="">������ȸ������ ��ȯ</a>

<div>����������</div>
<a>���� ��û</a>
<a>���� ����</a>
<a>���� ����</a>
<a>���� ����</a>
<a>������ ���</a>
<a>���� ����</a>
<a>�� ��� ����</a>

</body>
</html>