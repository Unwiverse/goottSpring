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
		<c:set var="dto" value="${Upt }" />
		<div align="center">
			<hr>
				<h1>${dto.board_writer }의 게시글 수정</h1>
			<hr>
			<br><br>
			
			<form method="post" action="<%=request.getContextPath() %>/board_update_ok.go">
				<input type="hidden" name="board_no" value="${dto.board_no }">
				
				<table border="1">
				<c:if test="${!empty dto }" >
				
					<tr>
						<th>작성자</th>
						<td><input name="board_writer" readonly value="${dto.board_writer }"></td>
					
					<tr>
						<th>제목</th>
						<td><input name="board_title" value="${dto.board_title }"></td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td><input name="board_cont" value="${dto.board_cont }"></td>
					</tr>
					
					<tr>
						<th>등록일</th>
						<td><input name="board_date" readonly value="${dto.board_date }"></td>
					</tr>
					
					<tr>
						<th>수정일</th>
						<td><input name="board_update" readonly value="${dto.board_update }"></td>
					</tr>
				</c:if>
					
					<c:if test="${empty dto }">
						<tr>
							<td colspan="2">
								<h1>정보가 없습니다</h1>
							</td>
						</tr>
					</c:if>
					</table>
					<br><br>
					<input type="submit" value="완료">
					<input type="reset" value="다시">
					
			</form>
		</div>

</body>
</html>