package com.vmaffioli.chatbot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.nodes.Document;

import com.vmaffioli.chatbot.io.FormatSimplifier;
import com.vmaffioli.chatbot.pojo.Word;
import com.vmaffioli.model.DatabaseConnection;
import com.vmaffioli.model.ScrapConnection;

public class WordDAOImpl implements WordDAO {

	public WordDAOImpl() {
	}

	/**
	 * Get data from database
	 */
	@Override
	public Word pull(String word) {
		Word result = new Word();
		System.out.println("SELECT * FROM learned_words WHERE nfname = '" + word.trim().toLowerCase() + "' collate utf8mb4_bin"
						+ " AND fname = '" + new FormatSimplifier(word).getString() + "' collate utf8mb4_bin;");
		ResultSet queryResult = new DatabaseConnection(
				"SELECT * FROM learned_words WHERE nfname = '" + word.trim().toLowerCase() + "' collate utf8mb4_bin"
						+ " AND fname = '" + new FormatSimplifier(word).getString() + "' collate utf8mb4_bin;")
								.getQueryResult();

		try {
			while(queryResult.next()) {
			result.setName(queryResult.getString("nfname"));
			result.setFname(queryResult.getString("fname"));
			result.setSyllables(queryResult.getString("syllables"));
			result.setClasses(queryResult.getString("classes"));
			result.setMeaning(queryResult.getString("meaning"));
			result.setSynonyms(queryResult.getString("synonyms"));
			result.setAntonyms(queryResult.getString("antonyms"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Update data in database
	 */
	@Override
	public void push(Word word) {
		new DatabaseConnection(
				"INSERT INTO learned_words (nfname, fname, syllables, classes, meaning, synonyms, antonyms) VALUES ('"
						+ word.getName() + "','" + word.getFname() + "','" + word.getSyllables() + "','"
						+ word.getClasses() + "','" + word.getMeaning() + "','" + word.getSynonyms() + "','"
						+ word.getAntonyms() + "');");
	}

	/**
	 * Verify if the word exists in database
	 */
	@Override
	public boolean ping(String word) {
		boolean result = false;
		ResultSet queryResult = new DatabaseConnection(
				"SELECT count(1) FROM learned_words WHERE nfname = '" + word.trim().toLowerCase() + "' collate utf8mb4_bin"
						+ " AND fname = '" + new FormatSimplifier(word).getString() + "' collate utf8mb4_bin;")
								.getQueryResult();
		try {
			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					result = true;
				} else if (queryResult.getInt(1) > 1) {
					result = true;
					System.out.println("ADD VALIDACAO PRA MULTIPLOS RETORNOS");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Get data from scrap connection and update database with it using a word
	 * object
	 */
	@Override
	public Word fill(String w) {
		Word word = new Word();

		// Get data from online dictionary
		Document content = new ScrapConnection(
				"https://michaelis.uol.com.br/busca?r=0&f=0&t=0&palavra=" + w.trim().toLowerCase())
						.getResult();
		word.setName(content.select("#content").select("e1").text());
		word.setFname(new FormatSimplifier(content.select("#content").select("e1").text()).getString());
		word.setSyllables(content.select("#content").select("es").text().replace("·", ","));
		word.setClasses(content.select("#content").select("cg").text());
		word.setMeaning(content.select(".verbete.bs-component").text().split("1")[1].split("ETIMOLOGIA")[0]);
		System.out.println(content.select("*|ra").text());

		// Get extra data (synonyms)
		try {
		content = new ScrapConnection(
				"https://www.sinonimos.com.br/busca.php?q=" + w.trim().toLowerCase()).getResult();
		word.setSynonyms(content.select(".s-wrapper").select("a").text());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			content = new ScrapConnection(
					"https://www.sinonimos.com.br/busca.php?q=" + new FormatSimplifier(word.getName()).getString()).getResult();
			word.setSynonyms(content.select(".s-wrapper").select("a").text());
		}

		// Get extra data (synonyms)
		try {
		content = new ScrapConnection(
				"https://www.antonimos.com.br/busca.php?q=" + w.trim().toLowerCase()).getResult();
		word.setSynonyms(content.select(".s-wrapper").select("a").text());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			content = new ScrapConnection(
					"https://www.antonimos.com.br/busca.php?q=" + new FormatSimplifier(word.getName()).getString()).getResult();
			word.setAntonyms(content.select(".s-wrapper").select("a").text());
		}

		push(word);
		return  word;
	}

}
