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
		<form method="post" action="<%=request.getContextPath() %>/member_insert_ok.go">
			<table border="1">
				<tr>
					<th>회원 이름</th>
					<td> <input name="memname"></td>
				</tr>
				
				<tr>
					<th>회원 아이디</th>
					<td> <input name="memid"></td>
				</tr>
				
				<tr>
					<th>회원 비번</th>
					<td> <input type="password" name="mempwd"></td>
				</tr>
				
				<tr>
					<th>회원 나이</th>
					<td> <input name="age"></td>
				</tr>
				
				<tr>
					<th>회원 직업</th>
					<td> <input name="job"></td>
				</tr>
				
				<tr>
					 <th>회원 주소</th>
					 <td> <input name="addr"></td>
				</tr>
				
				<tr>
					<th>회원 전번</th>
					<td> <input name="phone"></td>
				</tr>
				
				<tr>
					<th>회원 마일리지</th>
					<td> <input name="mileage"></td>
				</tr>
			</table>
				<input type="submit" value="전송">
				<input type="reset" value="다시">
		</form>
	
	</div>

</body>
</html>