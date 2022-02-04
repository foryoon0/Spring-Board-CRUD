package spring.vo;

public class AuthInfo { 

	private String memberId;
	private String memberEmail;
	private String memberName;
	
	public AuthInfo(String memberId, String memberEmail, String memberName) {
		this.memberId = memberId;
		this.memberEmail = memberEmail;
		this.memberName = memberName;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
