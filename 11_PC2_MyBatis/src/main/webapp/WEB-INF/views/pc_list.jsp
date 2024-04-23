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
			<h2>시스템 전체 목록</h2>
		<hr>
		<br><br>
		
		
		<table border="1">
			<tr>
				<th>번호</th> <th>CPU</th> <th>Mainboard</th>
				<th>VGA</th> <th>RAM</th> <th>OS</th> <th>img</th>
			</tr>
			
			<c:set var="dto" value="${List }" />
			<c:if test="${!empty dto }">
				<c:forEach items="${dto }" var="part">
					<tr>
						<td>
							<a href="<%=request.getContextPath() %>/pc_content.go?no=${part.pnum}">
							${part.pnum }
							</a>
						</td> 
						<td>${part.cpu }</td> 
						<td>${part.mainboard }</td>
						<td>${part.vga }</td> 
						<td>${part.ram }</td> 
						<td>${part.os }</td>
						<td>
					        <!-- 이미지를 표시할 위치 -->
					        <img id="partImage_${part.pnum}" src='<%= request.getContextPath() %>/${part.img}' width="100" height="100">
					    </td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="5">
						<h1>목록 없음</h1>
					</td>
				</tr>
			</c:if>
		</table>
		<br><br>
		<input type="button" value="추가"
		onclick="location.href='pc_insert.go'">
		<br><br>
		
		<form method="post" 
			action="<%=request.getContextPath() %>/pc_search.go">
			<select name="field">
				<option value="cpu">CPU</option>
				<option value="mainboard">Mainboard</option>
				<option value="vga">VGA</option>
				<option value="ram">RAM</option>
			</select>
			<input name="keyword">&nbsp;&nbsp;&nbsp;
			<input type="submit" value="검색">
		</form>
	</div> 

</body>
</html>