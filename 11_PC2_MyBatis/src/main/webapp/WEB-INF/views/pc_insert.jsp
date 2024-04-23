<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr>
			<h2>시스템 등록</h2>
		<hr>
		<br><br>
		<form method="post" action="<%=request.getContextPath() %>/pc_insert_ok.go">
			<table border="1">
				<tr>
					<th>CPU</th>
					<td><input name="cpu"></td>
				</tr>
				
				<tr>
					<th>Mainboard</th>
					<td><input name="mainboard"></td>
				</tr>
				
				<tr>
					<th>VGA</th>
					<td><input name="vga"></td>
				</tr>
				
				<tr>
					<th>RAM</th>
					<td><input name="ram"></td>
				</tr>
			
				<tr>
					<th>OS</th>
					<td><input name="os"></td>
				</tr>
			</table>
			<br><br>
			<input type="submit" value="완료">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="다시">
		</form>
	</div>

</body>
</html>