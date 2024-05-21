<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>

	<h2>게시글 등록</h2>
	<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
	제목 <input type="text" name="title" />
	내용 <br>
	<textarea name="content"></textarea>
	
	<input type="submit" value="등록하기" />
	</form>
	<br>
	<button type="button" onclick="location.href='list.do'">목록으로</button>

	<script>
		function chkSubmit() {
			frm = document.forms['frm'];
			let title = frm[title].value.trim();
			if(title == ''){
				alert("제목은 반드시 입력해야합니다.");
				frm['title'].focus();
				return false;
			}
			return true;
		}
	
	
	</script>


</body>
</html>