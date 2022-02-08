package spring.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.dao.CommentDao;


@Controller
public class AdminDeleteCommentController {
		
		private BoardDao dao;
	
		public void setDao(BoardDao dao) {
			this.dao = dao;
		}
			
		@RequestMapping(value="/admin/adminDeletePost/{qnaBoardNum}")
		public String deletePost(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) throws IOException {
			
				dao.deletePostByCode(qnaBoardNum);
		
			
			return "redirect:/adminmain/admin/adminBoard";
		}
	
	
}
	
	
