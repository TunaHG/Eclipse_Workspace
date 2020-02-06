package edu.multi.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JQueryController {
	@Autowired
	BoardDAO dao;
	
	@RequestMapping("/jquerytest")
	public String jquerytest() {
		return "jquery";
	}
	
	@RequestMapping("/ajaxtest")
	public String ajaxtest() {
		return "ajax";
	}
	
	@RequestMapping("/ajaxlogin")
	public String ajaxlogin(String id, String pw) {
		return "ajaxsuccess";
	}
	
	// AJAX 요청 처리 응답시 강제 한글인코딩 UTF-8 설정
	@RequestMapping(value="/ajaxlogin2", produces="application/json;charset=utf-8")
	@ResponseBody
	public String ajaxlogin2(String id, String pw) {
		boolean status = false;
		String logintime = "---";
		if(id.equals("ajax") && pw.equals("ajax")) {
			status = true;
			logintime = new java.util.Date().toLocaleString();
		}
		return "{\"status\": " + status + ", \"time\":\"" + logintime + "\"}";
		// {"status":true, "time": "2020년 2월 ..."}
	}
	
	@RequestMapping("/ajaxboard")
	@ResponseBody // return type으로 Java의 모든 객체가 다 올 수 있다. (JSON형식으로 변경해서 줘야한다.)
	public BoardVO ajaxboard(int seq) {
		BoardVO vo = dao.boardDetail(seq);
		
		return vo;
	}
}
