package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Command Pattern > Interface 하나만들고 상속받는 여러 Class를 만드는 것
@Controller
// <beans:bean id="hc" class="xxxx.HelloController"/>
public class HelloController {

	@RequestMapping("/hello") // <beans:prop key="/hello">hc</beans:prop>
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello Controller Executing");
		ModelAndView mv = new ModelAndView();
//		Controller ==> JSP 데이터 전달=공유 ==> Model(View 보여줄 데이터)용어
		mv.addObject("model", "Hello Spring Annotation"); // Model Setting. request.setAttribute("model", "view")와 동일한 작업
		mv.setViewName("hello"); // View Setting
		return mv;	
	}

}
