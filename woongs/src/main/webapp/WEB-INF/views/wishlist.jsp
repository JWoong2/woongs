<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
 <style>
 body{
      margin:20px auto;
      padding :0;
      font-family:"���";
      font-size:0.9em;   
   }
   
   ul#navi{
      width:100px;
      text-indent:10px;
   }
   
   ul#navi, ul#navi ul{
      margin:0;
      padding:0;
      list-style:none;
   }
   
   li.group{
      maring-buttom:3px;
   }
   
   li.group div.title{
      height:35px;
      line-height:35px;
      background:#9ab92e;
      cursor:pointer;
   }  
		
header {
	width:1200px;
	height: 100px;
	margin: 0 auto ;
}
nav{
	width:674px;
	height: 70px;
	margin-top:10px;
	border: solid 1px green;
}

#main{
	width:799px;
	margin-left:10px ;
	border: solid 1px green; 
}
#content{
	width: 674px;
	height: 500px;
	float: left;
	margin-top : 9px;
	margin-left : 10px;
	border: solid 1px green; 
	}
 aside{
	width:100px;
	height: 300px;
	float:left;
	margin-left:10px;
	margin-top:10px;
	border: solid 1px green;
}	 
footer{
	clear:both;
	width: 786px;
	height: 100px;
	margin-left:10px;
	margin-top:20px;
	border: solid 1px green;
} 
div#CartButton{
	text-align: center;
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
												"<input type='checkbox' name='report' value='"+args[i].no+"'/><a class='asdf' href='cate?="
														+ "'> " //<-�̺κ��� �𸣰���
														+"<img src="+ args[i].thumbnail +">"
														+ args[i].no
														+ args[i].title
														+ "�Խù� ��ȣ : "
														+ args[i].post_no
														+ "�۾��� ID : "
														+ args[i].user_id
														+ "</a><br>");
								
							}
						}).fail(function(e) {
					alert(e.responseText);
				})
		console.log("ajax ����");

		$.ajax({
			type : "post",
			url : "wishList",
			dataType : "json"
		})
		.done(
				function(args) {
					console.log(args.length);
					for (var i = 0; i < args.length; i++) {
						$("#table").append(
								/* <th>üũ </th>
								<th>�̹���</th>
								<th>���� </th>
								<th>�ۼ���</th>
								<th>����</th>
								<th>����</th> */
								
								"<tr><td><input type='checkbox' name='report' value='"+args[i].no+"'/> </td>"
												+"<td><img src="+ args[i].thumbnail +"></td>" 
												+"<td>"+ args[i].title +"</td>"
												+"<td>"+ args[i].user_id +"</td>"
												+"<td>"+ args[i].description +"</td>"
												+"<td>"+ args[i].price +"</td>"
												+"</tr>"
												);
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	console.log("test");
	});


</script>

<body>

	<header>
	<br>
		<h2><b>���� ���</b></h2>
	</header>
	<aside>
	<ul id="navi">
      <li class="group">
         <div class="title"><a href="category?no=1">IT�����α׷���</a></div>
      </li>    
      <li class="group">
         <div class="title"><a href="category?no=2">������ ����</a></div>
      </li>      
      <li class="group">
         <div class="title"><a href="category?no=3">���� ���� ����</a></div>         
      </li>           
      <li class="group">
         <div class="title"><a href="category?no=4">���� �ǹ� ����</a></div>
      </li>      
     
   </ul>
	</aside>
	<section id="main">
		<section id="table">
				<table id="table">
								<th>üũ </th>
								<th>�̹���</th>
								<th>���� </th>
								<th>�ۼ���</th>
								<th>����</th>
								<th>����</th>
				</table>
				
			
		</section>
		
	</section>
	<div id="CartButton">
	<form>
	<input type="submit" value="����" onclick="javascript: form.action='deleteCart';"/>
    <input type="submit" value="�����ϱ�" onclick="javascript: form.action='buy';"/>
	</form>
 	<form action="buy">
	</form>  
	</div>
	<footer>���� ����Ʈ ����</footer>


</body>

</html>