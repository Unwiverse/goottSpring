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
			<h1>시스템 구성 등록 폼</h1>
		<hr>
		<br><br><br>
		
		<form method="post" action="<%=request.getContextPath() %>/pc_insert_confirm.go">
			<table border="1">
				<tr>
					<th>cpu</th>
					<td><input name="cpu"></td>
				</tr>
				<tr>
					<th>mainboard</th>
					<td><input name="mainboard"></td>
				</tr>
				<tr>
					<th>vga</th>
					<td><input name="vga"></td>
				</tr>
				<tr>
					<th>ram</th>
					<td><input name="ram"></td>
				</tr>
				<tr>
					<th>os</th>
					<td><input name="os"></td>
				</tr>
				
			</table>
				<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시">
		 </form>
	</div>

</body>
</html>