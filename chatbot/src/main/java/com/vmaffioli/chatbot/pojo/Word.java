package com.vmaffioli.chatbot.pojo;

public class Word {

	private String name;
	private String fname;
	private String syllables;
	private String classes;
	private String meaning;
	private String synonyms;
	private String antonyms;

	public Word() {
		
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSyllables() {
		return syllables;
	}
	
	public String[] getSyllablesList() {
		return syllables.split("·");
	}

	public void setSyllables(String syllables) {
		this.syllables = syllables;
	}

	public String getClasses() {
		return classes;
	}
	
	public String[] getClassesList() {
		return classes.split(" ");
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getMeaning() {
		return meaning;
	}
	
	public String[] getMeaningList() {
		return meaning.split("[0-9]+");
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getSynonyms() {
		return synonyms;
	}
	
	public String[] getSynonymsList() {
		return synonyms.split(" ");
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getAntonyms() {
		return antonyms;
	}
	
	public String[] getAntonymsList() {
		return antonyms.split(" ");
	}

	public void setAntonyms(String antonyms) {
		this.antonyms = antonyms;
	}


	

	




}
