package com.creheart.domain;

/**
 * created by JeneralDB at 2017-03-26 03:47:54
 */
public class Label {

	private long labelID;

	private String labelName;

	private String iconUrl;

	private String description;

	private long linkCount;

	public void setLabelID(long labelID) {
		this.labelID = labelID;
	}

	public long getLabelID() {
		return labelID;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setLinkCount(long linkCount) {
		this.linkCount = linkCount;
	}

	public long getLinkCount() {
		return linkCount;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("labelID = ");
		string.append(this.labelID);
		string.append(";");
		string.append("labelName = ");
		string.append(this.labelName);
		string.append(";");
		string.append("iconUrl = ");
		string.append(this.iconUrl);
		string.append(";");
		string.append("description = ");
		string.append(this.description);
		string.append(";");
		string.append("linkCount = ");
		string.append(this.linkCount);
		string.append(";");
		return string.toString();
	}
}
