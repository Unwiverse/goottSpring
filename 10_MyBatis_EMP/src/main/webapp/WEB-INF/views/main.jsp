<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
	<br><br><br><br><br>
		<hr>
			<h1>시작 페이지</h1>
		<hr>	
	<br><br><br><br><br>
	<br><br>
	<a href="<%=request.getContextPath() %>/emp_list.go">[전체 사원 목록]</a>
	
	</div>


</body>
</html>
