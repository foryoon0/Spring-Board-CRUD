package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDao;
import spring.service.PostRegisterService;
import spring.vo.Board;
import spring.vo.RegisterPostRequest;


@Controller
@RequestMapping("/board")
public class RegisterPostController {

	
	private PostRegisterService postRegisterService;

	public void setPostRegisterService(PostRegisterService postRegisterService) {
		this.postRegisterService =  postRegisterService;
	}
	
	@RequestMapping(value="/WriteBoard")
	public String WriteBoard() {
		
		return "board/WriteBoard"; 
			
	}
	
	@RequestMapping(value="/writing", method=RequestMethod.POST)
	public String writing(
			@RequestParam(value="memberNum")int memberNum,
			@RequestParam(value="qnaBoardTitle")String qnaBoardTitle,
			@RequestParam(value="qnaBoardContent")String qnaBoardContent) {
			
		System.out.println("memberNum: " + memberNum );
		System.out.println("qnaBoardTitle: " + qnaBoardTitle );
		System.out.println("qnaBoardContent: " + qnaBoardContent );
		

		RegisterPostRequest preq = new RegisterPostRequest(memberNum,qnaBoardTitle,qnaBoardContent);
		postRegisterService.pregist(preq);
		
		return "redirect:/";
	}
}
