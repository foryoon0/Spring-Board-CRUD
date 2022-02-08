package spring.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;

@Controller
public class DeleteMemberController {
	
	private MemberDao memberDao;
	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}



	@RequestMapping(value="/admin/deleteMember/{memberNum}")
	public String deleteMember(@PathVariable("memberNum") int memberNum, Model model) throws IOException {
		
			memberDao.deleteMemberBymemberNum(memberNum);
	
		
		return "redirect:/adminmain/admin/memberlist";
	}
	
	

}
