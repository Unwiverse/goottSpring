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
				<h3>로그인 입력 폼 페이지</h3>
			<hr>
			<br><br>
			
			<form method="post" action="<%=request.getContextPath() %>/login_ok">
				<table border="1">
					<tr>
						<th>아이디</th>
						<td> <input name="user_id"> </td>
					</tr>
					
					<tr>
						<th>비번</th>
						<td> <input name="user_pwd"> </td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소"></td>
					</tr>
				</table>
			</form>
			
		</div>

</body>
</html>