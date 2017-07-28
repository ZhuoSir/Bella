package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
/**
 * created by JeneralDB at 2017-07-28 09:39:11
 */
@Table("member_link_mem")
public class MemberLinkMem {

	@Column(value = "id", index = Column.index.PRIMARYKEY)
	private long id;

	@Column(value = "memberID")
	private long memberID;

	@Column(value = "followID")
	private long followID;

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

	public void setFollowID(long followID) {
		this.followID = followID;
	}

	public long getFollowID() {
		return followID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("id = ");
		string.append(this.id);
		string.append(";");
		string.append("memberID = ");
		string.append(this.memberID);
		string.append(";");
		string.append("followID = ");
		string.append(this.followID);
		string.append(";");
		return string.toString();
	}
}
