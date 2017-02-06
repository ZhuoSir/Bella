package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-06 08:56:57
 */
public class Memberinfo {

	private long MemberID;

	private String IdentityCard;

	private int Sex;

	private String MemberProfile;

	private String MemberWebUrl;

	private Date MemberBirthDay;

	public void setMemberID(long MemberID) {
		this.MemberID = MemberID;
	}

	public long getMemberID() {
		return MemberID;
	}

	public void setIdentityCard(String IdentityCard) {
		this.IdentityCard = IdentityCard;
	}

	public String getIdentityCard() {
		return IdentityCard;
	}

	public void setSex(int Sex) {
		this.Sex = Sex;
	}

	public int getSex() {
		return Sex;
	}

	public void setMemberProfile(String MemberProfile) {
		this.MemberProfile = MemberProfile;
	}

	public String getMemberProfile() {
		return MemberProfile;
	}

	public void setMemberWebUrl(String MemberWebUrl) {
		this.MemberWebUrl = MemberWebUrl;
	}

	public String getMemberWebUrl() {
		return MemberWebUrl;
	}

	public void setMemberBirthDay(Date MemberBirthDay) {
		this.MemberBirthDay = MemberBirthDay;
	}

	public Date getMemberBirthDay() {
		return MemberBirthDay;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("MemberID = ");
		string.append(this.MemberID);
		string.append(";");
		string.append("IdentityCard = ");
		string.append(this.IdentityCard);
		string.append(";");
		string.append("Sex = ");
		string.append(this.Sex);
		string.append(";");
		string.append("MemberProfile = ");
		string.append(this.MemberProfile);
		string.append(";");
		string.append("MemberWebUrl = ");
		string.append(this.MemberWebUrl);
		string.append(";");
		string.append("MemberBirthDay = ");
		string.append(this.MemberBirthDay);
		string.append(";");
		return string.toString();
	}
}
