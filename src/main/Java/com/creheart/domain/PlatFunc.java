package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-03-07 09:15:40
 */
public class PlatFunc {

	private long funcid;

	private String funcName;

	private String funcIcon;

	private String funcUrl;

	private int parentFuncID;

	private int orderNum;

	private int levelNum;

	private int menuFlag;

	private String remark;

	private String description;

	private Date addTime;

	private int status;

	public void setFuncid(long funcid) {
		this.funcid = funcid;
	}

	public long getFuncid() {
		return funcid;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncIcon(String funcIcon) {
		this.funcIcon = funcIcon;
	}

	public String getFuncIcon() {
		return funcIcon;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setParentFuncID(int parentFuncID) {
		this.parentFuncID = parentFuncID;
	}

	public int getParentFuncID() {
		return parentFuncID;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public void setMenuFlag(int menuFlag) {
		this.menuFlag = menuFlag;
	}

	public int getMenuFlag() {
		return menuFlag;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
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

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("funcid = ");
		string.append(this.funcid);
		string.append(";");
		string.append("funcName = ");
		string.append(this.funcName);
		string.append(";");
		string.append("funcIcon = ");
		string.append(this.funcIcon);
		string.append(";");
		string.append("funcUrl = ");
		string.append(this.funcUrl);
		string.append(";");
		string.append("parentFuncID = ");
		string.append(this.parentFuncID);
		string.append(";");
		string.append("orderNum = ");
		string.append(this.orderNum);
		string.append(";");
		string.append("levelNum = ");
		string.append(this.levelNum);
		string.append(";");
		string.append("menuFlag = ");
		string.append(this.menuFlag);
		string.append(";");
		string.append("remark = ");
		string.append(this.remark);
		string.append(";");
		string.append("description = ");
		string.append(this.description);
		string.append(";");
		string.append("addTime = ");
		string.append(this.addTime);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		return string.toString();
	}
}
