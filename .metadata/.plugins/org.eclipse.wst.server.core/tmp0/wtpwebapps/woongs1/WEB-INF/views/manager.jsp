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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>
				<div
					style="height: 100px; width: 30%; border: 1px solid black; magin: 5px;">
					<div style="height: 50px;">수익</div>
					<div style="height: 50px;" id="ManagerIncome"></div>
				</div>
				
				<div
					style="height: 100px; width: 30%; border: 1px solid black; magin: 5px;">
					<div style="height: 50px;">수익</div>
					<div style="height: 50px;" id="ManagerIncome1"></div>
				</div>
				
				<canvas id="chart_div" width="150" height="150"></canvas>

	<% List<T_Paid_HistoryDto> monthSumProductNo = (List<T_Paid_HistoryDto>) session.getAttribute("monthSumProductNo");
		List<String> tagList = (List<String>) session.getAttribute("tagList");
	
	%>

	<table border="1">
		<tr>
		<td>월</td>
		<c:forEach var="tag_name" items="${tagList}">
			<td>${ tag_name}</td>
		</c:forEach>
		</tr>
		<% 
		String temp="";
		int trSize = 0;
		for(int i=0; i<monthSumProductNo.size(); i++) {
			// 월 다를 때 
			if(!temp.equals(monthSumProductNo.get(i).getMonth())){
				%>
				<tr>
					<td><%= monthSumProductNo.get(i).getMonth() %>월</td>
					<% for(int idx=1; idx<monthSumProductNo.get(i).getProduct_no(); idx++) {
						%>
						<td>0원</td>
						<% 
							
					}
					trSize = monthSumProductNo.get(i).getProduct_no();
					%> 
					<td><%= monthSumProductNo.get(i).getPrice() %>원</td>
					<% 
						%>
 				<% 
 				if(i != 0 ) {
 				 %>
 				 </tr>
 				 <% 
 				}
 				
 			}else {
 				for(int idx=trSize+1; idx<monthSumProductNo.get(i).getProduct_no(); idx++) {
 				%> 
 					<td>0원</td>
 				<% 	
 				}
 				trSize = monthSumProductNo.get(i).getProduct_no();
 				%>
 					<td><%= monthSumProductNo.get(i).getPrice() %>원</td>
 				<% 
 			}
			temp=monthSumProductNo.get(i).getMonth();
			
			}
		%>
	</table>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

	<canvas id="chart_div" width="400" height="400"></canvas>
	
<script>
	$(function() {
		manager.init();
	});

	var charDate = [[1, 0]
	,[2, 0]
	,[3, 0]
	,[4, 0]	
	,[5, 0]
	,[6, 0]
	,[7, 0]
	,[8, 0]
	,[9, 0]
	,[10, 0]
	,[11, 0]
	,[12, 0]];

	var manager = {
		init : function(){
				manager.income_by_user_id();
			}
		},

	income_by_user_id : function(){

		$.ajax({
			type : "GET",
			url : "manager",
			dataType : "json"
		}).done(function(datas){
			var sumPrice = 0;
			var ManagerIncome = 0;
			var ManagerIncome1 = 0;


			var indexDate = [0,0,0,0,0,0,0,0,0,0,0,0];
			datas.forEach(function(item, index, data) {
				if (item.PRODUCT_NO == "1") {
					ManagerIncome += item.PRICE;
				} else {
					ManagerIncome1 += item.PRICE;
				}
				sumPrice += item.PRICE;

				var PAID_DATE = new Date(item.PAID_DATE);
				var month = PAID_DATE.toISOString().replace("T", " ").substring(5, 7)
				month *=1;

				indexDate[month-1] += item.PRICE;
			});
			var ctx = document.getElementById('chart_div').getContext('2d');
			var chart_div = new Chart(ctx, {
			    type: 'bar',
			    data: {
			        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			        datasets: [{
			            label: '# Manager Income',
			            data: indexDate,
			            backgroundColor:
			                'rgba(255, 99, 132, 0.2)',
			              
			         
			            borderColor: 
			                'rgba(255, 99, 132, 1)',
			              
			            
			            borderWidth: 1
			        }]
			    },
			    options: {
			        scales: {
			            yAxes: [{
			                ticks: {
			                    beginAtZero: true
			                }
			            }]
			        }
			    }
			});
					
		}).fail(function(e) {
			alert(e.responseText);
		})
	},





			
			})
		}

	
</script>
</body>
</html>