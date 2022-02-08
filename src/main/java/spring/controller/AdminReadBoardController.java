package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.dao.CommentDao;
import spring.vo.Board;
import spring.vo.Comment;
import spring.vo.ListCommand;

@Controller
public class AdminReadBoardController {
	
	private BoardDao dao;
	private CommentDao commentDao;
	

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/adminmain/admin/adminBoard")
	public String list(@ModelAttribute("listCommand") ListCommand listCommand,Model model) {
	
		List<Comment> list2 = commentDao.selectCommentNum();
		List<Board> list = dao.selectAll();	
		
		model.addAttribute("Board",list);
		model.addAttribute("comment",list2);
		
		return "admin/adminBoard";
	}
}
	






