<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.ClientJoinDTO" %>
<%@ page import="client.ClientJoinDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	int whr = Integer.parseInt(request.getParameter("whr"));
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String age = request.getParameter("age");
	String sex = request.getParameter("sex");
	
	ClientJoinDTO data = new ClientJoinDTO();

	data.setNo(no);
	data.setName(name);
	data.setEmail(email);
	data.setPassword(password);
	data.setPhone(phone);
	data.setAge(age);
	data.setSex(sex);
	
	ClientJoinDAO manager = ClientJoinDAO.getInstance();
	manager.update(data);
	
	if(whr == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert(\"회원 정보 수정 완료\")");
		script.println("location.href=" + "'mypage.jsp?no=" + no + "'");		
		script.println("</script>");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert(\"회원 정보 수정 완료\")");
		script.println("location.href='client_manage.jsp'");		
		script.println("</script>");
	}
%>