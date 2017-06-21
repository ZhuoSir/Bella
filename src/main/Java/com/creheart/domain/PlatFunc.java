package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("plat_func")
public class PlatFunc {

	@Column(value = "funcid", index = Column.index.PRIMARYKEY)
	private long funcid;

	@Column("funcName")
	private String funcName;

	@Column("funcIcon")
	private String funcIcon;

	@Column("funcUrl")
	private String funcUrl;

	@Column("parentFuncID")
	private int parentFuncID;

	@Column("orderNum")
	private int orderNum;

	@Column("levelNum")
	private int levelNum;

	@Column("menuFlag")
	private int menuFlag;

	@Column("remark")
	private String remark;

	@Column("description")
	private String description;

	@Column("addTime")
	private Date addTime;

	@Column("status")
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
