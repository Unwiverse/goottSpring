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
		<c:set var="emp" value="${update }" />
		<form method="post" action="<%=request.getContextPath() %>/emp_update_ok.go">
		<input type="hidden" name="empno" value="${emp.empno }">
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
									<c:if test="${dept.deptno == emp.deptno}">
										<option selected value="${dept.deptno}">${dept.dname}</option>
									</c:if>
									
									<c:if test="${dept.deptno != emp.deptno }">
										<option value="${dept.deptno}">${dept.dname}</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="ename" value="${emp.ename }" readonly></td>
				</tr>
				
				<tr>
					<th>담당업무</th>
					<td><input name="job" value="${emp.job }"></td>
				</tr>
				
				<tr>
					<th>매니저</th>
					<td><input name="mgr" value="${emp.mgr }" ></td>
				</tr>
				
				<tr>
					<th>급여</th>
					<td><input name="sal" value="${emp.sal }" ></td>
				</tr>
				
				<tr>
					<th>인센티브</th>
					<td><input name="comm" value="${emp.comm }" ></td>
				</tr>
				
				<tr>
					<th>부서번호</th>
					<td><input name="deptno" value="${emp.deptno }" ></td>
				</tr>
				
			</table>
			<br><br>
			<input type="submit" value="전송">
			<input type="reset" value="다시">
		</form>
	
	</div>

</body>
</html>