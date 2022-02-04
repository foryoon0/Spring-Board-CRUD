package spring.vo;

import java.util.Date;

public class Board {

	private int qnaBoardNum;
	private int memberNum;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;

	private String memberName;

	public Board() {
	}

	public Board(int qnaBoardNum, String qnaBoardTitle, String memberName, Date qnaBoardRegdate, int qnaBoardCount) {
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.memberName = memberName;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
	}

	public Board(String qnaBoardTitle, Date qnaBoardRegdate, String memberName, int qnaBoardCount,
			String qnaBoardContent) {

		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.memberName = memberName;
		this.qnaBoardCount = qnaBoardCount;
		this.qnaBoardContent = qnaBoardContent;
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

	public Date getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}

	public void setQnaBoardRegdate(Date qnaBoardRegdate) {
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
