package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

@Controller
@RequestMapping("/admin")
public class AdminReadMemberController {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("/editadmin/{memberNum}")
	public String editadmin(
			
			@PathVariable("memberNum") int memberNum, Model model) {
		
		Member member = memberDao.selectByNum(memberNum);
		
		if(member==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("member", member);
		
		return "admin/editadmin";
	}
}
