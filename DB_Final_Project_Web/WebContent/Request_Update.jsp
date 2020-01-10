<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.RequestDTO" %>
<%@ page import="client.RequestDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	String room = request.getParameter("room");
	String content = request.getParameter("content");
	String respond = request.getParameter("respond");
	String ing = request.getParameter("ing");
	
	RequestDTO data = new RequestDTO();

	data.setNo(no);
	data.setRoom(room);
	data.setContent(content);
	data.setRespond(respond);
	data.setIng(ing);
	
	RequestDAO manager = RequestDAO.getInstance();
	manager.update(data);
%>
<script>
	alert("요청 수정 완료");
	location.href="request_manage.jsp";
</script>