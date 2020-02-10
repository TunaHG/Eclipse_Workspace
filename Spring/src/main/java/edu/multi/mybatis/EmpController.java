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
}
