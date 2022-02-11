package spring.service;


import java.util.Date;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
	
private MemberDao memberDao; //= new MemberDao();  //사용할 객체 직접 생성
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		// 이미 가입된 계정이 있는가?
		Member member = memberDao.selectById1(req.getMemberId());
		
		if(member !=null) {
			throw new AlreadyExistingMemberException("이메일 중복 : "+req.getMemberId());
		}
		// 가입된 계정이 없다면 Member객체로 옮겨 담아서 
		Member newMember = new Member(req.getMemberId(),req.getMemberPassword(),req.getMemberName(),req.getMemberEmail(),req.getMemberPhone());
		
		memberDao.insert(newMember); //회원 가입 진행
		
	}
}
