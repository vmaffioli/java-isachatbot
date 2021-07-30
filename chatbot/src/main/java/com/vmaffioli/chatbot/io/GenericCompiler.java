package com.vmaffioli.chatbot.io;


import com.vmaffioli.chatbot.dao.WordDAOImpl;
import com.vmaffioli.chatbot.pojo.Phrase;
import com.vmaffioli.chatbot.pojo.Word;

/**
 * 
 * Compile string to word (chatbot input format)
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class GenericCompiler {

	private Word word = null;

	public GenericCompiler() {
	}

	
	public Word StringToWord(String input) {
		
		if(new WordDAOImpl().ping(input.trim())) {
			word = new WordDAOImpl().pull(input.trim());
		} else {
			word = new WordDAOImpl().fill(input.trim());
			//word = new WordDAOImpl().pull(input.trim());
		}
		
		return word; 
	}


}