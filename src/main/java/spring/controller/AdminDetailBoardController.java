package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.dao.CommentDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Board;
import spring.vo.Comment;

@Controller
@RequestMapping("/admin")
public class AdminDetailBoardController {
		
		private BoardDao dao;
		private CommentDao commentDao;

		public void setDao(BoardDao dao) {
			this.dao = dao;
		}
		
		public void setCommentDao(CommentDao commentDao) {
			this.commentDao = commentDao;
		}


		@RequestMapping("/adminReadBoard/{qnaBoardNum}")
		public String ReadBoard(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
			
			Board board = dao.selectByqnaBoardNum(qnaBoardNum);
			Comment comment = commentDao.selectByqnaBoardNum(qnaBoardNum);
			
			
			if(board==null) {
				throw new MemberNotFoundException();
			}
			
			model.addAttribute("board", board);
			model.addAttribute("comment",comment);
			
			return "admin/adminReadBoard";
		}
	

}
