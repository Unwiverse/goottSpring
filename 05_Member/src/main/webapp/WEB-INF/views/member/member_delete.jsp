<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<hr>
		<h3>MEMBER 테이블 회원 삭제</h3>
	<hr>
	<br><br>
	<form method="post" action="<%=request.getContextPath() %>/member_delete_ok.go">
	
	<input type="hidden" name="num" value="${No }">
	
		<table border="1">
			<tr>
				<th>삭제할 회원 비번</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원삭제">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					<input type="reset" value="다시">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>