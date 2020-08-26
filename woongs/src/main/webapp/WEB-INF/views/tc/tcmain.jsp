<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>이용약관</title>
</head>

<body>
<center>
<b>이용약관목록 (전체 이용약관:${list.count})</b>
<table width="700">
  <tr>
    <td align="right" >
       <a href="tcwriteForm">이용약관추가</a>
    </td>
  </tr>
</table>

<c:if test="${list.count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 이용약관이 존재하지 않습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${list.count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" >
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >약관명</td>
      <td align="center"  width="150" >작성일</td>
    </tr>

   <c:forEach var="article" items="${list.boardList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
     <td  width="250" >
  <%--  <c:if test="${article.re_level > 0}">
  <img src="resources/images/level.gif" width="${5 * article.re_level}" height="16">
    <img src="resources/images/re.gif">
  </c:if>
  <c:if test="${article.re_level == 0}">
    <img src="resources/images/level.gif" width="${5 * article.re_level}" height="16">
  </c:if>   --%>
          
       <a href="tccontent?no=${article.no}&p=${list.requestPage}">
          ${article.subject}</a>
<%--         <c:if test="${article.readcount >= 20}">
            <img src="resources/images/hot.gif" border="0"  height="16">
  </c:if>  --%>
</td>
    <td align="center"  width="100">
       ${article.writer}
</td>
    <td align="center"  width="150">
    <fmt:formatDate value="${article.reg_date}" type="date"
    											 dateStyle="long"/> 

  </c:forEach>
</table>
</c:if>

<c:if test="${list.count > 0}">
  <c:if test="${list.p.beginPageNumber > 10}">
			<a href="list?p=${list.p.beginPageNumber-1}">이전</a>
		</c:if>
		<c:forEach var="pno" begin="${list.p.beginPageNumber}" end="${list.p.endPageNumber}">
		<a href="tcmain?p=${pno}">[${pno}]</a>
		</c:forEach>
		<c:if test="${list.p.endPageNumber < list.p.totalPageCount}">
			<a href="tcmain?p=${list.p.endPageNumber + 1}">다음</a>
		</c:if>
</c:if>
</center>
</body>
</html>