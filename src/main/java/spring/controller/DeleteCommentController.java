package spring.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.CommentDao;


@Controller
public class DeleteCommentController {

	
private CommentDao commentDao;
	

		public void setCommentDao(CommentDao commentDao) {
			this.commentDao = commentDao;
			}		



	@RequestMapping(value="/admin/adminDeleteComment/{qnaBoardNum}")
	public String deletePost(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) throws IOException {
		
			commentDao.deletePostByqnaBoardNum(qnaBoardNum);
	
		
		return "redirect:/admin/adminReadBoard/{qnaBoardNum}";

	}
	
	
	
	
}
