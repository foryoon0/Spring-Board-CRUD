package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDao;
import spring.dao.MemberDao;
import spring.vo.Board;
import spring.vo.Member;

@Controller
public class UpdateMemberUpdate {
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
		
	@RequestMapping(value="/editMember/{memberNum}", method=RequestMethod.POST)
	public String editMember(
		
		@PathVariable("memberNum")int memberNum,
		@RequestParam(value="memberId")String memberId,
		@RequestParam(value="memberName")String memberName,
		@RequestParam(value="memberEmail")String memberEmail,
		@RequestParam(value="memberPhone")String memberPhone)
	
	{
		
		
		Member member = new Member(memberId,memberName,memberEmail,memberPhone,memberNum);
		
		memberDao.edit(member);
	
		
		return "redirect:/admin/editadmin/{memberNum}";
	}
}
