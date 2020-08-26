<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>
	
	<div style="display: flex; width: 100%; height: 100%; border: 1px solid black;">
		<!-- 최상단 태그 -->
		<div style="height: 500px; width: 20%; border: 1px solid black"></div>
		<div style="height: 500px; width: 80%; border: 1px solid black">
			<div>수익 관리</div>
			<div style="display: flex; border: 1px solid black; magin: 5px;">
				<div
					style="height: 100px; width: 30%; border: 1px solid black; magin: 5px;">
					<div style="height: 50px;">총 수익</div>
					<div style="height: 50px;" id="totalIncome"></div>
				</div>
				<div
					style="height: 100px; width: 30%; border: 1px solid black; magin: 5px;">
					<div style="height: 50px;">확정 수익</div>
					<div style="height: 50px;" id="finshYIncome"></div>
				</div>

				<div
					style="height: 100px; width: 30%; border: 1px solid black; magin: 5px;">
					<div style="height: 50px;">확정 안된 수익</div>
					<div style="height: 50px;" id="finshNIncome"></div>
				</div>
			</div>
			<canvas id="chart_div" width="150" height="150"></canvas>
			
			<div>입금 계좌 등록</div>
			<div style="display: flex; border: 1px solid black; magin: 5px;" >
			<div style="height: 50px; width : 30%;">
				<select id="accountSelect">
				
				</select>
			</div>
			<div style="height: 50px; width : 30%;" >
				<input type="text" id="accountInput"/>
			</div>
			<div style="height: 50px; width : 30%;">
				<button id ="accountButton">선택</button>
			</div>

			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script>
		$(function() {
			income.init();
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

		var income = {
			init : function() {
				income.find_income_by_user_id();
				
				income.find_account_info_by_user_id();
				$("#accountButton").on("click", function(){
						
					alert("계좌 "+$("#accountSelect").val()+"가 선택되었습니다.")
				});
				$("#accountSelect").on("change", function(){
					$("#accountInput").val($("#accountSelect").val());
					
				});
			},
			find_income_by_user_id : function() {

				$.ajax({
					type : "GET",
					url : "findIncomeByUserId",
					dataType : 'json'
				}).done(function(datas) { 
					var sumPrice = 0;
					var finshYIncome = 0;
					var finshNIncome = 0;

					var indexDate = [0,0,0,0,0,0,0,0,0,0,0,0];
					datas.forEach(function(item, index, data) {
						if (item.FINSH_YN == "Y") {
							finshYIncome += item.PRICE;
						} else {
							finshNIncome += item.PRICE;
						}
						sumPrice += item.PRICE;

						var PAID_DATE = new Date(item.PAID_DATE);
						var month = PAID_DATE.toISOString().replace("T", " ").substring(5, 7)
						month *=1;

						indexDate[month-1] += item.PRICE;
					});

					
					for(var i =0 ; i<indexDate.size; i++){
						charDate[i][1] = indexDate[i];
					}

					
					console.log(indexDate);
					$("#totalIncome").html(sumPrice + "원");
					$("#finshYIncome").html(finshYIncome + "원");
					$("#finshNIncome").html(finshNIncome + "원");

					var ctx = document.getElementById('chart_div').getContext('2d');
					var chart_div = new Chart(ctx, {
					    type: 'bar',
					    data: {
					        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
					        datasets: [{
					            label: '# Total Income',
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
			find_account_info_by_user_id : function() {
				
				$.ajax({
					type : "GET",
					url : "findAccountInfoByUserId",
					dataType : 'json'
				}).done(function(datas) {
					var selectHtml = "<option value=''>::선택::</option>";
					datas.forEach(function(item, index, data) {
						selectHtml += "<option value="+"'"+item.account_number+"'"+">"
						selectHtml += item.bank_name
						selectHtml += "</option>"
							console.log(datas);
					});

					$("#accountSelect").append(selectHtml);
				}).fail(function(e) {
					alert(e.responseText);
				})
			}

		}

		
	</script>

</body>
</html>