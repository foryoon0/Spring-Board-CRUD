package spring.service;


import spring.dao.MemberDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.AuthInfo;
import spring.vo.Member;

public class AuthService { 
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String memberId, String memberPassword) {
		Member member = memberDao.selectById(memberId);
		
		if(member==null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!member.getMemberPassword().equals(memberPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		
		return new AuthInfo(member.getMemberId(),member.getMemberEmail(),member.getMemberName());
	}



}
