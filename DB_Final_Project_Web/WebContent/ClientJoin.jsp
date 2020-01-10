<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="client.ClientJoinDTO" %>
    <%@ page import="client.ClientJoinDAO" %>
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
	
	
	ClientJoinDTO data = new ClientJoinDTO();

	data.setName(name);
	data.setEmail(email);
	data.setPassword(password);
	data.setPhone(phone);
	data.setAge(age);
	data.setSex(sex);
	
	ClientJoinDAO manager = ClientJoinDAO.getInstance();
	manager.insert(data);
%>
<script>
	alert("회원가입 성공, 다시 로그인 해주세요.");
	location.href="main.jsp";
</script>