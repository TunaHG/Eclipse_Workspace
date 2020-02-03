package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/front") 3.0이상에서 사용하는 방법
public class FrontControllerServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		web.xml의 url-pattern: '/' => FrontControllerServlet 실행
//		1. 모든 요청에 대해서 FrontControllerServlet 실행
//		http://.../board.list와 같은 상황에서도 현재 Servlet이 호출됨
		
//		2. URI 가장 뒤 요소 분석 http://.../board.list
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> FrontControllerServlet </h1>");
		out.println(request.getRequestURL());
		out.println(request.getRequestURI());
		
		String[] str = request.getRequestURI().split("/");
		out.println("<h1>" + str[str.length - 1] + "</h1>");
		
//		3. board.list 일 시키기 MVC(Model - View - Controller) => Spring 내부 환경 이해 로직
	}

}
