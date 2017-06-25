package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
/**
 * created by JeneralDB at 2017-06-21 10:26:46
 */
@Table("bel_label")
public class BelLabel {

	@Column(value = "labelID", index = Column.index.PRIMARYKEY)
	private long labelID;

	@Column("labelName")
	private String labelName;

	@Column("iconUrl")
	private String iconUrl;

	@Column("description")
	private String description;

	@Column("linkCount")
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

	public BelLabel() {
	}

	public BelLabel(String labelName, String iconUrl, String description) {
		this.labelName = labelName;
		this.iconUrl = iconUrl;
		this.description = description;
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
