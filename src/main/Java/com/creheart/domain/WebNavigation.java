package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-07-27 05:47:25
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

	@Column("orderNum")
	private int orderNum;

	@Column("url")
	private String url;

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

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
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
		string.append("orderNum = ");
		string.append(this.orderNum);
		string.append(";");
		string.append("url = ");
		string.append(this.url);
		string.append(";");
		return string.toString();
	}
}
