<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- servlet, jsp에서 WebContent\WEB-INF\lib 폴더내에 => jstl.jar, standard.jar 두 라이브러리를 추가한 후 사용하는것, Spring mvc에선 기본으로 추가되어 있다. -->
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:forEach items="${list}" var="vo">
		사번 : ${vo.employee_id} / 성 : ${vo.last_name}, 이름 : ${vo.first_name} <br>
	</c:forEach>
</body>
</html>