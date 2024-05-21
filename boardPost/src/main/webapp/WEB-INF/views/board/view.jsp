<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.beans.*" %>
<%@ page import="java.util.*" %>
<%
	List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
	if (list == null || list.size() == 0) {
%>
<script>
	alert("해당 정보가 삭제되었거나 존재하지 않습니다.");
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
<title>Insert title here</title>
</head>
<body>
	<h1><%=title%> 정보</h1>
	<hr>
	<strong>제목</strong><%=title%><br>
	<strong>내용</strong><%=content%><br>
	<strong>등록일</strong><%=uploadDate%><br>
	<br><hr><br>
	<button type="button" onclick="chkDelete(<%=num%>)">삭제하기</button>
	<button type="button" onclick="location.href='list.do'">목록으로</button>
	<button type="button" onclick="location.href='update.do?num=<%=num%>'">수정하기</button>
	<button type="button" onclick="location.href='write.do'">신규등록</button>
	
	<script type="text/javascript">
		function chkDelete() {
			let r = confirm("삭제하시겠습니까?");
			if(r) {
				location.href="deleteOk.do?num=" + num;
			}
		}
	</script>
	<script>
		function chkDelete(num) {
			let r = confirm("삭제하시겠습니까?");
			if(r) {
				location.href="deleteOk.do?num=" + num;
			}
		}
	</script>
</body>
</html>