<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function checkItTest() {
    if ($("#issu_agency").val() == "" ) {
       alert("자격증명을 입력 주세요");
       return false;
    }else if($("#issu_date").val() == ""){
    	alert("발급일를 입력 주세요");
    	return false;
        }else if($("#certification_name").val() == ""){
        	alert("발급기관 입력 주세요");
        	return false;
        }
    return true;
}
</script>
<body>

	<form action="/certi" method="post" onsubmit="return checkItTest()">
		자격증명 - <input type="text" id="issu_agency" name="issu_agency" value="${dto.issu_agency }"/> 
		발급일 - 	<input type="date" id="issu_date" name="issu_date"  value="${dto.issu_date }" />
		발급기관 - <input type="text" id="certification_name" name="certification_name" value="${dto.certification_name }" />
				<input type="submit" value="저장후다음"> 		
 	</form>
 	
 	
 	
</body>
</html>