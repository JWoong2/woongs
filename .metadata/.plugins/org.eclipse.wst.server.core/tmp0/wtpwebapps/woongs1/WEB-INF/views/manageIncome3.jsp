<%@page import="java.util.List"%>
<%@page import="com.woongjin.woongs.model.BalanceDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.woongjin.woongs.model.T_Paid_HistoryDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<c:set var="total" value="0" />

	<c:forEach var="T_Paid_HistoryDto" items="${findIncomeById}"
		varStatus="status">

		<c:if test="${T_Paid_HistoryDto.FINSH_YN=='N'}">
			<h2>���� ���� ������Ʈ ���� : ${T_Paid_HistoryDto.price} ��</h2>
			<c:set var="total" value="${total + T_Paid_HistoryDto.price}" />
		</c:if>
	</c:forEach>

	<h2>
		�� ���� ���� �ݾ� :
		<c:out value="${total} ��" />
	</h2>

	<c:forEach var="BalanceDto" items="${findMoneyById}">
		<h2>���� �����ִ� �ݾ� : ${BalanceDto.user_balance} ��</h2>
	</c:forEach>


</body>
</html>