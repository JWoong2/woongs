<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>


<c:forEach var="list" items="${list}">
<form action="delete" method="post">
<a href="smartEditorPost?no=${list.no}">
<input type="hidden" name="no" value="${list.no}">

<img src="${list.thumbnail}"  width='90' height='90'>   <br>
번호 : ${list.no}    &nbsp;
제목 : ${list.title}  <br>
카테고리  : ${list.name} &gt; ${list.sub_name}<br>
간단설명 : ${list.description} <br>
금액  : ${list.budget}
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="삭제">
<br>
</a> <br>
</form>
</c:forEach>


</body>
</html>