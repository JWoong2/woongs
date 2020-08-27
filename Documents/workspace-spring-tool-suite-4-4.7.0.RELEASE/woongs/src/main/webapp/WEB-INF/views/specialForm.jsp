<%@page import="com.woongjin.woongs.model.ProfileDto"%>
<%@page import="com.woongjin.woongs.model.ProfileMainDto"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>전문분야</title>
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
                           "<option id = 'sub_tag' value= '"+args[idx].no+"'>"
                                 + args[idx].name + "</option>");

                  }
               }).fail(function(e) {
            alert(e.responseText);
         });
      }
      function checkItTest() {
         if ($("#tag").val() == "" || $("#tag").val() == 0
               || $("#sub_tag").val() == "") {
            alert("카테고리 선택해 주세요");
            return false;
         }
         return true;
      }
      function selectSub_tag() {
         var no = $("#sub_tag").val();
         var url = "/sub_tagOne";
         var params = "no=" + no;

         $.ajax({
            type : "post",
            url : url,
            data : params,
            dataType : "json"
         }).done(function(args) {

            var tagname = "상위 카테고리 : " + args.tagname + "<br>";
            var subname = "하위 카테고리 : " + args.subname + "<br>";

            $("#tagInfo").text("");//기존 내용 제거
            $("#tagInfo").html(tagname + subname);
         }).fail(function(e) {
            alert(e.responseText);
         });
      }
   </script>
   <span>전문분야 상세분야 선택</span>
   <form action="/specialtag" method="post"
      onsubmit="return checkItTest()">
      :: 상위카테고리 ::
      <select id="tag" name="tag" onchange="selectTag()">
      </select> <br> <select id="sub_tag" name="sub_tag"
         onchange="selectSub_tag()"></select> <input type="submit"
         value="저장후다음"> <br>
   </form>
   <div id="tagInfo"></div>
   <br>
   <br>
 <%--   
   전문가 소개<br>
   	<%
		ProfileMainDto dto = (ProfileMainDto) session.getAttribute("user_profile");
	if (dto.getIntroduce() == null) {
		
	} else {
	%>
   ${dto1.nick_name}<br>
   ${dto1.introduce}<br><br>
   <% } %>
   
   전문분야<br>
   <%
	if (dto.getSub_tagname() == null) {
	} else {
	%>
   ${dto1.tagname}<br>
   ${dto1.sub_tagname}<br><br>
    <% } %>
   보유기술<br>
   <%
	if (dto.getSkill() == null) {
	} else {
	%>
   ${dto1.skill}<br><br>
   <% } %>
   학력전공<br>
   <%
	if (dto.getUniv_name() == null) {	
	} 
	else {
	%>
   ${dto1.univ_name}
   ${dto1.univ_major}
   ${dto1.univ_status}<br><br>
   <% } %>
   보유자격증<br>
   <%
	if (dto.getIssu_agency() == null) {
	} 
	else {
	%>
   ${dto1.issu_agency} 
   ${dto1.issu_date}  
   ${dto1.certification_name}<br><br>
	<% } %> --%>
</body>
</html>