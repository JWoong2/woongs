<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>게시판</title>
<style type='text/css'>
<!--
a:link { color:black; text-decoration:none; }
a:visited {  }
a:active { text-decoration:underline; }
a:hover { text-decoration:underline; background-image:url('text_dottdeline.gif'); background-repeat:repeat-x; background-position:50% 100%; }
-->
</style>
<style>
<!--
@font-face {font-family:굴림; src:url();}
body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}
-->
</style>
</head>

<body> 
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center"> 
  <tr height="30">
    <td align="center" width="125" >글번호</td>
    <td align="center" width="125" align="center">${article.no}</td>

  </tr>
  <tr height="30">
    <td align="center" width="125" >작성자</td>
    <td align="center" width="125" align="center">${article.writer}</td>
    <td align="center" width="125"  >작성일</td>
    <td align="center" width="125" align="center">${article.reg_date}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" >이용약관제목</td>
    <td align="center" width="375" align="center" colspan="3">${article.subject}</td>
  </tr>
  <tr>
    <td align="center" width="125" >이용약관내용</td>
    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  </tr>
  <tr height="30">     
    <td colspan="4"  align="right" >
  <input type="button" value="이용약관 수정"
       onclick="document.location.href='tcupdateForm?no=${article.no}&p=${pageNum}'">
   &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="이용약관 삭제"
       onclick="document.location.href='tcdeleteForm?no=${article.no}&p=${pageNum}'">
   &nbsp;&nbsp;&nbsp;&nbsp;

       <input type="button" value="이용약관 목록"
       onclick="document.location.href='tcmain?p=${pageNum}'">
    </td>
  </tr>
</table>   
</form>     
</body>
</html>    