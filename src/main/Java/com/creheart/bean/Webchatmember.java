package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-06 08:56:57
 */
public class Webchatmember {

	private int wxChatMemberID;

	private String tempVerifyMsisdn;

	private String tempVerifyCode;

	private int MemberID;

	private Date addTime;

	private Date tempVerifyTime;

	public void setWxChatMemberID(int wxChatMemberID) {
		this.wxChatMemberID = wxChatMemberID;
	}

	public int getWxChatMemberID() {
		return wxChatMemberID;
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

	public void setMemberID(int MemberID) {
		this.MemberID = MemberID;
	}

	public int getMemberID() {
		return MemberID;
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
		string.append("wxChatMemberID = ");
		string.append(this.wxChatMemberID);
		string.append(";");
		string.append("tempVerifyMsisdn = ");
		string.append(this.tempVerifyMsisdn);
		string.append(";");
		string.append("tempVerifyCode = ");
		string.append(this.tempVerifyCode);
		string.append(";");
		string.append("MemberID = ");
		string.append(this.MemberID);
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
