package com.vmaffioli.chatbot.pojo;

public class Word {

	private String name;
	private String fname;
	private String classes;
	private String syllables;//
	private String plural;//
	private String synonyms;
	private String antonyms;
	private String anagrams;
	private String meaning;

	public Word() {
		
	}
	

	/* GETTERS AND SETTERS */

	public String getName() {
		return name;
	}

	public void setName(String word) {
		this.name = word;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSyllables() {
		return syllables;
	}

	public void setSyllables(String syllables) {
		this.syllables = syllables;
	}

	public String getPlural() {
		return plural;
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getAntonyms() {
		return antonyms;
	}

	public void setAntonyms(String antonyms) {
		this.antonyms = antonyms;
	}

	public String getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(String anagrams) {
		this.anagrams = anagrams;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}




}
