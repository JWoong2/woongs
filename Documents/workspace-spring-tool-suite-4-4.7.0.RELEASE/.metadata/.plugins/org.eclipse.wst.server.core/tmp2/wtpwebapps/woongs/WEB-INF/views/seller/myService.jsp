<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>���� ����</h2>
<% 
	List<PostDto> list = (List<PostDto>) request.getAttribute("postList");
	
	if(list == null) {
		%>
		�Խù��� �����ϴ�.
		<a href="createService">����ϱ�</a>		
		<%
	}else {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getStatus() != 0) { 
		%>	
		<div><a href="updateService?no=<%=list.get(i).getNo()%>">�̿�</a></div>
		<%}else {  %>
		<div><a href="updateService?no=<%=list.get(i).getNo()%>">����</a></div>
		<%} %>
		
		<% if(list.get(i).getThumbnail() == null) {
		 %>�̹��� ����<%
		}else {
		 %>
		<img src="<%=list.get(i).getThumbnail() %>">
		<%} %>
		<div><%=list.get(i).getTitle() %></div>
		<div><%=list.get(i).getDescription() %></div>
		<div><%=list.get(i).getPrice() %></div>
		
		<% }
		%>
		<a href="createService">�߰��ϱ�</a>
		<% 
	}
%>
</body>
</html>