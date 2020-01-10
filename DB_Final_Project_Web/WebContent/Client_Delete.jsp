<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="client.ClientJoinDAO"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	int whr = Integer.parseInt(request.getParameter("whr"));

	ClientJoinDAO manager = ClientJoinDAO.getInstance();
	manager.delete(no);
	if(whr == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert(\"회원 탈퇴 완료\")");
		script.println("location.href='main.jsp'");		
		script.println("</script>");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert(" + "회원 탈퇴 완료" + ")");
		script.println("location.href='client_manage.jsp'");		
		script.println("</script>");
	}
%>
</html>