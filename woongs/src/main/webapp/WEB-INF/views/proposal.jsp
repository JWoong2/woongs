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
		<div>post 작성자 : ${post.user_id }</div>
		<input type="hidden" name="user_id" value="${post.user_id }">
		<div>예산 : ${post.price }</div>

		<div id="fileDiv">
			<p>
				<input type="file" name="file"> <a href="#this"
					class="btn" id="delete" name="delete">삭제</a>
			</p>
		</div>
		<a href="#this" class="btn" id="addFile">파일 추가</a>
		<input type="submit" value="보내기"> 
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
		var gfv_count = 1;
	
		$(document).ready(function(){
			$("#addFile").on("click", function(e){ //파일 추가 버튼
				e.preventDefault();
				fn_addFile();
			});
			
			$("a[name='delete']").on("click", function(e){ //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
		});
		
		function fn_addFile(){
			console.log(gfv_count);
			gfv_count++;
			if(gfv_count == 4) {
				alert("파일은 3개까지만 첨부 가능합니다");
				gfv_count--;
				return ;
			}
			var str = "<p><input type='file' name='file'><a href='#this' class='btn' name='delete'>삭제</a></p>";
			$("#fileDiv").append(str);
			$("a[name='delete']").on("click", function(e){ //삭제 버튼
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