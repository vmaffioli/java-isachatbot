package com.vmaffioli.chatbot.dao;

import com.vmaffioli.chatbot.pojo.Word;

public interface WordDAO {
	
	public Word pull(String word);
	public void push(Word word);
	public boolean ping(String word);
	public void fill(String word);
}
