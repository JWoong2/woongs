<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$('#test').submit(function(){
		var code = $("#code").val();
		if(code == '${code}'){
			alert('인증됨 ㅋ')
		}else{
			alert('틀림 ㅋ')
			return false;
		}
	})
})
</script>
<body>

	${code} 
<!-- 	<p>이메일을 확인해주세요</p>
	<label for="code">code : </label> 
	<input type="text" id="code" value="2">
	<input type="button" id="check" value="인증">  -->
	
	
	<form action="code" method="post" id="test">
		<label for="code">인증번호 입력</label>
		<input type="text" id="code" name="code">
		<input type="submit" value="인증" id="check">
	</form>
</body>
</html>