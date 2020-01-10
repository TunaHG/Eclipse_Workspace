<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.RequestDTO" %>
<%@ page import="client.RequestDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	String room = request.getParameter("room");
	String content = request.getParameter("content");
	String respond = request.getParameter("respond");
	String ing = request.getParameter("ing");
	
	RequestDTO data = new RequestDTO();

	data.setRoom(room);
	data.setContent(content);
	data.setRespond(respond);
	data.setIng(ing);
	
	RequestDAO manager = RequestDAO.getInstance();
	manager.insert(data);
%>
<script>
	alert("요청 등록 성공");
	location.href="request_manage.jsp";
</script>