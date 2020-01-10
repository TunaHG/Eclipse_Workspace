<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="client.StaffJoinDTO" %>
    <%@ page import="client.StaffJoinDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String age = request.getParameter("age");
	String sex = request.getParameter("sex");
	
	StaffJoinDTO data = new StaffJoinDTO();

	data.setName(name);
	data.setEmail(email);
	data.setPassword(password);
	data.setPhone(phone);
	data.setAge(age);
	data.setSex(sex);
	
	StaffJoinDAO manager = StaffJoinDAO.getInstance();
	manager.insert(data);
%>
<script>
	alert("직원 등록 성공");
	location.href="staff_manage.jsp";
</script>