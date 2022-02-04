package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.MemberRegisterService;
import spring.vo.Login;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/join")
public class RegisterController {
	
	private MemberRegisterService  memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

		@RequestMapping(value="/join", method=RequestMethod.POST)
		public String form(@ModelAttribute Login logincommand) {

			
			return "member/join";
		}
		

	}
