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
				<h3>MEMBER 테이블 회원 목록 페이지</h3>
			<hr>
			<br><br>
			<table border="1">
				<tr>
					<th>회원 번호</th> <th>회원 이름</th>
					<th>회원 직업</th> <th>가입일</th>
				</tr>
				
				<c:set var="list" value="${MemberList }" />
					<c:if test="${!empty list }">
						<c:forEach items="${list }" var="dto">
					<tr>
						<td> ${dto.getMemno() }</td>
						<td> ${dto.getMemname() }</td>
						<td> ${dto.getJob() } </td>
						<td> ${dto.getRegdate().substring(0, 10) }</td>
					</tr>
						</c:forEach>
					</c:if>
				
					<c:if test="${empty list }">
						<tr>
							<td colspan="4" align="center">
								<h3>회원 전체 리스트가 없음</h3>
							</td>
						</tr>
					</c:if>
					
			</table>
			<br><br>
				<input type="button" value="회원 추가"
				onclick="<%=request.getContextPath() %>/member_insert.go">
		</div>

</body>
</html>