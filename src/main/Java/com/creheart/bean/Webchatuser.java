package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-05 08:13:23
 */
public class Webchatuser {

	private int wxChatUserID;

	private String tempVerifyMsisdn;

	private String tempVerifyCode;

	private int memberUserID;

	private Date addTime;

	private Date tempVerifyTime;

	public void setWxChatUserID(int wxChatUserID) {
		this.wxChatUserID = wxChatUserID;
	}

	public int getWxChatUserID() {
		return wxChatUserID;
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

	public void setMemberUserID(int memberUserID) {
		this.memberUserID = memberUserID;
	}

	public int getMemberUserID() {
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
		string.append("wxChatUserID = ");
		string.append(this.wxChatUserID);
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
