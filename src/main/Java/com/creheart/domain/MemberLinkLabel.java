package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("member_link_label")
public class MemberLinkLabel {

	@Column(value = "RID", index = Column.index.PRIMARYKEY)
	private long RID;

	@Column(value = "memberID")
	private long memberID;

	@Column(value = "labelID")
	private long labelID;

	public void setRID(long RID) {
		this.RID = RID;
	}

	public long getRID() {
		return RID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public long getMemberID() {
		return memberID;
	}

	public void setLabelID(long labelID) {
		this.labelID = labelID;
	}

	public long getLabelID() {
		return labelID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("RID = ");
		string.append(this.RID);
		string.append(";");
		string.append("memberID = ");
		string.append(this.memberID);
		string.append(";");
		string.append("labelID = ");
		string.append(this.labelID);
		string.append(";");
		return string.toString();
	}
}
