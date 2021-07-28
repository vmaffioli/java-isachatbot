package com.vmaffioli.chatbot.io;

import java.text.Normalizer;

/**
 * 
 * Format rules: trim, lower case, normalize, replaceAll(regular expression) for accents and special chars;
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class FormatSimplifier {
	
	private String string;
	
	public FormatSimplifier(String input) {
		string = Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").trim().toLowerCase();
	}
		
	public String getString() {
		return string;
	}


}
