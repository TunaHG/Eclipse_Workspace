package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardlistController {
	@Autowired
	BoardDAO dao;

	@RequestMapping("/boardlist")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardlist", dao.getList());
		mv.setViewName("boardlist");
		return mv;
	}

	// 1개 게시물 조회
	@RequestMapping("/boarddetail")
	public ModelAndView boardDetail(int seq) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boarddetail", dao.boardDetail(seq));
		mv.setViewName("boarddetail");
		return mv;
	}

	// 1개 게시물 글쓰기 Form
	@RequestMapping(value="/boardinsert", method=RequestMethod.GET)
	public String insertBoardForm() {

		return "boardinsertform";
	}

	// 1개 게시물 글 쓴 내용 전달받아서 DB에 저장
	@RequestMapping(value="/boardinsert", method=RequestMethod.POST)
	public String insertBoardResult(@ModelAttribute("vo") BoardVO vo) {
		// BoardDAO 객체 생성하여 insertBoard(vo) 전달
		// System.out.println(vo.getTitle()); => 제대로 받아오는지 확인할 코드
		int result = dao.insertBoard(vo); // 제목, 내용, 작성자, 암호 입력받은 저장상태 객체
		if(result == 1) {
			System.out.println("정상 Insert");
		} else {
			System.out.println("비정상 Insert");
		}
		return "redirect:/boardlist";
	}

	// 1개 게시물 수정사항을 입력할 Form
	@RequestMapping(value="/boardupdate", method=RequestMethod.GET)
	public ModelAndView updateBoardForm(int seq) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", dao.boardDetail(seq));
		mv.setViewName("boardupdateform");
		return mv;
	}
	
	// 1개 게시물 수정을 DB에 저장
	@RequestMapping(value="/boardupdate", method=RequestMethod.POST)
	public String updateBoardResult(BoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:/boardlist";
	}

	// 1개 게시물 삭제
	@RequestMapping("/boarddelete")
	public String deleteBoard(@ModelAttribute("seq") int seq) {
		dao.deleteBoard(seq);
		return "redirect:/boardlist";
	}
}
