package spring.vo;

public class AuthInfo { 

	private String memberId;
	private String memberName;
	private int memberNum;
	

	public AuthInfo(String memberId, String memberName, int memberNum) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberNum = memberNum;
	}

	public AuthInfo(String memberId, String memberName) {
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	
	
}
