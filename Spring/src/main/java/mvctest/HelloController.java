package mvctest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// Command Pattern > Interface 하나만들고 상속받는 여러 Class를 만드는 것
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello Controller Executing");
		ModelAndView mv = new ModelAndView();
//		Controller ==> JSP 데이터 전달=공유 ==> Model(View 보여줄 데이터)용어
		mv.addObject("model", "Hello Spring"); // Model Setting. request.setAttribute("model", "view")와 동일한 작업
		mv.setViewName("hello"); // View Setting
		return mv;	
	}

}
