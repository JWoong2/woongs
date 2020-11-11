<%@page import="com.woongjin.woongs.model.ProposalDto"%>
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
받은 견적 파일들 출력
<% List<ProposalDto> list = (List<ProposalDto> ) request.getAttribute("proposalDto"); 
	for(int i=0; i<list.size(); i++) {
%>
	<a href="/displayFile?idx=<%= list.get(i).getIdx()%>"><%= list.get(i).getOriginal_file_name() %></a>
<% 
	}
%>
</body>
</html>