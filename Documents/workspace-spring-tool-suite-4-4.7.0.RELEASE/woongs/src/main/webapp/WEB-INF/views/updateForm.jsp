<%@page import="com.woongjin.woongs.model.ProfileMainDto"%>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<body>
	<script>
		function checkItTest() {
			if ($("#univ_name").val() == "") {
				alert("학교명을 입력 주세요");
				return false;
			} else if ($("#univ_major").val() == "") {
				alert("전공을 입력 주세요");
				return false;
			} else if ($("#univ_status").val() == "") {
				alert("상태를 입력 주세요");
				return false;
			}
			return true;
		}
	</script>

	<% ProfileMainDto dto = (ProfileMainDto) request.getAttribute("dto");
	%>
	<form action="/univtags" method="post" onsubmit="return checkItTest()">
		학교명 - <input type="text" name="univ_name" id="univ_name" value="${dto.univ_name }" /> 
		전공 - <input	type="text" name="univ_major" id="univ_major" value="${dto.univ_major }"/> 
		<select	id="univ_status" name="univ_status">
			<option value="">::상태</option>
			<% if(dto.getUniv_status().equals("휴학") ) { %>
			<option value="휴학" selected>휴학</option>
			<%}else { %>
			<option value="휴학">휴학</option>
			<%} %>
			<% if(dto.getUniv_status().equals("재학") ) { %>
			<option value="재학" selected>재학</option>
			<%}else { %>
			<option value="재학">재학</option>
			<%} %>
			<% if(dto.getUniv_status().equals("졸업") ) { %>
			<option value="졸업" selected>졸업</option>
			<%}else { %>
			<option value="졸업">졸업</option>
			<%} %>
			<% if(dto.getUniv_status().equals("이수") ) { %>
						<option value="이수" selected>이수</option>
			<%}else { %>
						<option value="이수">이수</option>
			<%} %>
		</select> <input type="submit" value="저장후다음">
	</form>
</body>
</html>
