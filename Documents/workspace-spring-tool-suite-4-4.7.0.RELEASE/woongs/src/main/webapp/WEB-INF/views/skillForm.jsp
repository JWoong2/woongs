<%@page import="com.woongjin.woongs.model.ProfileDto"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>보유기술</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	function skilltest() {
		if ($("#skill").val() == "" || $("#skill").val() == null) {
			alert("보유기술을 입력 주세요");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="skill" onsubmit="return skilltest()">
		보유기술<br> 
		<input type="text" id="skill" name="skill" value="${dto.skill}"><br>
		<input type="submit" value="저장후다음">

	</form>

</body>
</html>