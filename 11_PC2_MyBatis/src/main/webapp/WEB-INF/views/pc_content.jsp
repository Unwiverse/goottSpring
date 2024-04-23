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
	<c:set var="dto" value="${Cont }" />
	<div align="center">
		<hr>
			<h1>${dto.pnum }번 시스템 정보</h1>
		<hr>
		<br><br>
		
		<table border="1">
		<c:if test="${!empty dto }">
			<tr>
				<th>CPU</th>
				<td>${dto.cpu }</td>
			</tr>
			
			<tr>
				<th>Mainboard</th>
				<td>${dto.mainboard }</td>
			</tr>
			
			<tr>
				<th>VGA</th>
				<td>${dto.vga }</td>
			</tr>
			
			<tr>
				<th>RAM</th>
				<td>${dto.ram }</td>
			</tr>
			
			<tr>
				<th>OS</th>
				<td>${dto.os }</td>
			</tr>
			
		</c:if>
		
		<c:if test="${empty dto }">
			<tr>
				<td colspan="4">
					<h1>정보가 없습니다</h1> 
				</td>
			</tr>
		</c:if>
		</table>
		<br><br>
		<input type="button" value="수정" 
		onclick="location.href='pc_update.go?no=${dto.pnum}'">
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="삭제" 
		onclick="if(confirm('ㄹㅇ?')) {
			location.href='pc_delete.go?no=${dto.pnum}'
			} else {return;}">&nbsp;&nbsp;&nbsp;
		<input type="button" value="목록으로"
		onclick="location.href='pc_list.go'">
	</div>

</body>
</html>