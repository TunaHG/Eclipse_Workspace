package mvctest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Command Pattern > Interface 하나만들고 상속받는 여러 Class를 만드는 것
public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello Controller Executing");
//		Servlet ==> JSP 데이터 전달=공유
		request.setAttribute("model", "Hello Spring");
		return "/hello.jsp";
//		request.getAttribute("model") ==> ${model} 같은 동작
	}

}
