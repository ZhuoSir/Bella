package com.creheart.domain;

import java.util.Date;

/**
 * created by JeneralDB at 2017-03-26 12:48:53
 */
public class PostRelateLabel {

	private long postID;

	private long labelID;

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
		string.append("postID = ");
		string.append(this.postID);
		string.append(";");
		string.append("labelID = ");
		string.append(this.labelID);
		string.append(";");
		return string.toString();
	}
}
