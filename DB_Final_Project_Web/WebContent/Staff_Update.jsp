<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.StaffJoinDTO" %>
<%@ page import="client.StaffJoinDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String age = request.getParameter("age");
	String sex = request.getParameter("sex");
	
	StaffJoinDTO data = new StaffJoinDTO();

	data.setNo(no);
	data.setName(name);
	data.setEmail(email);
	data.setPassword(password);
	data.setPhone(phone);
	data.setAge(age);
	data.setSex(sex);
	
	StaffJoinDAO manager = StaffJoinDAO.getInstance();
	manager.update(data);
%>
<script>
	alert("직원 정보 수정 완료");
	location.href="staff_manage.jsp";
</script>