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
		<c:set var="dto" value="${Upt }" />

		<div align="center">
			<hr>
				<h2>${dto.pnum }번 시스템 업데이트</h2>
			<hr>
			<br><br>
			<form method="post" action="<%=request.getContextPath() %>/pc_update_ok.go">
			 <input type="hidden" name="pnum" value="${dto.pnum }">
				<table border="1">
					<c:if test="${!empty dto }">
						<tr>
							<th>CPU</th>
							<td><input name="cpu" value="${dto.cpu }"></td>
						</tr>
						
						<tr>
							<th>Mainboard</th>
							<td><input name="mainboard" value="${dto.mainboard }"></td>
						</tr>
						
						<tr>
							<th>VGA</th>
							<td><input name="vga" value="${dto.vga }"></td>
						</tr>
						
						<tr>
							<th>RAM</th>
							<td><input name="ram" value="${dto.ram }"></td>	
						</tr>
						
						<tr>
							<th>OS</th>
							<td><input name="os" value="${dto.os }"></td>
						</tr>				
					</c:if>
					<c:if test="${empty dto }">
						<tr>
							<td colspan="5">
								<h2>정보가 없습니다</h2>
							</td>
						</tr>
					</c:if>
				</table>
				<br><br>
				<input type="submit" value="완료">
				<input type="reset" value="다시">
			</form>
		</div>

</body>
</html>