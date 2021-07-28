package com.vmaffioli.chatbot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.nodes.Document;

import com.vmaffioli.chatbot.io.FormatSimplifier;
import com.vmaffioli.chatbot.io.HTMLParser;
import com.vmaffioli.chatbot.pojo.Word;
import com.vmaffioli.model.DatabaseConnection;
import com.vmaffioli.model.ScrapConnection;

public class WordDAOImpl implements WordDAO {

	public WordDAOImpl() {
	}

	@Override
	public Word pull(String word) {
		Word result = new Word();
		ResultSet queryResult = new DatabaseConnection("SELECT * learned_words WHERE fword = " + new FormatSimplifier(word).getString() + ";").getQueryResult();
		try {
			result.setName(queryResult.getString("word"));
			result.setFname(queryResult.getString("fword"));
			result.setClasses(queryResult.getString("class"));
			result.setSyllables(queryResult.getString("syllables"));
			result.setPlural(queryResult.getString("plural"));
			result.setSynonyms(queryResult.getString("synonyms"));
			result.setAntonyms(queryResult.getString("antonyms"));
			result.setAnagrams(queryResult.getString("anagrams"));
			result.setMeaning(queryResult.getString("meaning"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void push(Word word) {
		new DatabaseConnection("INSERT INTO learned_words VALUES " + "'" + word.getName() + "','" + word.getFname() + "'," + "'"
				+ word.getClasses() + "'," + "'" + word.getSyllables() + "'," + "'" + word.getPlural() + "'," + "'"
				+ word.getSynonyms() + "'," + "'" + word.getAntonyms() + "'," + "'" + word.getAnagrams() + "'," + "'"
				+ word.getMeaning() + "'" + ";");
	}

	@Override
	public boolean ping(String word) {
		boolean result = false;
		ResultSet queryResult = new DatabaseConnection(
				"SELECT count(1) FROM learned_words WHERE fword = '" + new FormatSimplifier(word).getString() + "';").getQueryResult();
		try {
			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					result = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void fill(String word) {
		Word result = new Word();
		Document queryResult = new ScrapConnection("https://www.dicio.com.br/" + new FormatSimplifier(word).getString()).getResult();
		new HTMLParser(queryResult);
		//		try {
//			result.setName(queryResult.getString("word"));
//			result.setFname(queryResult.getString("fword"));
//			result.setClasses(queryResult.getString("class"));
//			result.setSyllables(queryResult.getString("syllables"));
//			result.setPlural(queryResult.getString("plural"));
//			result.setSynonyms(queryResult.getString("synonyms"));
//			result.setAntonyms(queryResult.getString("antonyms"));
//			result.setAnagrams(queryResult.getString("anagrams"));
//			result.setMeaning(queryResult.getString("meaning"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

}
