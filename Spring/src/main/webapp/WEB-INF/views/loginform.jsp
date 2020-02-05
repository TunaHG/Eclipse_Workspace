<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>loginform.jsp 파일이 보입니다.</h1>
	
	<form action="http://localhost:8080/mvc/login" method="POST">
		ID:<input type="text" name="id"><br>
		PW:<input type="password" name="pw"><br>
		AGE:<input type="text" name="age"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>