package edu.multi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class memberController {
	@Autowired
	memberDAO dao;
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.GET)
	public String insertForm() {
		return "member/insertmemberform";
	}
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.POST)
	public String insertMember(memberVO vo) {
		int check = dao.checkMember(vo);
		if(check != 0) {
			return "member/inserterror";
		} else {
			dao.insertMember(vo);
			return "member/login";
		}
	}
	
}
