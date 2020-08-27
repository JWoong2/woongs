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
<div> 찜하기</div>
<div> 구매하기</div>
<div><a href="/chatAsk?user_id=<%= dto.getUser_id() %>&&no=<%=dto.getNo() %>">문의하기</a></div>
<div><a href="/proposal?post_no=<%=dto.getNo()%>">견적주기</a></div>
<div><a href="/estimate?post_no=<%=dto.getNo()%>">받은 견적 파일 보기</a></div>


</body>
</html>