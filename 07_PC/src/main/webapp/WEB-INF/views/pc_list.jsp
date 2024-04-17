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
		<c:set var="dto" value="${List }" />
		<table border="1">
			<tr>
				<th>번호</th> <th>CPU</th> <th>Mainboard</th>
				<th>VGA</th> <th>RAM</th> <th>SSD</th>
				<th>HDD</th> <th>PSU</th> <th>OS</th>
				<th>CPU Cooler</th>
			</tr>
			
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.pnum }</td>
						<td>${dto.cpu }</td>
						<td>${dto.mainboard }</td>
						<td>${dto.vga }</td>
						<td>${dto.ram }</td>
						<td>${dto.ssd }</td>
						<td>${dto.hdd }</td>
						<td>${dto.psu }</td>
						<td>${dto.os }</td>
						<td>${dto.cpu_cooler }</td>
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
	</div>
</body>
</html>