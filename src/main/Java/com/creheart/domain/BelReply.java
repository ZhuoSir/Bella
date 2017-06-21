package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("bel_reply")
public class BelReply {

	@Column(value = "replyID", index = Column.index.PRIMARYKEY)
	private long replyID;

	@Column(value = "postID", index = Column.index.PRIMARYKEY)
	private long postID;

	@Column(value = "memberID")
	private long memberID;

	@Column("replyContent")
	private String replyContent;

	@Column("status")
	private int status;

	@Column("replyTime")
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
