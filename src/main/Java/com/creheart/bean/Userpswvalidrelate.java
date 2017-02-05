package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-05 08:13:23
 */
public class Userpswvalidrelate {

	private long userID;

	private int QuestionID;

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getUserID() {
		return userID;
	}

	public void setQuestionID(int QuestionID) {
		this.QuestionID = QuestionID;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("userID = ");
		string.append(this.userID);
		string.append(";");
		string.append("QuestionID = ");
		string.append(this.QuestionID);
		string.append(";");
		return string.toString();
	}
}
