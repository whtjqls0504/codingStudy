<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	int cnt = (Integer)request.getAttribute("result");
%>
<% if (cnt == 0) { %>
	<script>
		alert("삭제 실패");
		history.back();
	</script>
<% } else { %>
<script>
	alert("삭제 성공");
	location.href="list.do";
</script>
<% } %>