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
			<h2>${dto.ename } 사원의 프로필</h2>
		<hr>
		<br><br>
		
		<table border="1">
		<c:if test="${!empty dto }">
			<tr>
				<th>사원 번호</th>
				<td>${dto.empno }</td>
			</tr>
			
			<tr>
				<th>담당 업무</th>
				<td>${dto.job }</td>
			</tr>
			
			<tr>
				<th>매니저</th>
				<td>${dto.mgr }</td>
			</tr>
			
			<tr>
				<th>고용일</th>
				<td>${dto.hiredate }</td>
			</tr>
			
			<tr>
				<th>급여</th>
				<td>${dto.sal }</td>
			</tr>
			
			<tr>
				<th>인센티브</th>
				<td>${dto.comm }</td>
			</tr>
			
			<tr>
				<th>부서번호</th>
				<td>${dto.deptno }</td>
			</tr>
		</c:if>
		
		<c:if test="${empty dto }">
			<tr>
				<td colspan="5">
					<h2>왜안뜰까</h2>
				</td>
			</tr>
		</c:if>
		</table>
		<br><br>
		<input type="button" value="수정" onclick="location.href='emp_update.go?no=${dto.empno}'">&nbsp;&nbsp;&nbsp;
		<input type="button" value="삭제" 
		onclick="if(confirm('ㄹㅇ?')) {
		location.href='emp_delete.go?no=${dto.empno}'
		} else {return;}">&nbsp;&nbsp;&nbsp;
		<input type="button" value="사원목록"
	       onclick="location.href='emp_list.go'">
	</div>
</body>
</html>