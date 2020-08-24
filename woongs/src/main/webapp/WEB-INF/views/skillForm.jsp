<%@page import="com.woongjin.woongs.model.ProfileDto"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>보유기술</title>
</head>
<body>
	<form action="skill">
		검색 <input type="text" id="skill" name="skill"><br> 
		<input type="submit" value="저장후다음">
	</form>

</body>
</html>