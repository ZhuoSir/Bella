package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-03-27 08:44:56
 */
public class BelReply {

	private long replyID;

	private long postID;

	private long memberID;

	private String replyContent;

	private int status;

	private Date replyTime;

	public void setReplyID(long replyID) {
		this.replyID = replyID;
	}

	public long getReplyID() {
		return replyID;
	}

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getPostID() {
		return postID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public long getMemberID() {
		return memberID;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("replyID = ");
		string.append(this.replyID);
		string.append(";");
		string.append("postID = ");
		string.append(this.postID);
		string.append(";");
		string.append("memberID = ");
		string.append(this.memberID);
		string.append(";");
		string.append("replyContent = ");
		string.append(this.replyContent);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		string.append("replyTime = ");
		string.append(this.replyTime);
		string.append(";");
		return string.toString();
	}
}
