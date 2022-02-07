package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.vo.ListCommand;
import spring.vo.Member;

@Controller
public class MemberListController {
	
	private MemberDao memberdao;

	public void setMemberDao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	@RequestMapping("/adminmain/admin/memberlist")
	public String list(@ModelAttribute("listCommand") ListCommand listCommand,Model model) {
	
		
		List<Member> list = memberdao.selectAll();	
		model.addAttribute("Member",list);
		return "admin/memberlist";
	}
}
