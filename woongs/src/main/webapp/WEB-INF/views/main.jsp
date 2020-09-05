<%@page import="com.woongjin.woongs.model.UserDto"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link href="resources/css/base.css" rel="stylesheet" type="text/css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<style>
.post {
	width: 300px;
	height: auto;
	position: relative;
	display: inline-block;
	margin-right: 20px;
	padding-left : 100px;
}
.user_image {
   width : 20px;
   display: inline-block;
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
 table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  div.mypage  {
  	width: 240px;
	height: 350px;
	margin-bottom : 20px;
	
}
div.secs{
	width: 900px;
	height: auto;
	margin-left :20px;
}
div.cate{
	gravity:center;
	float:left;
.login{
   position: absolute;
    top: 10px;
    right: 50px;
    height:50px;
    border-bottom:1px solid #dedede;
}
.login > img {
   width : 2%;
}
.login > a{
   margin-right:20px;
}
.login > a:last-child{
   margin-right:0;
}	
	
	
}

  
</style>
<body>
<%  System.out.println("main.jsp : " + session.getAttribute("admin"));  %>
<c:if test="${admin}" var="admin" scope="session">
	어드민이당
</c:if>
			
 	 <c:if test="${user_id == admin }"> 
		<a href="../index">관리자</a>
</c:if>

<% UserDto dto = (UserDto) session.getAttribute("userInfo"); 

	if(dto == null) {
		%>
<div class="login">
<a href="register">회원가입</a>
<a href="login">로그인</a>
<a href="find">비밀번호 찾기</a>
</div>		
		<% 
	}else {
		%>
	<div class="login">
유저 아이디 : <%= dto.getEmail() %>
유저 이름 : <%= dto.getUser_name() %>
가입 날짜 : <%= dto.getReg_Date() %>
<div class="user_image">
<img alt="" src="<%= dto.getImage()%>"> 
</div>	
<a href="logout"> 로그아웃 </a>
<a href="signout"> 회원탈퇴</a>

		<% 
	}
%>
</div>
<div class="mypage">
<a href="upload"> 업로드 페이지</a>
<a href="buyer"> 마이 페이지</a>
<a href="wishList"> 찜한목록</a>
<a href="buylist"> 구매페이지</a>
<a href="coupon"> 쿠폰 발행 페이지 (관리자)</a>
<a href="coupon"> 쿠폰 확인/등록 페이지 (사용자)</a>
<a href="chatRoom">채팅목록</a>
</div>
<script>
$(function(){
	$.ajax({
		type:"post"
		,url:"tag"		
		,dataType:"json" })
		.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
		 	for(var i=0; i < args.length; i++) {
			 	$("#tag").append("<a href='category?no="+args[i].no+"'>"+args[i].name+"</option>");
			 	$("#cate").append("<div class='secs' id='"+args[i].no+"'><p>"+args[i].name+"</p></div>");
		 	}
				})
    	.fail(function(e) {
	    	alert(e.responseText);
    })

    console.log("ajax 끝");
	afterAjax();
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
													+ args[i].title + " "
													+ args[i].user_id + " "
													+ args[i].price+ " "
													/* + args[i].eval+ " " */
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
													+ "));'><img src='/resources/Images/emptyheart.png'></a><a href='/chatAsk?user_id="+args[i].user_id+"&&no="+args[i].no+"'>문의하기</a></div>");

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

<div class="main_bg">
	<p class="tit">
		이상한 페이지 입니다 
	</p>
	<div class="image"></div>
</div>
<div id="tag"></div>
<div class="project_list">
<div id="cate"></div>
</div>
</body>
</html>