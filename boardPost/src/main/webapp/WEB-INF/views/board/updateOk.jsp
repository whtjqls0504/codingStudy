<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>'
<%@ page import="com.beans.*" %>
<%
	int cnt = (Integer)request.getAttribute("result");
	int num = Integer.parseInt(request.getParameter("num"));
%>
<%  if (cnt == 0) { %>
	<script>
		alert("수정 실패");
		history.back();
	</script>
<% } else { %>
<script>
	alert("수정 성공");
	location.href="view.do?num=<%=num %>";
</script>
<% } %>
