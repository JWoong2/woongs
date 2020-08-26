<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div style="height: 50px; width: 30%;">
		<button id="buyButton">선택</button>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script>
$(function() {
	purchase.init();
});

var purchase = {
	init : function() {
		purchase.purchase_management_client_id();

		$("#buyButton").on("click", function(){
					
		});
		$("#accountSelect").on("change", function(){
			$("#accountInput").val($("#accountSelect").val());
			
		});
	},
</script>
</body>
</html>