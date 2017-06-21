package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("member")
public class Member {

	@Column(value = "ID", index = Column.index.PRIMARYKEY)
	private long ID;

	@Column(value = "accountID", index = Column.index.PRIMARYKEY)
	private String accountID;

	@Column(value = "accountName", index = Column.index.PRIMARYKEY)
	private String accountName;

	@Column("password")
	private String password;

	@Column(value = "email", index = Column.index.PRIMARYKEY)
	private String email;

	@Column("addTime")
	private Date addTime;

	@Column("status")
	private int status;

	@Column("headPicFileURL")
	private String headPicFileURL;

	@Column("mobilePhone")
	private String mobilePhone;

	@Column("nickName")
	private String nickName;

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		return ID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setHeadPicFileURL(String headPicFileURL) {
		this.headPicFileURL = headPicFileURL;
	}

	public String getHeadPicFileURL() {
		return headPicFileURL;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("ID = ");
		string.append(this.ID);
		string.append(";");
		string.append("accountID = ");
		string.append(this.accountID);
		string.append(";");
		string.append("accountName = ");
		string.append(this.accountName);
		string.append(";");
		string.append("password = ");
		string.append(this.password);
		string.append(";");
		string.append("email = ");
		string.append(this.email);
		string.append(";");
		string.append("addTime = ");
		string.append(this.addTime);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		string.append("headPicFileURL = ");
		string.append(this.headPicFileURL);
		string.append(";");
		string.append("mobilePhone = ");
		string.append(this.mobilePhone);
		string.append(";");
		string.append("nickName = ");
		string.append(this.nickName);
		string.append(";");
		return string.toString();
	}
}
