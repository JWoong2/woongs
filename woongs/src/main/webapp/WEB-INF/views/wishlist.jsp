<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>찜한 목록</title>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	$(function() {
		$.ajax({
				type : "post",
				url : "wishList",
				dataType : "json"
				})
				.done(
					function(args) {
						console.log(args.length);
						for (var i = 0; i < args.length; i++) {
							$("#wishList")
									.append(
											"<input type='checkbox'name='report' value='"+args[i].no+"'/><a class='asdf' href='cate?="
													+ args[i].no
													+ "'>상품이름 :"
													+ args[i].title
													+ "작업자 : "
													+ args[i].user_id
													+ "가격 :" 
													+ args[i].price
													+"</a><br>");
						/* 		$("#wishList").append("<td><input type='checkbox' name='report' value='" + args[i].no+ '" /> <a class="asdf" href="cate?="'
										+ args[i].no + '">상품이름 :"'+ args[i].title + "작업자 : " + args[i].user_id	+ "가격 :" 
										+ args[i].price +"</a><br></td>"); */
							}
						}).fail(function(e) {
					alert(e.responseText);
				})
		console.log("ajax 끝");
	});
</script>

<body>
	<form action="deleteCart">
		<input type="submit" value="삭제" />
		<div id="wishList"></div>
	</form>
	
	<div>
		<div class='ty-mainbox-cart__body'>
			<div id="cart_items">
				<table class="ty-cart-content">
					<thead>
						<tr>
							<th class="cart-content">&nbsp;</th>
							<th class="cart-content">상품</th>
							<th class="cart-content">작업자</th>
							<th class="cart-content">가격</th>
							<th class="cart-content">총 금액</th>
						</tr>	
					</thead>
				</table>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>