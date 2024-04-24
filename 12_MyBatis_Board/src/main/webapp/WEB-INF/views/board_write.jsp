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
				<h1>BOARD 테이블 게시판 글 폼 페이지</h1>
			<hr>
			<br><br>
			
			<form method="post"
			action="<%=request.getContextPath() %>/board_write_ok.go">
			
			<table border="1">
				<tr>
					<th>작성자</th>
					<td><input name="board_writer"></td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input name="board_title"></td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
					<textarea rows="7" cols="25" name="board_cont">
					</textarea>
					</td>
				</tr>
				
				<tr>
					<th>비번</th>
					<td><input type="password" name="board_pwd"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="완료">
						<input type="reset" value="다시">
					</td>
				</tr>
			
			</table>
			</form>
		</div>

</body>
</html>