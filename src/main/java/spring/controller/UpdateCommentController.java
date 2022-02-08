package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.CommentDao;
import spring.vo.Comment;

@Controller
public class UpdateCommentController {
		
	private CommentDao commentDao;

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}


	@RequestMapping(value="/updateComment/{qnaBoardNum}", method=RequestMethod.POST)
	public String editPost(
		
		@PathVariable("qnaBoardNum")int qnaBoardNum,
		@RequestParam(value="commentContent")String commentContent)
	{
		
		
		Comment comment = new Comment(commentContent,qnaBoardNum);
		
		commentDao.update(comment);
	
		
		return "redirect:/admin/adminReadBoard/{qnaBoardNum}";
	}
}
