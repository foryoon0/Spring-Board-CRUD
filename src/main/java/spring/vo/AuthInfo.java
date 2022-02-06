package spring.vo;

public class AuthInfo { 

	private String memberId;
	private String memberName;
	
	public AuthInfo(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	
	
}
