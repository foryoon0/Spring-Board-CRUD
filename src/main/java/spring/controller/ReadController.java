package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Board;

@Controller
@RequestMapping("/board")
public class ReadController {
	
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/ReadBoard/{qnaBoardNum}")
	public String ReadBoard(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
		
		Board board = dao.selectByqnaBoardNum(qnaBoardNum);
		
		if(board==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("board", board);
		
		return "board/ReadBoard";
	}
}

