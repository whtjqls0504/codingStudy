<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.beans.*"%>
<%@ page import="java.util.*"%>

<%
List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

<h1>오랜만게시판</h1>
<hr><br>

<table border="1">
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>내용</th>
		<th>등록일</th>
	</tr>
	<%
		if(list != null){
		  for(BoardDTO dto : list){
	%>
	
	<!-- 목록 불러오기  -->
	<tr>
		<td><%=dto.getNum()%></td>
		<td><a href="view.do?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a></td>
		<td><%=dto.getContent()%></td>
		<td><%=dto.getUploadDate()%></td>
	</tr>
	<%
 
			}
		}
	%>
</table>

<br><hr>
<button onclick="location.href='write.do'">신규등록</button>


</body>
</html>