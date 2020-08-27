<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구매 리스트</title>
</head>
<body>

구매 완료
<hr>
구매 내역
<c:forEach items="${buyList}" var="list">
    <img alt="" src="${list.thumbnail }"> 
	<div>${list.title }</div>
	<div>${list.description }</div>
	<div>${list.price }</div>
	<div>${list.user_id }</div>
	<div>${list.buy_date }</div>
</c:forEach>
<hr>
</body>
</html>