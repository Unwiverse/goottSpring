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
	<div align="center">
		<hr>
			<h1>삭제 확인 비번</h1>
		<hr>
		<br><br>
		
		<form method="post"
			action="<%=request.getContextPath() %>/board_delete_ok.go">
			<c:set var="dto" value="${delete }" />
			
			<input type="hidden" name="board_no" value="${dto.board_no }">
			<input type="hidden" name="db_pwd" value="${dto.board_pwd }">
			
			<table border="1">
				<tr>
					<th>삭제할 글 비번</th>
					<td><input type="password" name="board_pwd"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="완료">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시">
					</td>
				</tr>
			
			</table>
			</form>
	
	</div>

</body>
</html>