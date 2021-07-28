package com.vmaffioli.chatbot.io;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 
 * Parse HTML content and get data to fill a Word Object using JSOUP
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class HTMLParser {

	private List<String> formatedContent = new ArrayList<String>();
	
	public HTMLParser(Document content) {
		System.out.println(content.title());
		
		formatedContent.add(content.select(".title-header").select("h1").text());
		formatedContent.add(new FormatSimplifier(content.select(".title-header").select("h1").text()).getString());
		formatedContent.add(content.select(".cl").text());
	
		
		
		for(String txt : formatedContent) {
			System.out.println(txt);
		}
		
		//formatedContent.add(content);
	}

	public List<String> getFormatedContent() {
		return formatedContent;
	}
	
}
