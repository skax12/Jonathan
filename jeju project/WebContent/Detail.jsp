<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function a(){
	$("#b").hide();
	$("#a").show();
}
function b(){
	$("#a").hide();
	$("#b").show();
}
</script>
<style type="text/css">
 #b{
display: none;

}

</style>
</head>
<body>
	<h1>QnA</h1>
	<div id="a">
		<table border="1">
			<tr>

				<th>글 번 호</th>
				<td>${dto.num }</td>
			</tr>
			<tr>
				<th>작 성 자</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>작 성 일</th>
				<td>${dto.date }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>


			</tr>
			<tr>
				<td><input type="button" value="삭제" onclick="location.href='controller.do?command=delete&num=${dto.num}'">
					<input type="button" value="수정" onclick="b();"> <input type="button" value="답글" onclick="location.href='controller.do?command=answer&num=${dto.num}'">
					<input type="button" value="돌아가기" onclick="location.href='controller.do?command=TestList'"></td>
			</tr>
		</table>
	</div>
	<div id="b">
		<form action="controller.do" method = "get">
			<input type = "hidden" name = "command" value ="update">
			<input type = "hidden" name = "num" value = "${dto.num }">
			
			<table border ="1">

				<tr>
					<td>
						<p>&lt;QnA&gt;</p>
					</td>
				</tr>

				<tr>
					<td>제 목</td>

				</tr>
				<tr>

					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td><textarea rows="15" cols="105" style="overflow-y: scroll" name="content"></textarea></td>
				</tr>
				<tr>
				<td>
					<input type="submit" value="수정완료" >
					<input type="button" value="취소" onclick="a();">
					<input type="button" value="목록" onclick="location.href='contoller.do?command=TestList'">
				</td>
				</tr>
			</table>
		</form>

	</div>


</body>
</html>