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
			alert('������ ��')
		}else{
			alert('Ʋ�� ��')
			return false;
		}
	})
})
</script>
<body>

	${code} 
<!-- 	<p>�̸����� Ȯ�����ּ���</p>
	<label for="code">code : </label> 
	<input type="text" id="code" value="2">
	<input type="button" id="check" value="����">  -->
	
	
	<form action="code" method="post" id="test">
		<label for="code">������ȣ �Է�</label>
		<input type="text" id="code" name="code">
		<input type="submit" value="����" id="check">
	</form>
</body>
</html>