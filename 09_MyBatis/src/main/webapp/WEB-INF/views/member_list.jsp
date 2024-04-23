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
		<c:set var="dto" value="${List }" />
			<table border="1">
				<tr>
					<th>번호</th><th>아이디</th><th>이름</th>	
					<th>비번</th><th>나이</th><th>마일리지</th><th>직업</th>
					<th>주소</th><th>등록일</th>
				</tr>
			<c:if test="${!empty dto }">
			<c:forEach items="${dto }" var="list">
				<tr>
					<td>${list.memno }</td>
					<td>${list.memid }</td>
					<td>${list.memname }</td>
					<td>${list.mempwd }</td>
					<td>${list.age }</td>
					<td>${list.mileage }</td>
					<td>${list.job }</td>
					<td>${list.addr }</td>
					<td>${list.regdate }</td>
				</tr>
		</c:forEach>
		</c:if>
			</table>
			<br><br>
			<input type="button" value="등록"
			onclick="location.href='member_insert.go'">
			
			
	</div>

</body>
</html>