package edu.multi.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpDAO dao;
	
	@RequestMapping("/mybatis/emplist")
	public ModelAndView getAllEmp() {
		// employees table의 모든 레코드 조회
		// List<EmpVO> => Model
		// View 결정
		List<EmpVO> list = dao.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/mybatis/detailemp")
	public ModelAndView getDetailEmp(int employee_id) {
		EmpVO vo = dao.getOneEmp(employee_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		
		return mv;
	}
	
	// employees 테이블 존재 레코드 갯수 페이지 번호를 생성
	@RequestMapping("/mybatis/pagingemplist")
	// 1. select count(*) from employees; => 108
	// mybatis - emp-mapping.xml
	public ModelAndView getCntEmp(){
		int count = dao.getCountEmp();
		int cntPerPage = 10;
		int totalPage = 0;
		if(count % cntPerPage != 0) {
			totalPage = count / cntPerPage + 1;
		} else {
			totalPage = count / cntPerPage;
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPage", totalPage);
		
		return mv;
	}
	
	@RequestMapping("/mybatis/pagingemplist2")
	public ModelAndView getPagingEmpList(int pagenum) {
		int cntPerPage = 10;
		int start = (pagenum - 1) * cntPerPage + 1;
		int end = pagenum * cntPerPage;
		int[] param = {start, end};
		List<EmpVO> paginglist = dao.pagingEmp(param);
		ModelAndView mv = new ModelAndView();
		mv.addObject("paginglist", paginglist);
		
		return mv;
	}
}
