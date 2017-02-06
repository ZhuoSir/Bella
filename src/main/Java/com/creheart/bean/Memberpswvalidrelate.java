package com.creheart.bean;

import java.util.Date;

/**
 * created by JeneralDB at 2017-02-06 08:56:57
 */
public class Memberpswvalidrelate {

	private long MemberID;

	private int QuestionID;

	public void setMemberID(long MemberID) {
		this.MemberID = MemberID;
	}

	public long getMemberID() {
		return MemberID;
	}

	public void setQuestionID(int QuestionID) {
		this.QuestionID = QuestionID;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("MemberID = ");
		string.append(this.MemberID);
		string.append(";");
		string.append("QuestionID = ");
		string.append(this.QuestionID);
		string.append(";");
		return string.toString();
	}
}
