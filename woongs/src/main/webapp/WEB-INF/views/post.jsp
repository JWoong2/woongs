<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% PostDto dto = (PostDto) request.getAttribute("post");%>
<div>
<img src="<%=dto.getThumbnail()%>">
<p><%=dto.getTitle() %></p>
<p><%=dto.getPrice() %></p>
<p><%=dto.getService_description() %></p>
</div>
<div> ���ϱ�</div>
<div> �����ϱ�</div>
<div> �����ϱ�</div>

</body>
</html>