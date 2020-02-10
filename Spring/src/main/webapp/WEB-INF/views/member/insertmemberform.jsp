<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/member/insertmember" method="post">
		아이디 : <input type=text name="userid"><br>
		비밀번호 : <input type="password" name="password"><br>
		이름 : <input type=text name="name"><br>
		연락처 : <input type=text name="phone"><br>
		<input type=submit value="회원가입">
	</form>
</body>
</html>