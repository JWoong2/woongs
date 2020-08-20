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
<title>�Ǹ� ����</title>
</head>
<body>
	<%
		UserDto dto = (UserDto) session.getAttribute("userInfo");
	
		// ���� dto �� null�̶�� �ڵ� �α��� �������� �� ���̷�Ʈ
		if(dto == null) {
			response.sendRedirect("login");
		}
		System.out.println(dto.getImage());
	%>
	<img src="<%=dto.getImage()%>">
	<div id="user_nick_name"><%=dto.getNick_name()%></div>
	<a href="buyer">�Ƿ������� ��ȯ</a>
	<a href="seller">�Ǹ� ����</a>
	<a href="sentEstimate">���� ����</a>
	<a href="InquiriesManage">���ǳ��� ����</a>
	<a href="myService">���� ����</a>
	<a href="income">���Ͱ��� = ����</a>

	<a href="profile">������ ���</a>

	<a href="buyer">���� ����</a>
	<a href="buyer">��й�ȣ ���� = ����</a>
	<a href="buyer">ȸ�� Ż�� = ����</a>
	<a href="buyer">���� - ����</a>

	<% 
	List<EstimateDto> list = (List<EstimateDto>) request.getAttribute("estimateList");
	List<PostDto> postlist = (List<PostDto>) request.getAttribute("postList");
		
	if(postlist == null ) {
	%>
	�Խù��� �����ϴ�.
	<%}else { for(int i=0; i<postlist.size(); i++) {%>
	<img src="<%=postlist.get(i).getThumbnail() %>"> 
	<div><%=postlist.get(i).getTitle() %> </div>
	<div><%=postlist.get(i).getDescription() %> </div>
	<div><%=list.get(i).getBudget() %> </div>
	<%}} %>
</body>
</html>