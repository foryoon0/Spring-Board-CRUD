package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.AuthService;
import spring.vo.LoginCommand;


@Controller
public class LoginController {
	
	private AuthService authService;
	

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String form(Model model) {  
		
		model.addAttribute("loginCommand",new LoginCommand());
		
		return "login/loginForm";
	}
	

	
}
