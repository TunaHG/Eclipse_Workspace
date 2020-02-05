package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
//	from 입력화면
	@RequestMapping(name="/login", method=RequestMethod.GET)
	public String loginform() { // 1. Mapping method의 return type이 String이면, String이 View의 이름이 된다. >> Spring 규칙
//		Login form 출력 = HTML tag = jsp
		return "loginform";
	}
//	<form action="" method=POST
//	form 입력 내용 전달받아서 처리 결과 화면
	@RequestMapping(name="/login", method=RequestMethod.POST)
	public ModelAndView loginsuccess(HttpServletRequest request) {
//		id, pw 입력 전달 상태
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ModelAndView mv = new ModelAndView();
//		ID와 PW가 둘다 spring이여야 로그인상태가 true
		if(id.equalsIgnoreCase("spring") && pw.equals("spring")) {
			mv.addObject("loginresult", true);
		} else {
			mv.addObject("loginresult", false);
		}
		
		mv.setViewName("loginsuccess");
		return mv;
	}
}
