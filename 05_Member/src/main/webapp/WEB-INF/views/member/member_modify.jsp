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
			<h2>회원 정보 수정</h2>
		<hr>
		<br><br>
	<c:set var="dto" value="${Modify }" />
	<form method="post" action="<%=request.getContextPath() %>/member_modify_ok.go">
	<input type="hidden" name="memno" value="${dto.memno }">
	
		<table border="1">
			<tr>
	            <th>회원 이름</th>
	            <td> <input name="memname" readonly
	            		value="${dto.memname }"> </td>
	         </tr>
			
			 <tr>
	            <th>회원 아이디</th>
	            <td> <input name="memid" readonly
	            		value="${dto.memid }"> </td>
	         </tr>
			
			<tr>
	            <th>회원 비밀번호</th>
	            <td> <input type="password" name="mempwd" value="${dto.mempwd }"> </td>
	         </tr>
			
			<tr>
				<th>회원 나이</th>
				<td> <input name="age" value="${dto.age }"> </td>
			</tr>
			
			<tr>
				<th>회원 직업</th>
				<td> <input name="job" value="${dto.job }"></td>
			</tr>
			
			  <tr>
	            <th>회원 주소</th>
	            <td> <input name="addr" value="${dto.addr }"> </td>
	         </tr>
			
			<tr>
				<th>회원 마일리지</th>
				<td> <input name="mileage" value="${dto.mileage }"></td>
			</tr>
		</table>
		<input type="submit" value="전송">
		<input type="reset" value="다시">
	</form>


</div>

</body>
</html>