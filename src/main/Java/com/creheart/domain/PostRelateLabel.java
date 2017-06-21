package com.creheart.domain;

import com.chen.JeneralDB.annotation.Column;
import com.chen.JeneralDB.annotation.Table;
/**
 * created by JeneralDB at 2017-06-21 10:26:47
 */
@Table("post_relate_label")
public class PostRelateLabel {

	@Column(value = "rid", index = Column.index.PRIMARYKEY)
	private int rid;

	@Column(value = "postID")
	private long postID;

	@Column(value = "labelID")
	private long labelID;

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRid() {
		return rid;
	}

	public void setPostID(long postID) {
		this.postID = postID;
	}

	public long getPostID() {
		return postID;
	}

	public void setLabelID(long labelID) {
		this.labelID = labelID;
	}

	public long getLabelID() {
		return labelID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("rid = ");
		string.append(this.rid);
		string.append(";");
		string.append("postID = ");
		string.append(this.postID);
		string.append(";");
		string.append("labelID = ");
		string.append(this.labelID);
		string.append(";");
		return string.toString();
	}
}
