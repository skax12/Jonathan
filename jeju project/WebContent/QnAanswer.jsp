<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답	글</h1>
<form action="controller.do">
	<input type = "hidden" name = "command" value="answerWrite">
	<input type = "hidden" name = "num" value="${dto.num }">
	<table border = "1">
		<tr>
			<th>작 성 자</th>
			<td><input type = "text" name = "name"></td>
		</tr>
		
		<tr>
			<th>제	목</th>
			<td><input type = "text" name = "title" value = "└답글:${dto.title }"></td>
		</tr>
		
		<tr>
			<th>내	용</th>
			<td><textarea rows="10" cols="60" name = "content"></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="작성">
				<input type="button" value="취소" onclick="location.href='controller.do?command=list'">
			</td>
		</tr>

	</table>
</form>


</body>
</html>