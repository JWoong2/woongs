<%@page import="com.woongjin.woongs.model.ProfileMainDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>

<script type="text/javascript">
	function introduction() {
		location.href = "introduction";
	}
</script>
<body>
	<a href="main">����</a><br><br>
	<%
	ProfileMainDto dto = (ProfileMainDto) session.getAttribute("user_profile");
	if (dto == null) {
	} else {
	%>

	������ �Ұ�<br>  
	${dto.introduce}<br><br>
	���� �о� <br>
	${dto.tagname}<br>
	${dto.sub_tagname}<br><br>
	�������<br>
	${dto.skill}<br><br>
	�ڰ���<br>
	${dto.issu_agency}
	${dto.certification_name}
	${dto.issu_date}<br><br>
	�з� ����<br>
	${dto.univ_name}
	${dto.univ_major}
	${dto.univ_status}<br><br>
	
<%	} %>

	<div onclick="introduction()"
		style="background-color: gray; color: white; text-align: center; margin: 0 auto; padding: 30px 20px;">
		������ ���/�����ϱ�</div>

</body>
</html>