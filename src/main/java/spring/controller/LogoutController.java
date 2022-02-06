package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //技记俊 历厘等 葛电 单捞磐甫 力芭
		
		return "redirect:/";
	}

}
