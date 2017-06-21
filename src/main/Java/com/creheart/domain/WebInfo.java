package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
import java.util.Date;

/**
 * created by JeneralDB at 2017-06-21 10:26:47
 */
@Table("web_info")
public class WebInfo {

	@Column(value = "id", index = Column.index.PRIMARYKEY)
	private int id;

	@Column("webName")
	private String webName;

	@Column("version")
	private String version;

	@Column("descrption")
	private String descrption;

	@Column("logoPath")
	private String logoPath;

	@Column("startTime")
	private Date startTime;

	@Column("status")
	private int status;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getWebName() {
		return webName;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("id = ");
		string.append(this.id);
		string.append(";");
		string.append("webName = ");
		string.append(this.webName);
		string.append(";");
		string.append("version = ");
		string.append(this.version);
		string.append(";");
		string.append("descrption = ");
		string.append(this.descrption);
		string.append(";");
		string.append("logoPath = ");
		string.append(this.logoPath);
		string.append(";");
		string.append("startTime = ");
		string.append(this.startTime);
		string.append(";");
		string.append("status = ");
		string.append(this.status);
		string.append(";");
		return string.toString();
	}
}
