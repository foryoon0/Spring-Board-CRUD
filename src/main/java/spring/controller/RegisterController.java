package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.validator.RegisterRequestValidator;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/member")
public class RegisterController {
	
private MemberRegisterService memberRegisterService;

	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="/join")
	public String regist(Model model) {
			
		model.addAttribute("formData",new RegisterRequest());
		
		return "member/join";
		
	}
	
	@RequestMapping(value="/joining", method=RequestMethod.POST)
	public String joining(@ModelAttribute("formData")RegisterRequest regReq,Errors errors) {
		// 넘어온 커맨드 객체를 검증해야 한다.
		new RegisterRequestValidator().validate(regReq, errors);
		
		if(errors.hasErrors()) {  // 에러가 하나라도 발견이 되었다면
			return "member/join";
		}
		try {
			// MemberRegisterService객체 안에 메서드 호출 =>의존 주입
			memberRegisterService.regist(regReq);
			return "redirect:/";
		
		}catch(AlreadyExistingMemberException e) {
			// 이미 회원이 존재하는 상태 =>  에러 
			errors.rejectValue("memberId", "duplicate");
			return "member/join";
		}

	}

}
