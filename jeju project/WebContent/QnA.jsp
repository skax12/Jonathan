<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta name = "viewport" content ="width=device-width", initial-scale="1">
<link rel = "stylesheet" href="css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
input {
	width: 767px;
}

p {
	font-size: 25px;
}

#h {
	height: 300px;
}
</style>

</head>
<body>

<form action="controller.do" method = "post">
<input type = "hidden" name = "command" value="write">
	<table border = "1">
		<tr>
			<td>
				<p>&lt;QnA&gt;</p>
			</td>
		</tr>

		<tr>
			<td>제 목</td>

		</tr>
		<tr>

			<td><input type="text" name = "title"></td>
		</tr>
		<tr>
			<td><textarea rows="15" cols="105" style="overflow-y: scroll" name = "content"></textarea></td>
		</tr>

		
	</table>
	
	<input type="submit" value="작성 완료">
	</form>


</body>
</html>