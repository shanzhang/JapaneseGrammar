package com.sanyu.jpgrammar.domain;

public class GrammarDetail extends GrammarTitle {

	private String examText;

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getExamText() {
		return examText;
	}

	public void setExamText(String examText) {
		this.examText = examText;
	}

}
