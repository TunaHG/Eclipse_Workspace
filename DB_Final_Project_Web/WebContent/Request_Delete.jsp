<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="client.RequestDAO"%>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));

	RequestDAO manager = RequestDAO.getInstance();
	manager.delete(no);
%>
<script>
	alert("요청 삭제 완료");
	location.href = "request_manage.jsp";
</script>
</html>