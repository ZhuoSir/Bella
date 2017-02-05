package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-05 08:13:23
 */
public class Userinfo {

	private long userID;

	private String identityCard;

	private int sex;

	private String userProfile;

	private String userWebUrl;

	private Date userBirthDay;

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getUserID() {
		return userID;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserWebUrl(String userWebUrl) {
		this.userWebUrl = userWebUrl;
	}

	public String getUserWebUrl() {
		return userWebUrl;
	}

	public void setUserBirthDay(Date userBirthDay) {
		this.userBirthDay = userBirthDay;
	}

	public Date getUserBirthDay() {
		return userBirthDay;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("userID = ");
		string.append(this.userID);
		string.append(";");
		string.append("identityCard = ");
		string.append(this.identityCard);
		string.append(";");
		string.append("sex = ");
		string.append(this.sex);
		string.append(";");
		string.append("userProfile = ");
		string.append(this.userProfile);
		string.append(";");
		string.append("userWebUrl = ");
		string.append(this.userWebUrl);
		string.append(";");
		string.append("userBirthDay = ");
		string.append(this.userBirthDay);
		string.append(";");
		return string.toString();
	}
}
