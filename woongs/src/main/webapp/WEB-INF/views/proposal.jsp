<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="proposal" method="post" enctype="multipart/form-data">
		<div>post no : ${post.no }</div>
		<input type="hidden" name="post_no" value="${post.no }">
		<div>post �ۼ��� : ${post.user_id }</div>
		<input type="hidden" name="user_id" value="${post.user_id }">
		<div>���� : ${post.price }</div>

		<div id="fileDiv">
			<p>
				<input type="file" name="file"> <a href="#this"
					class="btn" id="delete" name="delete">����</a>
			</p>
		</div>
		<a href="#this" class="btn" id="addFile">���� �߰�</a>
		<input type="submit" value="������"> 
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
		var gfv_count = 1;
	
		$(document).ready(function(){
			$("#addFile").on("click", function(e){ //���� �߰� ��ư
				e.preventDefault();
				fn_addFile();
			});
			
			$("a[name='delete']").on("click", function(e){ //���� ��ư
				e.preventDefault();
				fn_deleteFile($(this));
			});
		});
		
		function fn_addFile(){
			console.log(gfv_count);
			gfv_count++;
			if(gfv_count == 4) {
				alert("������ 3�������� ÷�� �����մϴ�");
				gfv_count--;
				return ;
			}
			var str = "<p><input type='file' name='file'><a href='#this' class='btn' name='delete'>����</a></p>";
			$("#fileDiv").append(str);
			$("a[name='delete']").on("click", function(e){ //���� ��ư
				e.preventDefault();
				fn_deleteFile($(this));
			});
		}
		
		function fn_deleteFile(obj){
			gfv_count--;
			console.log(gfv_count);
			obj.parent().remove();
		}
	</script>
</html>