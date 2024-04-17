<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr>
			<h1>제품 정보 수정</h1>
		<hr>
		<br><br>
		<c:set var="dto" value="${List }" />
		<form method="post" action="<%=request.getContextPath() %>/product_update_ok.go" name="product">
			<input type="hidden" name="pnum" value="${dto.pnum }">
			<table border="1">
				<tr>
					<th>제품명</th>
					<td>
						<input name="products_name" value="${dto.products_name }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>ep코드</th>
					<td>
						<input name="ep_code_fk" value="${dto.ep_code_fk }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>입고가</th>
					<td>
						<input name="input_price" value="${dto.input_price }">
					</td>
				</tr>
				
				<tr>
					<th>출고가</th>
					<td>
						<input name="output_price" value="${dto.output_price }">
					</td>
				</tr>
				
				<tr>
					<th>배송비</th>
					<td>
						<input name="trans_cost" value="${dto.trans_cost }">
					</td>
				</tr>
				
				<tr>
					<th>마일리지</th>
					<td>
						<input name="mileage" value="${dto.mileage }">
					</td>
				</tr>
				
				<tr>
					<th>제조사</th>
					<td>
						<input name="company" value="${dto.company }" readonly>
					</td>
				</tr> 
			</table>
			
			<input type="submit" value="제출">
		
		</form>
		
		
	
	</div>

</body>
</html>