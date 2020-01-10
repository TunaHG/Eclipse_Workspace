<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="client.StaffJoinDAO"%>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));

	StaffJoinDAO manager = StaffJoinDAO.getInstance();
	manager.delete(no);
%>
<script>
	alert("직원 퇴사 완료");
	location.href = "staff_manage.jsp";
</script>
</html>