package spring.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class ListCommand {
	
	private Long memberId;
	private String memberPassword;
	private String memberName;
	

	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	

}
