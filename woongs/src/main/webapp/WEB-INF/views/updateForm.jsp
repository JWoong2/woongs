
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<body>
	<script>
		/* 	$(function() {

			$.ajax({
				type : "post",
				url : url,
				data: "univ_status="+ "휴학", "univ_status="+ "재학", "univ_status="+ "졸업", "univ_status="+ "이수",
			}).done(
					function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
					+ "</option>");
						}
					}).fail(function(e) {
				alert(e.responseText);
			})
		}); */

		//ready 끝
		//상위 카테고리 선택
		function UnivselectTag() {
			alert("test");
			/* var univ_status = $("#profile").val();

			if (univ_status == 0) {
				$("#univ_status option").each(function() {
					$("#univ_status option:eq(1)").remove();

				} else (univ_status == 1)
				});

				return; */
		}
	</script>
	<!-- onchange="UnivselectTag()" -->


	<form action="/univtags" method="post">
		학교명 - <input type="text" name="univ_name" id="univ_name"/> 
		전공 - <input type="text" name="univ_major" id="univ_major"/>
		<select id="univ_status" name="univ_status">
			<option value="상태">::상태</option>
			<option value="0">휴학</option>
			<option value="1">재학</option>
			<option value="2">졸업</option>
			<option value="3">이수</option>
		</select> <input type="submit" value="저장후다음">
	</form>
</body>
</html>
