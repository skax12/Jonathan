<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content ="width=device-width", initial-scale="1">
<link rel = "stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src = "js/bootstrap.js"></script>
<body>
<table border="1">
<col width="70px">
<col width="100px">
<col width="300px">
<col width="100px">
<tr>
<th>번   호</th>
<th>작성자</th>
<th>제   목</th>
<th>날   짜</th>
</tr>
<c:choose>
			<c:when test="${empty list }"> 
				<tr>
					<td colspan="4">---작성된 글이 없습니다---</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.num }</td>
						<td>
						
						<a>${dto.name }</a>
						</td>
						<td><a href="controller.do?command=detail&num=${dto.num }">${dto.title }</a>
						</td>
						<td>${dto.date }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

<tr>
<td colspan ="4"><input type = "button" value= "글쓰기" onclick= "location.href='controller.do?command=writeform'"></td>

</tr>
</table>

</body>
</html>