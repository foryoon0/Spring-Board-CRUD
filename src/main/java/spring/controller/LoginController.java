package spring.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.AuthService;
import spring.vo.AuthInfo;
import spring.vo.LoginCommand;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(value="/loginForm",method=RequestMethod.GET)
	public String form(Model model) {  
		
		model.addAttribute("loginCommand",new LoginCommand());
		
		return "login/loginForm";
	}
	
	@RequestMapping(value="/loginForm",method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) { // 폼에서 로그인 기능을 요청

		// 2. 입력 받은 이메일과 비밀번호로 로그인 (서비스 객체)시도
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getMemberId(), loginCommand.getMemberPassword());
			
			// 로그인 정보를 기록할 세션 코드
			session.setAttribute("authInfo", authInfo);
			
		}catch(IdPasswordNotMatchingException e) {
			//아이디가 없거나, 비밀번호가 틀린경우
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
		return "redirect:/";
	}
	

	
}

