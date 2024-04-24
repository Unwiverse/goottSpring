<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="dto" value="${cont }" />
	<div align="center">
		<hr>
			<h2>${dto.board_writer }의 게시글 정보</h2>	
		<hr>
		<br><br>
		<table border="1">
		<c:if test="${!empty dto }">
			<tr>
				<th>제목</th>
				<td>${dto.board_title }</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>${dto.board_cont }</td>
			</tr>
			
			<tr>
				<th>작성자</th>
				<td>${dto.board_writer }</td>
			</tr>
			
			<tr>
				<th>조회수</th>
				<td>${dto.board_hit }</td>
			</tr>
			
			<tr>
				<th>게시일</th>
				<td>${dto.board_date }</td>
			</tr>
			
			<tr>
				<th>수정일</th>
				<td>${dto.board_update }</td>
			</tr>
			</c:if>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2">
						<h2>정보가 없습니다</h2>
					</td>
				</tr>
			</c:if>
		</table>
		<br><br>
		<input type="button" value="수정" onclick="location.href='board_update.go?no=${dto.board_no}'">
		<input type="button" value="삭제" 
		onclick="if(confirm('ㄹㅇ?')) {
		location.href='board_delete.go?no=${dto.board_no}'
		} else {return;}">
	</div>

</body>
</html>