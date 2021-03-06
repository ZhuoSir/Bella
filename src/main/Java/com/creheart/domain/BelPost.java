package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("bel_post")
public class BelPost {

	@Column(value = "postID", index = Column.index.PRIMARYKEY)
	private long postID;

	@Column("title")
	private String title;

	@Column(value = "authorID")
	private long authorID;

	@Column("content")
	private String content;

	@Column("readTimes")
	private int readTimes;

	@Column("replyTimes")
	private int replyTimes;

	@Column("status")
	private int status;

	@Column(value = "lastReplyMemberID")
	private long lastReplyMemberID;

	@Column("createTime")
	private Date createTime;

	@Column("lastReplyTime")
	private Date lastReplyTime;

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getPostID() {
		return postID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}

	public long getAuthorID() {
		return authorID;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setReadTimes(int readTimes) {
		this.readTimes = readTimes;
	}

	public int getReadTimes() {
		return readTimes;
	}

	public void setReplyTimes(int replyTimes) {
		this.replyTimes = replyTimes;
	}

	public int getReplyTimes() {
		return replyTimes;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setLastReplyMemberID(long lastReplyMemberID) {
		this.lastReplyMemberID = lastReplyMemberID;
	}

	public long getLastReplyMemberID() {
		return lastReplyMemberID;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setLastReplyTime(Date lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	public Date getLastReplyTime() {
		return lastReplyTime;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("postID = ");
		string.append(this.postID);
		string.append(";");
		string.append("title = ");
		string.append(this.title);
		string.append(";");
		string.append("authorID = ");
		string.append(this.authorID);
		string.append(";");
		string.append("content = ");
		string.append(this.content);
		string.append(";");
		string.append("readTimes = ");
		string.append(this.readTimes);
		string.append(";");
		string.append("replyTimes = ");
		string.append(this.replyTimes);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		string.append("lastReplyMemberID = ");
		string.append(this.lastReplyMemberID);
		string.append(";");
		string.append("createTime = ");
		string.append(this.createTime);
		string.append(";");
		string.append("lastReplyTime = ");
		string.append(this.lastReplyTime);
		string.append(";");
		return string.toString();
	}
}
