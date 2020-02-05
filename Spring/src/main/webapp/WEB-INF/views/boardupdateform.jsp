<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>글 수정 합니다.</h1>
	<form action="http://localhost:8080/mvc/boardupdate" method="post">
		<input name="seq" value="${update.seq}" hidden="true">
		제목<input type="text" name="title" value="${update.title}"><br>
		내용<textarea name="contents" rows=10 cols=50>${update.contents}</textarea>
		작성자<input type="text" name="writer" value="${update.writer}"><br>
		암호<input type="password" name="password" value="${update.password}"><br>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>