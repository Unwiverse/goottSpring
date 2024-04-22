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
			<h1>사원 등록 페이지</h1>
		<hr>
		<br><br>
		<c:set var="dto" value="${Dept }" />
		<form method="post" action="<%=request.getContextPath() %>/emp_insert_ok.go">
			<table border="1">
				<tr>
					<th>부서 선택</th>
					<td>
						<select name="deptno">
						
							<c:if test="${empty dto }">
								<option value="">::부서 없음::</option>
							</c:if>
							
							<c:if test="${!empty dto }">
								<c:forEach items="${dto }" var="dept">
									<option value="${dept.deptno}">${dept.dname}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="ename"></td>
				</tr>
				
				<tr>
					<th>담당업무</th>
					<td><input name="job"></td>
				</tr>
				
				<tr>
					<th>매니저</th>
					<td><input name="mgr"></td>
				</tr>
				
				<tr>
					<th>급여</th>
					<td><input name="sal"></td>
				</tr>
				
				<tr>
					<th>인센티브</th>
					<td><input name="comm"></td>
				</tr>
				
				<tr>
					<th>부서번호</th>
					<td><input name="deptno"></td>
				</tr>
				
			</table>
			<br><br>
			<input type="submit" value="전송">
			<input type="reset" value="다시">
		</form>
	
	</div>

</body>
</html>