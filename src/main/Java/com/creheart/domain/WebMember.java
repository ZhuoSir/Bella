package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:47
 */
@Table("web_member")
public class WebMember {

	@Column(value = "webMemberID", index = Column.index.PRIMARYKEY)
	private long webMemberID;

	@Column("tempVerifyMsisdn")
	private String tempVerifyMsisdn;

	@Column("tempVerifyCode")
	private String tempVerifyCode;

	@Column(value = "memberUserID")
	private long memberUserID;

	@Column("addTime")
	private Date addTime;

	@Column("tempVerifyTime")
	private Date tempVerifyTime;

	public void setWebMemberID(long webMemberID) {
		this.webMemberID = webMemberID;
	}

	public long getWebMemberID() {
		return webMemberID;
	}

	public void setTempVerifyMsisdn(String tempVerifyMsisdn) {
		this.tempVerifyMsisdn = tempVerifyMsisdn;
	}

	public String getTempVerifyMsisdn() {
		return tempVerifyMsisdn;
	}

	public void setTempVerifyCode(String tempVerifyCode) {
		this.tempVerifyCode = tempVerifyCode;
	}

	public String getTempVerifyCode() {
		return tempVerifyCode;
	}

	public void setMemberUserID(long memberUserID) {
		this.memberUserID = memberUserID;
	}

	public long getMemberUserID() {
		return memberUserID;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setTempVerifyTime(Date tempVerifyTime) {
		this.tempVerifyTime = tempVerifyTime;
	}

	public Date getTempVerifyTime() {
		return tempVerifyTime;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("webMemberID = ");
		string.append(this.webMemberID);
		string.append(";");
		string.append("tempVerifyMsisdn = ");
		string.append(this.tempVerifyMsisdn);
		string.append(";");
		string.append("tempVerifyCode = ");
		string.append(this.tempVerifyCode);
		string.append(";");
		string.append("memberUserID = ");
		string.append(this.memberUserID);
		string.append(";");
		string.append("addTime = ");
		string.append(this.addTime);
		string.append(";");
		string.append("tempVerifyTime = ");
		string.append(this.tempVerifyTime);
		string.append(";");
		return string.toString();
	}
}
