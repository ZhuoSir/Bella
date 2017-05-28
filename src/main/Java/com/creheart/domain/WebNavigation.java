package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-05-27 06:27:43
 */
public class WebNavigation {

	private int id;

	private String title;

	private Date createTime;

	private int managerID;

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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getManagerID() {
		return managerID;
	}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
		string.append("createTime = ");
		string.append(this.createTime);
		string.append(";");
		string.append("managerID = ");
		string.append(this.managerID);
		string.append(";");
		return string.toString();
	}

	public WebNavigation() {}

	public WebNavigation(String title, int managerID, int status) {
		this.title = title;
		this.managerID = managerID;
		this.status = status;
	}
}
