package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-03-26 09:13:44
 */
public class MemberLinkLabel {

	private long RID;

	private long memberID;

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
