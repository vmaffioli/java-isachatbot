package com.vmaffioli.chatbot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vmaffioli.chatbot.io.GenericCompiler;
import com.vmaffioli.chatbot.pojo.Word;
import com.vmaffioli.connections.ConnectionProvider;

/**
 * MAIN
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class App {
	
	public static void main(String[] args) throws IOException {


		//System.out.println(validateLogin());
		
		//System.out.println(new ConnectionProvider("https://www.google.com/").getURLConn());
		
		
		
		System.out.println("Enter your question:");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);	
		String input[] = sc.nextLine().split(" ");
		
		List<Word> phrase = new ArrayList<Word>();
		
		for(String w : input) {
			phrase.add(new GenericCompiler().StringToWord(w));
		}
		
		for(Word w : phrase) {
			System.out.println(w.getName());
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean validateLogin() {
		boolean result = false;

		String verifyLogin = "SELECT count(1) FROM users WHERE email = 'vini@vini' AND password = '1234';";

		try {

			Connection conn = new ConnectionProvider("localhost", "javafx_login", "root", "default").getMySQLConn();

			Statement statement = conn.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);

			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					result = true;
				} else {
					result = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
