package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.vo.Board;
import spring.vo.ListCommand;

@Controller
public class MainController {

	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/")
	public String list(@ModelAttribute("listCommand") ListCommand listCommand,Model model) {
		System.out.println("리스트실행");
		
		List<Board> list = dao.selectAll();	
		model.addAttribute("Board",list);
		return "main";
	}
}
	
