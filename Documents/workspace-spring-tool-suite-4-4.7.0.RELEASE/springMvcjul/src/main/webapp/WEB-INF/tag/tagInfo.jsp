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

		var url = "tags.do";

		$.ajax({
			type : "post",
			url : url,
			dataType : "json"
		}).done(
				function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
					for (var i = 0; i < args.length; i++) {
						$("#tag").append(
								"<option value='"+args[i].tag_num+"'>"
										+ args[i].name + "</option>");
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	});//ready 끝

	function selectTag() {
		var tag_num = $("#tag").val();

		if (tag_num == 0) {
			$("#sub_tag option").each(function() {
				$("#sub_tag option:eq(1)").remove();
			});
			return;
		}

		var url = "sub_tags.do";
		var params = "tag_num=" + tag_num;

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

					$("#sub_tag")
							.append("<option value=''>::하위카테고리::</option>");

					for (var idx = 0; idx < args.length; idx++) {
						$("#sub_tag").append(
								"<option value='"+args[idx].num+"'>"
										+ args[idx].name + "</option>");
					}
				}).fail(function(e) {

			alert(e.responseText);
		});

	}
</script>

</head>
<body>

	<select id="tag" onchange="selectTag()">
		<option value="">::상위카테고리::</option>
	</select>

	<select id="sub_tag" onchange="selectSub_tag()">
		<option value="">::하위카테고리::</option>
	</select>

	<hr>
	<div id="tagInfo"></div>
</body>
</html>