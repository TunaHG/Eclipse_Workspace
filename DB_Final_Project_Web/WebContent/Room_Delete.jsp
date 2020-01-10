<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="client.RoomDAO"%>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));

	RoomDAO manager = RoomDAO.getInstance();
	manager.delete(no);
%>
<script>
	alert("객실 삭제 완료");
	location.href = "room_manage.jsp";
</script>
</html>