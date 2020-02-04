package mvctest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardlistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDAO dao = new BoardDAO();
		mv.addObject("boardlist", dao.getList());
		mv.setViewName("boardlist");
		return mv;
	}

}
