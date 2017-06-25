package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:47
 */
@Table("web_navigation")
public class WebNavigation {

	@Column(value = "id", index = Column.index.PRIMARYKEY)
	private int id;

	@Column("title")
	private String title;

	@Column(value = "managerID")
	private int managerID;

	@Column("createTime")
	private Date createTime;

	@Column("status")
	private int status;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

    public WebNavigation() {
    }

    public WebNavigation(String title, int managerID, int status) {
        this.title = title;
        this.managerID = managerID;
        this.status = status;
    }

    public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("id = ");
		string.append(this.id);
		string.append(";");
		string.append("title = ");
		string.append(this.title);
		string.append(";");
		string.append("managerID = ");
		string.append(this.managerID);
		string.append(";");
		string.append("createTime = ");
		string.append(this.createTime);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		return string.toString();
	}
}
