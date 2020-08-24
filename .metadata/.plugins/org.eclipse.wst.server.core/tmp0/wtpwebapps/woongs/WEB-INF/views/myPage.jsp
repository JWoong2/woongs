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
<a href="">전문가회원으로 전환</a>

<div>마이페이지</div>
<a>견적 요청</a>
<a>구매 관리</a>
<a>나의 서비스</a>
<a>수익 관리</a>
<a>프로필 등록</a>
<a>계정 관리</a>
<a>찜 목록 관리</a>

</body>
</html>