<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page import="client.ClientDAO" %>
<%@ page import="client.StaffDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>CSS</title>
  </head>
  <body>
 	<%
 		ClientDAO clientDAO = new ClientDAO();
 		StaffDAO staffDAO = new StaffDAO();
 		String phone = request.getParameter("phone");
 		String password = request.getParameter("password");
 		String div = request.getParameter("div");
 		if(div.equals("count1")){
 			int result = clientDAO.login(phone, password);
 			int num = clientDAO.loginNo(phone);
 			if (result ==1){
 	 			if(num == -1) {
 	 				PrintWriter script = response.getWriter();
 	 				script.println("<script>");
 	 				script.println("alert('에러')");
 	 				script.println("history.back()"); 			
 	 				script.println("</script>");
 	 			}
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 	 			script.println("location.href ='main_logined.jsp?no=" + num + "'");
 	 			script.println("</script>");
 			}
 			else if(result ==0){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('비밀번호가 틀렸습니다.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 			else if(result ==-1){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('존재하지 않는 아이디입니다.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 			else if(result ==-2){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('데이터베이스오류.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 		} else {
 			int result = staffDAO.login(phone, password);
 			if (result ==1){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 	 			script.println("location.href ='staff_main.jsp'");
 	 			script.println("</script>");
 			}
 			else if(result ==0){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('비밀번호가 틀렸습니다.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 			else if(result ==-1){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('존재하지 않는 아이디입니다.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 			else if(result ==-2){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('데이터베이스오류.')");
 				script.println("history.back()"); 			
 				script.println("</script>");
 			}
 		}
	%>
  </body>
 </html>