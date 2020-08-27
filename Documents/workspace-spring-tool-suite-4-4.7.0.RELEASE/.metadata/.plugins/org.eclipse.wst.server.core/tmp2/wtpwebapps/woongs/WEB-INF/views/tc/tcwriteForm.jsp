<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>

  
<body > 
<center><b>이용약관작성</b>
<br>
<form method="post" name="tcwriteform" action="tcmain" onsubmit="return writeSave()">
<input type="hidden" name="no" value="${dto.no}">

<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">
   <tr>
    <td align="right" colspan="2" >
    <a href="tcmain"> 글목록</a>
   </td>
   </tr>
   <tr>
    <td  width="70"   align="center">이 름</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" name="writer"></td>
  </tr>
  <tr>
    <td  width="70"   align="center" >제 목</td>
    <td  width="330">
       <input type="text" size="40" maxlength="50" name="subject"></td>
 </tr>
<%-- <c:if test="${dto.no != 0}">
   <input type="text" size="40" maxlength="50" name="subject" value="[답변]">
</c:if> --%>

 
  <tr>
    <td  width="70"   align="center" >내 용</td>
    <td  width="330" >
     <textarea name="content" rows="13" cols="40"></textarea> </td>
  </tr>
  
<!--     <tr>
    <td  width="70"   align="center" >등록날짜</td>
    <td  width="330">
       <input type="date" size="40" maxlength="50" name="reg_date"></td>
 </tr> -->
<!--   <tr>
    <td  width="70"   align="center" >비밀번호</td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd">
</td>
  </tr> -->
<tr>     
<td colspan=2  align="center">
  <input type="submit" value="글쓰기" > 
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='tcmain'">
</td></tr></table>   
</form>     
</body>
</html> 