package spring.vo;

import java.sql.Timestamp;

public class Comment {
	
	private int commentNum;
	private int qnaBoardNum;
	private String commentContent;
	private Timestamp commentRegdate;
	
	
	

	public Comment(int commentNum, int qnaBoardNum, String commentContent, Timestamp commentRegdate) {
		this.commentNum = commentNum;
		this.qnaBoardNum = qnaBoardNum;
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
	}
	
	

	public Comment(String commentContent,int qnaBoardNum) {
		super();
		this.qnaBoardNum = qnaBoardNum;
		this.commentContent = commentContent;
	}


	public Comment(String commentContent, Timestamp commentRegdate, int commentNum) {
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
		this.commentNum = commentNum;
	}


	public Comment(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}

	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentRegdate() {
		return commentRegdate;
	}
	public void setCommentRegdate(Timestamp commentRegdate) {
		this.commentRegdate = commentRegdate;
	}

	
	
	
}
