package edu.multi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.GET)
	public String insertForm() {
		return "member/insertmemberform";
	}
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.POST)
	public String insertMember(MemberVO vo) {
		int check = dao.checkMember(vo.getUserid());
		if(check != 0) {
			return "member/inserterror";
		} else {
			dao.insertMember(vo);
			return "member/login";
		}
	}
	
	@RequestMapping("/member/login")
	public String loginform() {
		return "member/login";
	}
	
	@RequestMapping("/member/loginprocess")
	public String loginprocess(HttpServletRequest request, String userid, String password) {
		MemberVO vo = dao.selectMember(userid, password);
		HttpSession session = request.getSession();
		session.setAttribute("member", vo);
		return "member/loginprocess";
	}
	
	@RequestMapping("/member/mypage")
	public String getMyPage() {
		return "member/mypage";
	}
	
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("member");
		return "member/logout";
	}
}
