<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>선택한 번호에 대한 Board</h1>
	<h3>
		번호: ${boarddetail.seq}, 
		제목: ${boarddetail.title}, 
		내용: ${boarddetail.contents}, 
		작성자: ${boarddetail.writer}, 
		일시: ${boarddetail.time}, 
		조회수: ${boarddetail.viewcount} 
	</h3>
	<form action="http://localhost:8080/mvc/boardupdate">
		<input value="${boarddetail.seq}" name="seq" hidden="true">
		<input type="submit" value="수정">
	</form>
	<form action="http://localhost:8080/mvc/boarddelete">
		<input type="hidden" value="${boarddetail.seq}" name="seq">
		<input type="submit" value="삭제">
	</form>
	<form action="http://localhost:8080/mvc/boardlist">
		<input type="submit" value="목록">
	</form>
</body>
</html>