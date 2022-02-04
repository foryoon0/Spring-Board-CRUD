package spring.service;


import spring.dao.MemberDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.AuthInfo;
import spring.vo.Member;

public class AuthService { 
	
	private MemberDao memberDao;

	public AuthService(MemberDao MemberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		
		if(member==null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!member.getMemberPassword().equals(password)) {
			throw new IdPasswordNotMatchingException();
		}
		
		return new AuthInfo(member.getMemberId(),member.getMemberEmail(),member.getMemberName());
	}



}
