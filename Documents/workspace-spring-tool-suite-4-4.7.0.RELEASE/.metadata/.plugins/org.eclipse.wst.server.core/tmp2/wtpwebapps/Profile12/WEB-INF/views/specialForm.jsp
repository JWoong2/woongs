<%@page import="spring.model.ProfileDto"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>게시물</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<body>
	<script>
		$(function() {

			var url = "tags";
			$.ajax({
				type : "post",
				url : url,
				dataType : "json"
			}).done(
					function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
						for (var i = 0; i < args.length; i++) {
							$("#tag").append(
									"<option value='"+args[i].no+"'>"
											+ args[i].name + "</option>");
						}
					}).fail(function(e) {
				alert(e.responseText);
			})
		});//ready 끝
		//상위 카테고리 선택
		function selectTag() {
			var no = $("#tag").val();

			if (no == 0) {
				$("#sub_tag option").each(function() {
					$("#sub_tag option:eq(1)").remove();
				});
				return;
			}
			//하위 카테고리 선택
			var url = "sub_tags";
			var params = "tag_no=" + no;

			$.ajax({
				type : "post",
				url : url,
				data : params,
				dataType : "json"
			}).done(
					function(args) {
						$("#sub_tag option").each(function() {
							$("#sub_tag option:eq(0)").remove();
						});

						$("#sub_tag").append(
								"<option value=''>::하위카테고리::</option>");

						for (var idx = 0; idx < args.length; idx++) {
							$("#sub_tag").append(
									"<option id = 'sub_tag' value='"+args[idx].no+"'>"
											+ args[idx].name + "</option>");
						}
					}).fail(function(e) {
				alert(e.responseText);
			});
		}
	</script>
	<span>전문분야 상세분야 선택</span>
	<form action="/specialtag" method="post">
		<select id="tag" onchange="selectTag()" name="tag">
			<option value="">::상위카테고리::</option>
		</select> <br> <select id="sub_tag" name="sub_tag">
		</select> <input type="submit" value="저장후다음">
	</form>

</body>
</html>