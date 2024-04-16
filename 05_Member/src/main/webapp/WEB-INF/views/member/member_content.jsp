<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
			<c:set var="dto" value="${content }" />
			<hr>
				<h3>${dto.memname } 회원 정보</h3>
			<hr>
			<br><br>
			
			<table border="1">
				<tr>
					<th>회원 번호</th>
					<td>${dto.memno }</td>
				</tr>
				
				<tr>
					<th>회원 아이디</th>
					<td>${dto.memid }</td>
				</tr>
				
				<tr>
					<th>회원 이름</th>
					<td>${dto.memname }</td>
				</tr>
				
				<tr>
					<th>회원 비번</th>
					<td>
						<c:if test="${!empty dto.mempwd }">
							<c:forEach begin="1" end="${dto.mempwd.length() }">
								*
							</c:forEach>
						</c:if>
					</td>
				</tr>
				
				<tr>
					<th>회원 나이</th>
					<td>${dto.age }</td>
				</tr>
				
				<tr>
					<th>회원 마일리지</th>
					<td>
						<fmt:formatNumber value="${dto.mileage }" />
					</td>
				</tr>
				
				<tr>
					<th>회원 주소</th>
					<td>${dto.addr }</td>
				</tr>
				
				<tr>
					<th>가입일</th>
					<td>${dto.regdate }</td>
				</tr>
				
				<c:if test="${empty dto }">
					<tr>
						<td colspan="2" align="center">
							<h3>정보 없음</h3>
						</td>
					</tr>
				</c:if>
				
			</table>
			<br><br>
			
			 <input type="button" value="회원수정"
	      onclick="location.href='member_modify.go?num=${dto.memno }'">&nbsp;&nbsp;
			
			<input type="button" value="삭제" 
				onclick="if(confirm('ㄹㅇ?')) {
			 location.href='member_delete.go?num=${dto.memno }' 
			 } else {return;}">&nbsp;&nbsp;
			
			<input type="button" value="목록"
	      onclick="location.href='member_list.go'">	
		</div>
</body>
</html>