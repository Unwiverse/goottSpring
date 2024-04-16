<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
			<hr>
				<h1>ㅎㅇㅎㅇㅇ</h1>
			<hr>
			<br><br>
		
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제품명</th>
				<th>가격</th>
				<th>제조사</th>
			</tr>
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.pnum }</td>
						<td>${dto.products_name }</td>
						<td><fmt:formatNumber value="${dto.output_price }" />원</td>
						<td>${dto.company }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>제품이 없습니다</h3>
					</td>
				</tr>
			</c:if>
		</table>
		</div>
</body>
</html>