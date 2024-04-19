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
				<h2>PC List</h2>
			<hr>
			<br><br>
		<c:set var="list" value="${List }" />
		<table border="1">
			<tr>
				<th>번호</th> <th>CPU</th> <th>Mainboard</th>
				<th>VGA</th> <th>RAM</th>
				 <th>OS</th>
			</tr>
			
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>
						<a href="<%=request.getContextPath() %>/pc_content.go?pnum=${dto.pnum }">
						${dto.pnum }</a>
						</td>
						
						<td>${dto.cpu }</td>
						
						<td>${dto.mainboard }</td>
						
						<td>${dto.vga }</td>
						
						<td>${dto.ram }</td>
						
						<td>${dto.os }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="4">
						<h1>제품 없음</h1>
					</td>
				</tr>
			</c:if>
			
		</table>
			<input type="button" value="시스템 등록"
			onclick="location.href='pc_insert.go'">
	</div>
</body>
</html>