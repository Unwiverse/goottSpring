<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div align="center">
		<hr>
			<h3>Member 테이블 메인 페이지</h3>
		<hr>
		<br><br>
		
		<a href="<%=request.getContextPath() %>/member_list.go">[회전목록]</a>
	</div>

</body>
</html>
