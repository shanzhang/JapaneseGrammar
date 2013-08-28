package com.sanyu.jpgrammar.util;

public class StatusClass {

	private static final StatusClass statusClass = new StatusClass();

	private static String level;

	private StatusClass() {
	}

	public static StatusClass getStatusClass() {
		return statusClass;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String levelStr) {
		level = levelStr;
	}

}
