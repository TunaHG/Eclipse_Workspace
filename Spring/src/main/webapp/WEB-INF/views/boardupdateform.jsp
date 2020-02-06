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
		번호<input type=hidden name="seq" value="${update.seq}" readonly><br>
		제목<input type="text" name="title" value="${update.title}"><br>
		내용<textarea name="contents" rows=10 cols=50>${update.contents}</textarea><br>
		작성자<input type="text" name="writer" value="${update.writer}"><br>
		암호<input type="password" name="password" value="${update.password}"><br>
		작성시간<input type=text name="time" value="${update.time}" readonly><br>
		조회수<input type=text name="viewcount" value="${update.viewcount}" readonly><br>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>