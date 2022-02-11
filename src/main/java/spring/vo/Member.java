package spring.vo;

import java.sql.Timestamp;

public class Member {
	
	private int memberNum;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	

	public Member(String memberId) {
			this.memberId = memberId;
	}

	public Member(String memberId, String memberPassword, String memberName, int memberNum, String memberEmail) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}

	public Member(int memberNum) {
		this.memberNum = memberNum;
	}

	public Member(String memberId, String memberName, String memberEmail, String memberPhone, int memberNum) {

		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}

	public Member(int memberNum, String memberId, String memberPassword, String memberName, String memberEmail,
			String memberPhone) {
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}

	public Member(int memberNum, String memberPassword, String memberName, String memberEmail, String memberPhone) {

		this.memberNum = memberNum;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}
	
	public Member(String memberPassword, String memberName, String memberEmail, String memberPhone) {
		super();
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}
	public Member(String memberId, String memberPassword, String memberName, String memberEmail,
			String memberPhone) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}
	public Member(String memberEmail, String memberPassword, String memberName) {
		
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}
	
	
	public Member(int memberNum, String memberId, String memberName) {
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberName = memberName;
	}



	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
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
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

}
