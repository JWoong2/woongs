<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나의 서비스 입력</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<body>

<% 
	// 최근 PostDto가 있다면 update
	// 없다면 insert 문으로 만들거
	if(session.getAttribute("recent_post") == null) { 
%>
<script>
	$(function(){
		var url="tag";
		$.ajax({
			type:"post"
			,url:url		
			,dataType:"json" })
			.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
			 	for(var i=0; i < args.length; i++) {
				 	$("#tag").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");
			 	}
 				})
	    	.fail(function(e) {
		    	alert(e.responseText);
	    })
});//ready 끝

function selectTag(){
	var tagno=$("#tag").val();
	
	if(tagno=="") {	                
		$("#subtag option").each(function() {	
			$("#subtag option:eq(1)").remove();	
		});
		return;
	}
	
	var url="subtag";
	var params="tagno="+tagno;
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
			$("#subtag option").each(function() {	
				$("#subtag option:eq(0)").remove();
			});

			 for(var idx=0; idx<args.length; idx++) {	
				 $("#subtag").append("<option value='"+args[idx].no+"'>"+args[idx].name+"</option>");	
			 } 
		})
	    .fail(function(e) {
	    	alert(e.responseText);
	    });	
}
</script>

<a href="createService">기본정보</a>
<a href="createService">가격설정</a>
<a href="createService">서비스 설명</a>
<a href="createService">이미지</a>
<a href="createService">요청사항</a>
	<span>유저 아이디 el태그 테스트 : ${user_id } </span>
	<form class="info" action="insertPost" method="post" enctype="multipart/form-data">
	<select id="tag" name="category_first" onchange="selectTag()">
  		<option value="">::상위카테고리::</option>
	</select>
	<select id="subtag" name="category_second">
  		<option value="">::하위카테고리::</option>
	</select>
	
	제목 : <input type="text" name="title">
	설명 : <input type="text" name="description">
	금액 : <input type="number" name="price">
	작업기간 : <input type="number" name="worktime"> 일 수 미입력시 기본 14일
	수정횟수 : <input type="number" name="retouch_count">
	<input type="hidden" name="status" value="1">
	<input type="submit" value="저장">
	</form>

	<form class="priceSetting" action="insertPost" method="post" enctype="multipart/form-data">
	서비스 설명 : <input type="text" name="service_description">
	<input type="hidden" name="status" value="2">
	<input type="submit" value="저장">
	</form>
	
	<form class="Image" action="insertPost" method="post" enctype="multipart/form-data">
	이미지 : <input type="file" name="report" method="post" >
	<input type="hidden" name="status" value="3">
		<input type="submit" value="저장">
	</form>
	
	<form class="requirement" action="insertPost" method="post" enctype="multipart/form-data">
	요청사항 : <input type="text" name="requirement">
	<input type="hidden" name="status" value="4">
	<input type="submit" value="저장">
	</form>
	
	<%}else { %> 
	<% PostDto dto = (PostDto) session.getAttribute("recent_post");  %>
<script>

$(function(){
		var url="tag";
		$.ajax({
			type:"post"
			,url:url		
			,dataType:"json" })
			.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
			 	for(var i=0; i < args.length; i++) {
				 	if(<%= dto.getCategory_first() %> == args[i].no) {
				 		$("#tag").append("<option value='"+args[i].no+"' selected>"+args[i].name+"</option>");
					 	} else {
					 		$("#tag").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");	 	
						 	}
			 	}
 				})
	    	.fail(function(e) {
		    	alert(e.responseText);
	    })
	    

		tagno = <%= dto.getCategory_first() %>;
		console.log(tagno);
				
		if(tagno=="") {	                
			$("#subtag option").each(function() {	
				$("#subtag option:eq(1)").remove();	
			});
			return;
		}
		
		var url="subtag";
		var params="tagno="+tagno;
		
		$.ajax({
			type:"post"
			,url:url	
			,data:params
			,dataType:"json"})
			.done(function(args){
				$("#subtag option").each(function() {	
					$("#subtag option:eq(0)").remove();
				});

				 for(var idx=0; idx<args.length; idx++) {
					 if( <%= dto.getCategory_second()%> == args[idx].no ){
						 $("#subtag").append("<option value='"+args[idx].no+"' selected>"+args[idx].name+"</option>");
						 } else {
							 $("#subtag").append("<option value='"+args[idx].no+"'>"+args[idx].name+"</option>");
							 }	
				 } 
			})
		    .fail(function(e) {
		    	alert(e.responseText);
		    });	
});//ready 끝

function selectTag(){
	console.log(tagno);
	tagno=$("#tag").val();
	console.log(tagno);
	
	if(tagno=="") {	                
		$("#subtag option").each(function() {	
			$("#subtag option:eq(1)").remove();	
		});
		return;
	}
	
	var url="subtag";
	var params="tagno="+tagno;
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
			$("#subtag option").each(function() {	
				$("#subtag option:eq(0)").remove();
			});

			 for(var idx=0; idx<args.length; idx++) {
				 if( <%= dto.getCategory_second()%> == args[idx].no ){
					 $("#subtag").append("<option value='"+args[idx].no+"' selected>"+args[idx].name+"</option>");
					 } else {
						 $("#subtag").append("<option value='"+args[idx].no+"'>"+args[idx].name+"</option>");
						 }	
			 } 
		})
	    .fail(function(e) {
	    	alert(e.responseText);
	    });	
}
</script>
<!--  클릭 시 status 에 맞는 form 클래스로 가고싶은데 진수한테 물어봐야지 -->
<a href="updateService">기본정보</a>
<a href="updateService">가격설정</a>
<a href="updateService">서비스 설명</a>
<a href="updateService">이미지</a>
<a href="updateService">요청사항</a>
	<span>유저 아이디 el태그 테스트 : ${user_id } </span>
	<span>게시물 status: <%= dto.getStatus() %> </span>
	<!--  form 태그 시작 부분 -->
	<form class="info" action="updatePost" method="post" enctype="multipart/form-data">
	<select id="tag" name="category_first" onchange="selectTag()">
  		<option value="">::상위카테고리::</option>
	</select>
	<select id="subtag" name="category_second">
  		<option value="">::하위카테고리::</option>
	</select>
	
	제목 : <input type="text" name="title" value="<%=dto.getTitle() %>">
	설명 : <input type="text" name="description" value="<%= dto.getDescription()%>">
	금액 : <input type="number" name="price" value="<%= dto.getPrice()%>">
	작업기간 : <input type="number" name="worktime" value="<%= dto.getWorktime() %>"> 일 수 미입력시 기본 14일
	수정횟수 : <input type="number" name="retouch_count" value="<%= dto.getRetouch_count() %>">
	<input type="hidden" name="status" value="1">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="저장">
	</form>

	<!-- 잠시 임시로 넣어둠 데이터 null 뜨면 에러나서 페이지 안뜨니까 -->
	<!-- 안보이도록 대체 될것 -->
	<% if(dto.getStatus() > 0) { %>
	<form class="priceSetting" action="updatePost" method="post" enctype="multipart/form-data">
	서비스 설명 : <input type="text" name="service_description" value="<%= dto.getService_description() %>" >
	<input type="hidden" name="status" value="2">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="저장">
	</form>
	<% } %>
	
	<% if(dto.getStatus() > 1) { %>
	<form class="Image" action="updatePost" method="post" enctype="multipart/form-data">
	<% if(dto.getThumbnail() == null) {
	
		%> 
	이미지 : <input type="file" name="report">		
		<% 
		
	}else {	%>
	<img src="<%= dto.getThumbnail() %>">
	<input type="file" name="report">
	<%} %>
	<input type="hidden" name="status" value="3">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="저장">
	</form>
	<% } %>
	
	<% if(dto.getStatus() > 2) { %>
	<form class="requirement" action="updatePost" method="post" enctype="multipart/form-data">
	요청사항 : <input type="text" name="requirement" value="<%= dto.getRequirement()%>">
	<input type="hidden" name="status" value="4">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="저장">
	</form>
	<% } %>
	<%} %>
</body>
</html>