<%@page import="java.util.List"%>
<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% List<PostDto> dto = (List<PostDto>) request.getAttribute("post");
%>
<script>
$(function(){
	$.ajax({
		type:"post"
		,url:"tag"		
		,dataType:"json" })
		.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
		 	for(var i=0; i < args.length; i++) {
			 	$("#tag").append("<a href='category?no="+args[i].no+"'>"+args[i].name+"</a>");
			 	$("#cate").after("<div id='"+args[i].no+"'>"+args[i].name+"</div>");
		 	}
				})
    	.fail(function(e) {
	    	alert(e.responseText);
    })

    subTagView();
});//ready 끝

function subTagView() {
	var tagno=<%= dto.get(0).getCategory_first() %>;
	
	var url="subtag";
	var params="tagno="+tagno;
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"})
		.done(function(args){
			 for(var idx=0; idx<args.length; idx++) {	
				 $("#sub_tag").append("<a href='subcategory?no="+args[i].no+"&&tagno="+ args[i].tag_no+"'>"+args[idx].name+"</a>");	
			 } 
		})
	    .fail(function(e) {
	    	alert(e.responseText);
	    });		
}

</script>
<body>

<div id="tag"></div>
<div id="cate"></div>
<div id="sub_tag"></div>
	<% for(int i= 0; i<dto.size(); i++) { %>
    <div class="post"><a href="post?no=<%=dto.get(i).getNo()%>"><%=dto.get(i).getTitle() %></a></div>
	<%} %>

</body>
</html>