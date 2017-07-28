package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
/**
 * created by JeneralDB at 2017-07-28 09:28:40
 */
@Table("member_link_post")
public class MemberLinkPost {

	@Column(value = "id", index = Column.index.PRIMARYKEY)
	private long id;

	@Column(value = "memberID")
	private long memberID;

	@Column(value = "postID")
	private long postID;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public long getMemberID() {
		return memberID;
	}

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getPostID() {
		return postID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("id = ");
		string.append(this.id);
		string.append(";");
		string.append("memberID = ");
		string.append(this.memberID);
		string.append(";");
		string.append("postID = ");
		string.append(this.postID);
		string.append(";");
		return string.toString();
	}
}
