package com.creheart.domain;

/**
 * created by JeneralDB at 2017-03-26 03:47:54
 */
public class PostRelateLabel {

	private int rid;

	private long postID;

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
