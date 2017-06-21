package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("member_info")
public class MemberInfo {

	@Column(value = "MemberID", index = Column.index.PRIMARYKEY)
	private long MemberID;

	@Column(value = "IdentityCard", index = Column.index.PRIMARYKEY)
	private String IdentityCard;

	@Column("Sex")
	private int Sex;

	@Column("MemberProfile")
	private String MemberProfile;

	@Column("MemberWebUrl")
	private String MemberWebUrl;

	@Column("MemberBirthDay")
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
