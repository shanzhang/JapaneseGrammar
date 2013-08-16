package com.sanyu.japanesegrammar.domain;

import java.util.ArrayList;

public class GrammarDetail extends GrammarTitle {

	private String conjunction;

	private ArrayList<String> usage;

	private ArrayList<String> translation;

	private ArrayList<String> example;
	
	private ArrayList<String> exTranslation; 

	public ArrayList<String> getExTranslation() {
		return exTranslation;
	}

	public void setExTranslation(ArrayList<String> exTranslation) {
		this.exTranslation = exTranslation;
	}

	public String getConjunctionMethod() {
		return conjunction;
	}

	public void setConjunctionMethod(String conjunctionMethod) {
		this.conjunction = conjunctionMethod;
	}

	public ArrayList<String> getUsage() {
		return usage;
	}

	public void setUsage(ArrayList<String> usage) {
		this.usage = usage;
	}

	public ArrayList<String> getTranslation() {
		return translation;
	}

	public void setTranslation(ArrayList<String> translation) {
		this.translation = translation;
	}

	public ArrayList<String> getExample() {
		return example;
	}

	public void setExample(ArrayList<String> example) {
		this.example = example;
	}

}
