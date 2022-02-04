package spring.vo;

public class Login {
	
	private Long memberId;
	private String memberPassword;
	private String memberName;
	
		
	public Login(Long memberId, String memberPassword, String memberName) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}
	
	
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
