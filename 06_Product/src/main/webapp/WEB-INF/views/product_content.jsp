<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
			<c:set var="dto" value="${cont }" />
			<hr>
				<h1>${dto.products_name }제품 정보</h1>
			<hr>
			<br><br>
		<table border="1">
			<tr>
				<th>제품명</th>
				<td>${dto.products_name }</td>
			</tr>
			
			<tr>
				<th>카테고리 코드</th>
				<td>${dto.category_fk }</td>
			</tr>
			
			<tr>
				<th>제품 코드</th>
				<td>${dto.ep_code_fk }</td>
			</tr>
			
			<tr>
				<th>입고가</th>
				<td>
					<fmt:formatNumber value="${dto.input_price }" />원&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			
			<tr>
				<th>출고가</th>
				<td>
					<fmt:formatNumber value="${dto.output_price }" />원&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			
			<tr>
				<th>마일리지</th>
				<td>
					<fmt:formatNumber value="${dto.mileage }" />&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			
			<tr>
				<th>제조사</th>
				<td>${dto.company }</td>
			</tr>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="14" align="center">
						<h1>제품이 없음</h1>
					</td>
				</tr>
			</c:if>
		</table>
			<input type="button" value="수정" onclick="location.href='product_update.go?pnum=${dto.pnum}'">
			<input type="button" value="삭제" onclick="location.href='product_delete_ok.go?pnum=${dto.pnum}'">
		</div>
</body>
</html>