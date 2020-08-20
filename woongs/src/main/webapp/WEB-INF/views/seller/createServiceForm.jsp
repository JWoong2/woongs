<%@page import="com.woongjin.woongs.model.PostDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� �Է�</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<body>

<% 
	// �ֱ� PostDto�� �ִٸ� update
	// ���ٸ� insert ������ �����
	if(session.getAttribute("recent_post") == null) { 
%>
<script>
	$(function(){
		var url="tag";
		$.ajax({
			type:"post"
			,url:url		
			,dataType:"json" })
			.done(function(args){	//������ ���� ���� �ڵ带 ��ȯ�ϸ� ȣ��Ǵ� �Լ�
			 	for(var i=0; i < args.length; i++) {
				 	$("#tag").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");
			 	}
 				})
	    	.fail(function(e) {
		    	alert(e.responseText);
	    })
});//ready ��

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

<a href="createService">�⺻����</a>
<a href="createService">���ݼ���</a>
<a href="createService">���� ����</a>
<a href="createService">�̹���</a>
<a href="createService">��û����</a>
	<span>���� ���̵� el�±� �׽�Ʈ : ${user_id } </span>
	<form class="info" action="insertPost" method="post" enctype="multipart/form-data">
	<select id="tag" name="category_first" onchange="selectTag()">
  		<option value="">::����ī�װ�::</option>
	</select>
	<select id="subtag" name="category_second">
  		<option value="">::����ī�װ�::</option>
	</select>
	
	���� : <input type="text" name="title">
	���� : <input type="text" name="description">
	�ݾ� : <input type="number" name="price">
	�۾��Ⱓ : <input type="number" name="worktime"> �� �� ���Է½� �⺻ 14��
	����Ƚ�� : <input type="number" name="retouch_count">
	<input type="hidden" name="status" value="1">
	<input type="submit" value="����">
	</form>

	<form class="priceSetting" action="insertPost" method="post" enctype="multipart/form-data">
	���� ���� : <input type="text" name="service_description">
	<input type="hidden" name="status" value="2">
	<input type="submit" value="����">
	</form>
	
	<form class="Image" action="insertPost" method="post" enctype="multipart/form-data">
	�̹��� : <input type="file" name="report" method="post" >
	<input type="hidden" name="status" value="3">
		<input type="submit" value="����">
	</form>
	
	<form class="requirement" action="insertPost" method="post" enctype="multipart/form-data">
	��û���� : <input type="text" name="requirement">
	<input type="hidden" name="status" value="4">
	<input type="submit" value="����">
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
			.done(function(args){	//������ ���� ���� �ڵ带 ��ȯ�ϸ� ȣ��Ǵ� �Լ�
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
});//ready ��

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
<!--  Ŭ�� �� status �� �´� form Ŭ������ ��������� �������� ��������� -->
<a href="updateService">�⺻����</a>
<a href="updateService">���ݼ���</a>
<a href="updateService">���� ����</a>
<a href="updateService">�̹���</a>
<a href="updateService">��û����</a>
	<span>���� ���̵� el�±� �׽�Ʈ : ${user_id } </span>
	<span>�Խù� status: <%= dto.getStatus() %> </span>
	<!--  form �±� ���� �κ� -->
	<form class="info" action="updatePost" method="post" enctype="multipart/form-data">
	<select id="tag" name="category_first" onchange="selectTag()">
  		<option value="">::����ī�װ�::</option>
	</select>
	<select id="subtag" name="category_second">
  		<option value="">::����ī�װ�::</option>
	</select>
	
	���� : <input type="text" name="title" value="<%=dto.getTitle() %>">
	���� : <input type="text" name="description" value="<%= dto.getDescription()%>">
	�ݾ� : <input type="number" name="price" value="<%= dto.getPrice()%>">
	�۾��Ⱓ : <input type="number" name="worktime" value="<%= dto.getWorktime() %>"> �� �� ���Է½� �⺻ 14��
	����Ƚ�� : <input type="number" name="retouch_count" value="<%= dto.getRetouch_count() %>">
	<input type="hidden" name="status" value="1">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="����">
	</form>

	<!-- ��� �ӽ÷� �־�� ������ null �߸� �������� ������ �ȶߴϱ� -->
	<!-- �Ⱥ��̵��� ��ü �ɰ� -->
	<% if(dto.getStatus() > 0) { %>
	<form class="priceSetting" action="updatePost" method="post" enctype="multipart/form-data">
	���� ���� : <input type="text" name="service_description" value="<%= dto.getService_description() %>" >
	<input type="hidden" name="status" value="2">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="����">
	</form>
	<% } %>
	
	<% if(dto.getStatus() > 1) { %>
	<form class="Image" action="updatePost" method="post" enctype="multipart/form-data">
	<% if(dto.getThumbnail() == null) {
	
		%> 
	�̹��� : <input type="file" name="report">		
		<% 
		
	}else {	%>
	<img src="<%= dto.getThumbnail() %>">
	<input type="file" name="report">
	<%} %>
	<input type="hidden" name="status" value="3">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="����">
	</form>
	<% } %>
	
	<% if(dto.getStatus() > 2) { %>
	<form class="requirement" action="updatePost" method="post" enctype="multipart/form-data">
	��û���� : <input type="text" name="requirement" value="<%= dto.getRequirement()%>">
	<input type="hidden" name="status" value="4">
	<input type="hidden" name="no" value="<%=dto.getNo() %>">
	<input type="submit" value="����">
	</form>
	<% } %>
	<%} %>
</body>
</html>