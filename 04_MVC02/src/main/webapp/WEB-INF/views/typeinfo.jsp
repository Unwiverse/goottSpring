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
				<h3>insert your PC spec info</h3>
			<hr>
			<br><br>
			<form method="post" action="<%=request.getContextPath() %>/insert_Ok">
				<table>
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
						<td colspan="2" align="center">
						<td> <input type="submit" value="OK">&nbsp;&nbsp;
							 <input type="reset" value="cancel"></td>
					</tr>
					
				</table>
			
			
			</form>
			<table border="1">
			
			</table>
		
		</div>

</body>
</html>