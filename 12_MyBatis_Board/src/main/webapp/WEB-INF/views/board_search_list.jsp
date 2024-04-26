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
		<h2>검색 리스트</h2>
	<hr>
	<br><br>
	<table border="1">
		<c:set var="list" value="${searchPageList }" />
		<c:set var="paging" value="${Paging }" />
		<tr>
			<td colspan="5" align="left">
				<b>검색 게시물 수: ${paging.totalRecord }개</b>
			</td>
		</tr>
	
		<tr>
			<th>번호</th> <th>제목</th> <th>작성자</th>
			<th>조회수</th> <th>작성일자</th>
		</tr>
			
		
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.board_no}</td>
						<td>
							<a href="<%=request.getContextPath() %>/board_content.go?no=${dto.board_no}">
							${dto.board_title}
							</a>
						</td>
						<td>${dto.board_writer}</td>
						<td>${dto.board_hit}</td>
						<td>${dto.board_date.substring(0, 10)}</td>
					</tr>	
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<h2>내역이 없습니다</h2>
					</td>
				</tr>
			</c:if>
	</table>
	
	<br><br><br>
	<%-- 페이징 처리 부분  --%>
		<c:if test="${paging.page > paging.block}">
			<a href="<%=request.getContextPath() %>/board_search.go?page=1&field=${paging.field}&keyword=${paging.keyword}">[처음으로]</a>
			<a href="<%=request.getContextPath() %>/board_search.go?page=${paging.startBlock -1}&field=${paging.field}&keyword=${paging.keyword}">◀</a>
		</c:if>
	
	<c:forEach begin="${paging.startBlock }" end="${paging.endBlock }" var="i">
		<c:if test="${i == paging.page }">
			<b><a href="<%=request.getContextPath() %>/board_search.go?page=${i}&field=${paging.field}&keyword=${paging.keyword}">${i}</a></b>
		</c:if>
		
		<c:if test="${i != paging.page }">
			<a href="<%=request.getContextPath() %>/board_search.go?page=${i}&field=${paging.field}&keyword=${paging.keyword}">${i}</a>
		</c:if>
	</c:forEach>
	
		<c:if test="${paging.endBlock < paging.allPage}">
			<a href="<%=request.getContextPath() %>/board_search.go?page=${paging.endBlock+1}&field=${paging.field}&keyword=${paging.keyword}">▶</a>
			<a href="<%=request.getContextPath() %>/board_search.go?page=${paging.allPage}&field=${paging.field}&keyword=${paging.keyword}">[마지막으로]</a>
		</c:if>
		<hr>
		<br><br>
		
		<%-- 검색 폼 영역 --%>
		<form method="post" action="<%=request.getContextPath() %>/board_search.go">
			<select name="field">
				<option value="title">제목</option>
				<option value="cont">내용</option>
				<option value="title_cont">제목+내용</option>
				<option value="writer">작성자</option>
			</select>
			
			<input name="keyword">&nbsp;&nbsp;&nbsp;
			<input type="submit" value="검색">
		</form> 
		
	</div>

</body>
</html>