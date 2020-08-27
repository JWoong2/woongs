
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function checkItTest() {
        if ($("#company_name").val() == "" ) {
           alert("회사명을 입력 주세요");
           return false;
        }else if($("#dept_name").val() == ""){
        	alert("근무부서를 입력 주세요");
        	return false;
            }else if($("#position").val() == ""){
            	alert("직위를 입력 주세요");
            	return false;
            }else if($("#year").val() == ""){
            	alert("경력(년)을 입력 주세요");
            	return false;
            }
            else if($("#month").val() == ""){
            	alert("경력(개월)을 입력 주세요");
            	return false;
            }
        
        return true;
     }
</script>
</head>
<body>

	<form action="/career" method="post" onsubmit="return checkItTest()">
		회사명 - <input type="text" id="company_name" name="company_name" value="${dto.company_name }"/> 
		근무부서 -<input type="text" id="dept_name" name="dept_name" value="${dto.dept_name }" /> 
		직위 - <input type="text" id="position" name="position" value="${dto.position }" /> 
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
