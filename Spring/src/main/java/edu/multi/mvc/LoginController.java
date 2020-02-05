package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
//	from 입력화면
	@RequestMapping(name="/login", method=RequestMethod.GET)
	public String loginform() { // 1. Mapping method의 return type이 String이면, String이 View의 이름이 된다. >> Spring 규칙
//		Login form 출력 = HTML tag = jsp
		return "loginform";
	}
	/* 아래에 내용 복사후 주석처리함.
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
	*/
	/*
	@RequestMapping(name="/login", method=RequestMethod.POST)
	// id2에 요청파라미터 id를 저장하는 방법
	public ModelAndView loginsuccess(@RequestParam(value="id", required=false, defaultValue="spring") String id2, String pw, int age) {
		// int age => String으로 받은 후 Integer.parseInt()한 값을 매개변수 int로 선언함으로써 자동으로 진행할 수 있음
//		id, pw 입력 전달 상태
//		request.setCharacterEncoding("utf-8"); // => web.xml에서 <filter>를 사용하여 Encoding을 진행했기 때문에 할필요가 없음
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		// form input name="id" : 요청 파라미터 이름 id 전송한다.
		// 요청 파라미터 이름과 컨트롤러 메소드 매개변수 이름이 동일하면 자동으로 저장된다.
		// form 입력 name값=매개변수이름 동일 = DB컬럼명 동일 저장
		
		
		ModelAndView mv = new ModelAndView();
//		ID와 PW가 둘다 spring이여야 로그인상태가 true
		if(id2.equalsIgnoreCase("spring") && pw.equals("spring")) {
			mv.addObject("loginresult", true);
		} else {
			mv.addObject("loginresult", false);
		}
		
		mv.setViewName("loginsuccess");
		return mv;
	} 
	*/
	
	@RequestMapping(name="/login", method=RequestMethod.POST)
	public ModelAndView loginsuccess(@ModelAttribute("login") LoginVO vo) {
		// 요청 파라미터 이름과 컨트롤러 메소드 매개변수가 자바객체 일 때, 객체 내부 멤버변수를 이름과 동일하게 저장
		
		// 컨트롤러 메소드 매개변수가 객체 일 때 자동 모델 사용
		// 모델 이름이 자동으로 결정된다. 다음 메소드가 자동으로 실행된 것과 같다. => mv.addObject("loginVO", vo);
		
		ModelAndView mv = new ModelAndView();
//		ID와 PW가 둘다 spring이여야 로그인상태가 true
		if(vo.getId().equalsIgnoreCase("spring") && vo.getPw().equals("spring")) {
			mv.addObject("loginresult", true);
		} else {
			mv.addObject("loginresult", false);
		}
		
		mv.setViewName("loginsuccess");
		return mv;
	}
}
