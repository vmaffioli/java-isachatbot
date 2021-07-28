package com.vmaffioli.chatbot.pojo;

import java.util.ArrayList;
import java.util.List;

public class Phrase {

	private List<Word> phrase = new ArrayList<>();
	
	public Phrase() {		
	}

	public List<Word> getPhrase() {
		return phrase;
	}

	public void addWord(Word word) {
		this.phrase.add(word);
	}
	

}
