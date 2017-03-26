package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-03-26 12:48:53
 */
public class Post {

	private long postID;

	private String title;

	private long authorID;

	private Date createTime;

	private String content;

	private int readTimes;

	private int replyTimes;

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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
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
		string.append("createTime = ");
		string.append(this.createTime);
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
		return string.toString();
	}
}
