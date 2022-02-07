package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDao;
import spring.vo.Board;

@Controller
public class UpdateController {

	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
		
	@RequestMapping(value="/editPost/{qnaBoardNum}", method=RequestMethod.POST)
	public String editPost(
		
		@PathVariable("qnaBoardNum")int qnaBoardNum,
		@RequestParam(value="qnaBoardTitle")String qnaBoardTitle,
		@RequestParam(value="qnaBoardContent")String qnaBoardContent)
	
	{
		
		
		Board board = new Board(qnaBoardTitle,qnaBoardContent,qnaBoardNum);
		
		dao.edit(board);
	
		
		return "redirect:/board/ReadBoard/{qnaBoardNum}";
	}
	
	
}
