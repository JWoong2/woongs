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
<h2>나의 서비스</h2>
<% 
	List<PostDto> list = (List<PostDto>) request.getAttribute("postList");
	
	if(list == null) {
		%>
		게시물이 없습니다.
		<a href="createService">등록하기</a>		
		<%
	}else {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getStatus() != 0) { 
		%>	
		<div><a href="updateService?no=<%=list.get(i).getNo()%>">미완</a></div>
		<%}else {  %>
		<div><a href="updateService?no=<%=list.get(i).getNo()%>">수정</a></div>
		<%} %>
		
		<% if(list.get(i).getThumbnail() == null) {
		 %>이미지 없음<%
		}else {
		 %>
		<img src="<%=list.get(i).getThumbnail() %>">
		<%} %>
		<div><%=list.get(i).getTitle() %></div>
		<div><%=list.get(i).getDescription() %></div>
		<div><%=list.get(i).getPrice() %></div>
		
		<% }
		%>
		<a href="createService">추가하기</a>
		<% 
	}
%>
</body>
</html>