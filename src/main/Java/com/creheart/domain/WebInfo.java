package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-05-27 06:27:43
 */
public class WebInfo {

    public final String tableName = "web_info";

    private int id;

	private String webName;

	private Date startTime;

	private String description;

	private String logoPath;

	private String version;

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getWebName() {
		return webName;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getLogoPath() {
		return logoPath;
	}

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("webName = ");
		string.append(this.webName);
		string.append(";");
		string.append("startTime = ");
		string.append(this.startTime);
		string.append(";");
		string.append("description = ");
		string.append(this.description);
		string.append(";");
		string.append("logoPath = ");
		string.append(this.logoPath);
		string.append(";");
		return string.toString();
	}
}
