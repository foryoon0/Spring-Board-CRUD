package spring.vo;

import java.sql.Timestamp;

public class RegisterPostRequest {

	private int qnaBoardNum;
	private int memberNum;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	private Timestamp qnaBoardRegdate;
	private int qnaBoardCount;
	private String memberName;

	

	public RegisterPostRequest(int memberNum, String qnaBoardTitle, String qnaBoardContent) {
		super();
		this.memberNum = memberNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
	}


	public RegisterPostRequest(int memberNum, String qnaBoardTitle, String qnaBoardContent, String memberName) {
		this.memberNum = memberNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.memberName = memberName;
	}

	public RegisterPostRequest(String qnaBoardTitle, String qnaBoardContent, String memberName) {
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.memberName = memberName;
	}

	public RegisterPostRequest(String qnaBoardTitle, String qnaBoardContent) {
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
	}

	public RegisterPostRequest(int qnaBoardNum, String qnaBoardTitle, String qnaBoardContent, Timestamp qnaBoardRegdate,
			int qnaBoardCount) {
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
	}

	public int getQnaBoardNum() {
		return qnaBoardNum;
	}

	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}

	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}

	public String getQnaBoardContent() {
		return qnaBoardContent;
	}

	public void setQnaBoardContent(String qnaBoardContent) {
		this.qnaBoardContent = qnaBoardContent;
	}

	public Timestamp getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}

	public void setQnaBoardRegdate(Timestamp qnaBoardRegdate) {
		this.qnaBoardRegdate = qnaBoardRegdate;
	}

	public int getQnaBoardCount() {
		return qnaBoardCount;
	}

	public void setQnaBoardCount(int qnaBoardCount) {
		this.qnaBoardCount = qnaBoardCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
