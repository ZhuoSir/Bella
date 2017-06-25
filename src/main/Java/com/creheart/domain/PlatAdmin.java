package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("plat_admin")
public class PlatAdmin {

	@Column(value = "ID", index = Column.index.PRIMARYKEY)
	private int ID;

	@Column("adminName")
	private String adminName;

	@Column("password")
	private String password;

	@Column("adminType")
	private int adminType;

	@Column("status")
	private int status;

	@Column("creatorID")
	private int creatorID;

	@Column("addTime")
	private Date addTime;

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}

	public int getCreatorID() {
		return creatorID;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public PlatAdmin() {
	}

	public PlatAdmin(String adminName, String password, int adminType, int status, int creatorID) {
		this.adminName = adminName;
		this.password = password;
		this.adminType = adminType;
		this.status = status;
		this.creatorID = creatorID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("ID = ");
		string.append(this.ID);
		string.append(";");
		string.append("adminName = ");
		string.append(this.adminName);
		string.append(";");
		string.append("password = ");
		string.append(this.password);
		string.append(";");
		string.append("adminType = ");
		string.append(this.adminType);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		string.append("creatorID = ");
		string.append(this.creatorID);
		string.append(";");
		string.append("addTime = ");
		string.append(this.addTime);
		string.append(";");
		return string.toString();
	}
}
