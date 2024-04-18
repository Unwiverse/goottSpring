<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅎㅇㅇ</title>
</head>
<body>
		<div align="center">
			<hr>
				<h1>멤버 목록</h1>
			<hr>
			<br><br>
			
			<table border="1">
			<tr>
				<th>번호</th>  <th>이름</th> <th>직업</th> <th>등록일</th>
			</tr>
			
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.memno }</td>	
						<td>${dto.memname }</td>
						<td>${dto.job }</td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h1>정보 x</h1>
					</td>
				</tr>
			</c:if>
			</table>
			
			<input type="button" value="시스템 등록" 
			onclick="location.href='pc_insert.go'">
		</div>
</body>
</html>