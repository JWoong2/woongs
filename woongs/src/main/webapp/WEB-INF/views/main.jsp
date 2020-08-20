<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<style>
.post {
	width: 300px;
	height: auto;
	position: relative;
	display: inline-block;
	margin-right: 20px;
}

.post img {
	width: 100%;
}

.wish {
	position: absolute;
	top: 25px;
	right: 5px;
	width: 20px;
}
</style>
</head>
<body>
	<%
		String user_id = (String) session.getAttribute("user_id");
	if (user_id != null) {
	%>
	"${user_id}" 님 환영합니다
	<a href="logout" class="logout">로그아웃</a>
	<%} else {%>
	<a href="register">회원가입</a>
	<a href="login"> 로그인 </a>
	<%
		}
	%>
	<a href="find">비밀번호 찾기</a>
	<a href="upload"> 업로드 페이지</a>
	<a href="myPage"> 마이 페이지</a>
	<a href="wishList"> 찜한목록</a>
	<br>
	<a href="coupon"> 쿠폰 발행 페이지 (관리자)</a> 사용자 아이디로 로그인했다면 쿠폰확인 페이지로 링크
	<br>
	<a href="coupon"> 쿠폰 확인/등록 페이지 (사용자)</a>

	<img src="resources/Images/test.jpg">

	<script>
		$(function() {
			$.ajax({
				type : "post",
				url : "tag",
				dataType : "json"
			}).done(
					function(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수
						for (var i = 0; i < args.length; i++) {
							$("#tag").append(
									"<a href='cate?=" + args[i].no + "'>"
											+ args[i].name + "</option>");
							$("#cate").after(
									"<div id='"+args[i].no+"'>" + args[i].name
											+ "</div>");
						}
					}).fail(function(e) {
				alert(e.responseText);
			})
			console.log("ajax 끝");
			afterAjax();
			$(".wish").click(function() {
				console.log("Dd");
			});

		});//ready 끝

		function afterAjax() {
			console.log("함수 호출");
			$.ajax({
						type : "post",
						url : "post",
						dataType : "json"
					})
					.done(
							function(args) {
								for (var i = 0; i < args.length; i++) {
									console.log(args[i].category_first);
									$("#" + args[i].category_first)
											.after(
													"<div class='post' id='"+args[i].no+"'><a href='cart?post_no="
															+ args[i].no
															+ "'>찜하기</a><img src="+args[i].thumbnail+">"
															+ args[i].title
															+ args[i].user_id
															+ args[i].price
															+ args[i].eval
															+ "<a href='#none' id='heart"
															+ args[i].no
															+ "' class='wish off' onclick='changeHeart($(this).attr("
															+ '"'
															+ 'id'
															+ '"'
															+ "),$(this).attr("
															+ '"'
															+ 'class'
															+ '"'
															+ "));'><img src='/resources/Images/emptyheart.png'></a></div>");

								}
							});
		}


		function changeCheck(url, id) {
			var test = <%=session.getAttribute("user_id") == null%>;
			if (test) {
				window.location.href = 'login';
			} else {
				var params = "post_no=" + id * 1;
				$.ajax({
					type : "post",
					url : url,
					dataType : "text",
					data : params
				}).done(function(args) {
					console.log(args);
				}).fail(function(e) {
					alert(e.responseText);
				})
			}
		}

		function changeHeart(id, className) {
			if (className == "wish off") {
				console.log("")
				$("#" + id).attr("class", "wish on");
				$("#" + id).children('img').attr('src',
						'/resources/Images/heart.png');
				changeCheck("check", id.replace("heart", "") * 1);
			} else {
				$("#" + id).attr("class", "wish off");
				$("#" + id).children('img').attr('src',
						'/resources/Images/emptyheart.png');
				changeCheck("check_cancel", id.replace("heart", "") * 1);
			}
		}
	</script>
	<h2>카테고리 모음</h2>
	<div id="tag"></div>
	<div id="cate"></div>
</body>
</html>