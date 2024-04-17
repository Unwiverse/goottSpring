<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쥔장의 페이지</title>
</head>
<body>
	<div align="center">
		<hr color="brown">
			<h1>소리에게 돈</h1>
		<hr color="brown">
		<br><br>
		
		<c:set var="list" value="${List }" />
		<form method="post" action="<%=request.getContextPath() %>/product_insert_ok.go" name="product">
			<table>
				<tr>
					<th>카테고리 선택</th>
					<td>
						<select name="category_fk">
						
							<c:if test="${empty list }">
								<option value="">::카테고리 코드 없음::</option>
							</c:if>
							
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="category">
									<option value="${category.category_code}">${category.category_name}</option>
								</c:forEach>
							</c:if>
							
						</select>
					</td>
					
				<tr>
					<th>제품명</th>
					<td>
						<input type="text" name="products_name">
					</td>
				</tr>
				<tr>
					<th>ep코드</th>
					<td>
						<input type="text" name="ep_code_fk">
					</td>
				</tr><tr>
					<th>입고가</th>
					<td>
						<input type="text" name="input_price">
					</td>
				</tr><tr>
					<th>출고가</th>
					<td>
						<input type="text" name="output_price">
					</td>
				</tr><tr>
					<th>배송비</th>
					<td>
						<input type="text" name="trans_cost">
					</td>
				</tr><tr>
					<th>마일리지</th>
					<td>
						<input type="text" name="mileage">
					</td>
				</tr><tr>
					<th>제조사</th>
					<td>
						<input type="text" name="company">
					</td>
				</tr> 
					
			</table>
				<input type="submit" value="등록">
				<input type="reset" value="초기화">
		</form>	
	</div>

</body>
</html>