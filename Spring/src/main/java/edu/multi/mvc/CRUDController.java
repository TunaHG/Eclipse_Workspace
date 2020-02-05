package edu.multi.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 회원 관리
@Controller
public class CRUDController {
	Map<String, String> members = new HashMap<String, String>();
	
	// http://ip:port/ContextName/crud/start
	@RequestMapping("/crud/start")
	public void start(){
		System.out.println("===홈페이지 첫 화면입니다.===");
		members.put("spring", "김사원");
		members.put("oracle", "박대리");
		members.put("mybatis", "최과장");
		// return "crud/start"; // WEB-INF/views/crud/start.jsp
	}
	
	@RequestMapping("/crud/list")
	public ModelAndView list(){
		// View이름 명시한 문장 없으면 자동 URL 이름 동일 뷰 ==> void일때, URL로 지정한 /crud/list의 경로에 있는 JSP파일을 추적한다.
		// 모든 회원 정보
		ModelAndView mv = new ModelAndView();
		mv.addObject("members" ,members);
		mv.setViewName("crud/list");
		return mv;
	}
	
	@RequestMapping("/crud/get")
	public ModelAndView get(HttpServletRequest request){
		String id = request.getParameter("id");
		String name = members.get(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", id + ":" + name);
		return mv;
	}
	
	@RequestMapping("/crud/add")
	public void add(){
		// "new" "신입사원" members 추가 - crud/add.jsp
		members.put("new", "신입사원");
	}
	
	@RequestMapping("/crud/update")
	public Map<String, String> update(){
		Map<String, String> informs = new HashMap<String, String>();
		informs.put("id", "수정할 id를 입력하세요.");
		informs.put("name", "수정할 이름을 입력하세요.");
		informs.put("email", "수정할 이메일을 입력하세요. (xxx@yyy.com 형식)");
		informs.put("idvalue", "spring");
		
		return informs; // Map => 자동 Model
		// View 이름 자동 .../crud/update.jsp
	}
	
	@RequestMapping("/crud/delete")
	public String delete() {
		// "new" 아이디 members에서 삭제
		members.remove("new");
		return "redirect:/crud/list"; // redirect: => /crud/list로 Mapping된 Method를 실행하라는 의미. 
	}
}
