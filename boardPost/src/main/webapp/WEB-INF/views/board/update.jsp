<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.beans.*" %>
<%@ page import="java.util.*" %>
<%
	List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
	if (list == null || list.size() == 0) {
%>
<script>
	alert("해당정보가 삭제되었거나 존재하지 않습니다.");
	history.back();
</script>
<%
	return;
	}
%>
<%
	BoardDTO dto = list.get(0);
	int num = dto.getNum();
	String title = dto.getTitle();
	String content = dto.getContent();
	String uploadDate = dto.getUploadDateTime();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %> 수정</title>
</head>
<body>
	<h1><%=title %> 수정</h1>
	<hr>
	<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit">
		<input type="hidden" name="num" value="<%=num %>" />
		<strong>제목</strong>
		<input type="text" name="title" value="<%=title %>" /><br>
		<strong>내용</strong>
		<input type="text" name="content" value="<%=content %>" /><br>
		<br><br>
		<input type="submit" value="수정하기" />
	</form>
	
	<br><br><br>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='list.do'">목록으로</button>
	
	<script>
		function chkSubmit() {
			frm = document.forms['frm'];
			
			let title = frm['title'].value.trim();
			let content = frm['content'].value.trim();
			
			
			// if문, 만약에 타이틀/내용이 비어있으면 작동 못하게.
			if(title == ''){
				alert("제목은 반드시 입력해야합니다.")
				frm['title'].focus();
				return false;
			} else if (content = ''){
				alert("내용은 반드시 입력해야합니다.");
				frm['content'].focus();
				return false;
			}
			
			
			return true;
		}
	
	</script>
</body>
</html>