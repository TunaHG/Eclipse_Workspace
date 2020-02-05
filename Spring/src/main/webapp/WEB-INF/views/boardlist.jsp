<%-- <%@page import="mvctest.BoardVO"%>
<%@page import="java.util.ArrayList"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Board</title>
</head>
<body>
	<h1>전달 받은 값들</h1>
	${boardlist}<br>
	
	<%-- <h1>이쁘게 보는 값들</h1>
	<% 
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("model");
	
	for(BoardVO vo : list){
		out.println("<h3> 번호: " + vo.getSeq());
		out.println(", 제목: " + vo.getTitle());
		out.println(", 내용: " + vo.getContents());
		out.println(", 작성자: " + vo.getWriter());
		out.println(", 일시: " + vo.getTime());
		out.println(", 조회수: " + vo.getViewcount() + "</h3>");
	}
	%> --%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h1>EL 표현식</h1>
	<c:forEach items="${boardlist}" var="vo">
		<h3> 
		번호: <a href="http://localhost:8080/mvc/boarddetail?seq=${vo.seq}">${vo.seq}</a>, 
		제목: ${vo.title}, 
		내용: ${vo.contents}, 
		작성자: ${vo.writer}, 
		일시: ${vo.time}, 
		조회수: ${vo.viewcount} 
		</h3>		
	</c:forEach>
	
</body>
</html>