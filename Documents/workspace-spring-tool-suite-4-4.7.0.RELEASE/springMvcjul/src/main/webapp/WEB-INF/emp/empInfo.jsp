<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>사원 정보</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script>
	$(function() {

		var url = "depts.do";

		$.ajax({
			type : "post",
			url : url,
			dataType : "json"
		}).done(
				function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
					for (var i = 0; i < args.length; i++) {
						$("#dept").append(
								"<option value='"+args[i].deptno+"'>"
										+ args[i].dname + "</option>");
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	});//ready 끝

	function selectDept() {
		var deptno = $("#dept").val();

		if (deptno == "") {
			$("#emp option").each(function() {
				$("#emp option:eq(1)").remove();
			});
			return;
		}

		var url = "emps.do";
		var params = "deptno=" + deptno;

		$.ajax({
			type : "post",
			url : url,
			data : params,
			dataType : "json"
		}).done(
				function(args) {
					$("#emp option").each(function() {
						$("#emp option:eq(0)").remove();
					});

					$("#emp").append("<option value=''>::사원선택::</option>");

					for (var idx = 0; idx < args.length; idx++) {
						$("#emp").append(
								"<option value='"+args[idx].empno+"'>"
										+ args[idx].ename + "</option>");
					}
				}).fail(function(e) {

			alert(e.responseText);
		});

	}
		function selecEmp() {
		var empno = $("#emp").val();

		var url = "empOne.do";
		var params = "empno=" + empno;

		$.ajax({
			type : "post",
			url : url,
			data : params,
			dataType : "json"
		}).done(
				function(args) {

					var empno = "사원번호 : " + args.empno + "<br>";
					var ename = "사원 이름 : " + args.ename + "<br>";
					var job = "직급 : " + args.job + "<br>";
					var mgr = "상사 번호 : " + args.mgr + "<br>";
					var hiredate = "입사일 : " + args.hiredate + "<br>";
					var sal = "급여 : " + args.sal + "<br>";
					var comm = "커미션 : " + args.comm + "<br>";
					var deptno = "부서 번호 : " + args.deptno + "<br>";

					$("#empInfo").text("");//기존 내용 제거
					$("#empInfo").html(
							empno + ename + job + mgr + hiredate + sal + comm
									+ deptno);
				}).fail(function(e) {
			alert(e.responseText);
		});
	}  
</script>

</head>
<body>

	<select id="dept" onchange="selectDept()">
		<option value="">::부서선택::</option>
	</select>

	<select id="emp" onchange="selecEmp()">
		<option value="">::사원선택::</option>
	</select>

	<hr>
	<div id="empInfo"></div>
</body>
</html>