
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

	<form action="/career" method="post">
		회사명 - <input type="text" name="company_name" /> 
		근무부서 -<input type="text" name="dept_name" /> 
		직위 - <input type="text"name="position" /> 
			<select id="year" name="year">
			<option value="">::년::</option>
			<option value="0">0년</option>
			<option value="1">1년</option>
			<option value="2">2년</option>
			<option value="3">3년</option>
			<option value="4">4년</option>
			<option value="5">5년</option>
			<option value="6">6년</option>
			<option value="7">7년</option>
			<option value="8">8년</option>
			<option value="9">9년</option>
			<option value="10">10년</option>
			<option value="11">11년</option>
			<option value="12">12년</option>
			<option value="13">13년</option>
			<option value="14">14년</option>
			<option value="15">15년</option>
			<option value="16">16년</option>
			<option value="17">17년</option>
			<option value="18">18년</option>
			<option value="19">19년</option>
			<option value="20">20년</option>
			<option value="21">21년</option>
			<option value="22">22년</option>
			<option value="23">23년</option>
			<option value="24">24년</option>
			<option value="25">25년</option>
			<option value="26">26년</option>
			<option value="27">27년</option>
			<option value="28">28년</option>
			<option value="29">29년</option>
			<option value="30">30년</option>
		</select> 
		<select id="month" name="month">
			<option value="">::월::</option>
			<option value="0">0개월</option>
			<option value="1">1개월</option>
			<option value="2">2개월</option>
			<option value="3">3개월</option>
			<option value="4">4개월</option>
			<option value="5">5개월</option>
			<option value="6">6개월</option>
			<option value="7">7개월</option>
			<option value="8">8개월</option>
			<option value="9">9개월</option>
			<option value="10">10개월</option>
			<option value="11">11개월</option>
			<option value="12">12개월</option>
		</select> <input type="submit" value="저장후다음">
	</form>

</body>
</html>
