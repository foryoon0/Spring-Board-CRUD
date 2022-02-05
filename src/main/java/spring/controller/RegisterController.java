package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/member")
public class RegisterController {
	
private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="/join")
	public String regist() {
		
		return "member/join";
		
	}
	
	@RequestMapping(value="/joining", method=RequestMethod.POST)
	public String joining(
			@RequestParam(value="memberId")String memberId,
			@RequestParam(value="memberEmail")String memberEmail,
			@RequestParam(value="memberName")String memberName,
			@RequestParam(value="memberPassword")String memberPassword,
			@RequestParam(value="rePassword")String rePassword,
			@RequestParam(value="memberPhone")String memberPhone) {
		RegisterRequest req = new RegisterRequest(memberId,memberPassword,memberName,memberEmail,memberPhone);
		memberRegisterService.regist(req);
		
		return "redirect:/";
	}

	}
