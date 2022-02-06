package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

@Controller
@RequestMapping("/member")
public class ReadMemberController {
	
		private MemberDao memberDao;

		public void setMemberDao(MemberDao memberDao) {
			this.memberDao = memberDao;
		}
	
		@RequestMapping("/ReadMember/{memberName}")
		public String ReadBoard(@PathVariable("memberName") String memberName, Model model) {
			
			Member member = memberDao.selectByName(memberName);
			
			if(member==null) {
				throw new MemberNotFoundException();
			}
			
			model.addAttribute("member", member);
			
			return "member/ReadMember";
		}
	}
