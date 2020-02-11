<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%=session.getAttribute("member") %>
	${sessionScope.member}
	<h1>${member.userid} 회원님 로그인하셨습니다.</h1>
	<h2>회원님의 이름은 ${member.name}입니다.</h2>	
	
	<h3><a href="/mvc/member/mypage">내정보 보러가기</a></h3>	
	<h3><a href="/mvc/member/logout">로그아웃</a></h3>	
</body>
</html>