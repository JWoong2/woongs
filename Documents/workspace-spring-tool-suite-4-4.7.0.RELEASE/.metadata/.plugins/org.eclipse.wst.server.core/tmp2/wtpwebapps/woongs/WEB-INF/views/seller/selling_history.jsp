<%@page import="com.woongjin.woongs.model.EstimateDto"%>
<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@page import="java.util.List"%>
<%@page import="com.woongjin.woongs.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>판매 관리</title>
</head>
<body>
	<%
		UserDto dto = (UserDto) session.getAttribute("userInfo");
	
		// 만약 dto 가 null이라면 자동 로그인 페이지로 리 다이렉트
		if(dto == null) {
			response.sendRedirect("login");
		}
		System.out.println(dto.getImage());
	%>
	<img src="<%=dto.getImage()%>">
	<div id="user_nick_name"><%=dto.getNick_name()%></div>
	<a href="buyer">의뢰인으로 전환</a>
	<a href="seller">판매 관리</a>
	<a href="sentEstimate">보낸 견적</a>
	<a href="InquiriesManage">문의내용 관리</a>
	<a href="myService">나의 서비스</a>
	<a href="income">수익관리 = 동성</a>

	<a href="profile">프로필 등록</a>

	<a href="buyer">계정 관리</a>
	<a href="buyer">비밀번호 변경 = 진수</a>
	<a href="buyer">회원 탈퇴 = 진수</a>
	<a href="buyer">찜목록 - 태희</a>

	<% 
	List<EstimateDto> list = (List<EstimateDto>) request.getAttribute("estimateList");
	List<PostDto> postlist = (List<PostDto>) request.getAttribute("postList");
		
	if(postlist == null ) {
	%>
	게시물이 없습니다.
	<%}else { for(int i=0; i<postlist.size(); i++) {%>
	<img src="<%=postlist.get(i).getThumbnail() %>"> 
	<div><%=postlist.get(i).getTitle() %> </div>
	<div><%=postlist.get(i).getDescription() %> </div>
	<div><%=list.get(i).getBudget() %> </div>
	<%}} %>
</body>
</html>