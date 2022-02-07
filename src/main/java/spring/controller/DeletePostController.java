package spring.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;

@Controller
public class DeletePostController {

	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
		
	@RequestMapping(value="/board/deletePost/{qnaBoardNum}")
	public String deletePost(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) throws IOException {
		
			dao.deletePostByCode(qnaBoardNum);
	
		
		return "redirect:/";
	}
	
	
}