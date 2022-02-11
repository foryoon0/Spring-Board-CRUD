package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String list(@ModelAttribute("listCommand") ListCommand listCommand,Model model, HttpServletRequest request, HttpServletResponse response) {
	

		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		int section = Integer.parseInt((_section==null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum==null)?"1":_pageNum);
		
		int totalCnt = dao.selectAllNumBoard();
		List<Board> boardList = dao.selectTargetBoard(section, pageNum);
		
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardList", boardList);

		model.addAttribute("Board",boardList);
		return "main";
		
		}
	}

