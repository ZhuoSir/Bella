package com.creheart.bean;

/**
 * created by JeneralDB at 2017-02-05 08:13:23
 */
public class Pswvalidquestion {

	private int QuestionID;

	private String QuestionContent;

	private String QuestionAnswer;

	public void setQuestionID(int QuestionID) {
		this.QuestionID = QuestionID;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionContent(String QuestionContent) {
		this.QuestionContent = QuestionContent;
	}

	public String getQuestionContent() {
		return QuestionContent;
	}

	public void setQuestionAnswer(String QuestionAnswer) {
		this.QuestionAnswer = QuestionAnswer;
	}

	public String getQuestionAnswer() {
		return QuestionAnswer;
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("QuestionID = ");
		string.append(this.QuestionID);
		string.append(";");
		string.append("QuestionContent = ");
		string.append(this.QuestionContent);
		string.append(";");
		string.append("QuestionAnswer = ");
		string.append(this.QuestionAnswer);
		string.append(";");
		return string.toString();
	}
}
