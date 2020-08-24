<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function() {
		$
				.ajax({
					type : "post",
					url : "wishList",
					dataType : "json"
				})
				.done(
						function(args) {
							console.log(args.length);
							for (var i = 0; i < args.length; i++) {
								$("#wishList")
										.append(
												"<input type='checkbox'name='report' value='"+args[i].no+"'/><a class='asdf' href='cate?="
														+ args[i].no
														+ "'>��ǰ�̸� :"
														+ args[i].title
														+ "�Խù� ��ȣ : "
														+ args[i].post_no
														+ "�۾��� ID : "
														+ args[i].user_id
														+ "</a><br>");
							}
						}).fail(function(e) {
					alert(e.responseText);
				})
		console.log("ajax ��");
	});
</script>

<body>
	<form action="deleteCart">
		<input type="submit" value="����" />
		<div id="wishList"></div>
	</form>
</body>
</html>