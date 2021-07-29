package com.vmaffioli.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.vmaffioli.connections.ConnectionProvider;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Connection provider using
 * https://github.com/vmaffioli/GenericConnectionProvider_Java to manage the connector
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class DatabaseConnection {
	
	private ResultSet queryResult;

	
	
	public DatabaseConnection(String query) {
		if(query.split(" ")[0].equals("SELECT")) {
			queryResult = executeQuery(query);
		} else if(query.split(" ")[0].equals("INSERT")) {
			executeUpdate(query);
		}
		
	}

	/**
	 *  Execute Query "SELECT"
	 *
	 */
	private ResultSet executeQuery(String query) {
		ResultSet queryResult = null;
		try {
			Dotenv dotenv = Dotenv.load();
			Connection conn = new ConnectionProvider(dotenv.get("CHATBOTDBADRESS"), dotenv.get("CHATBOTDBNAME"),
					dotenv.get("CHATBOTDBUSER"), dotenv.get("CHATBOTDBPASSWORD")).getMySQLConn();

			Statement statement = conn.createStatement();
			queryResult = statement.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryResult;
	}

	/**
	 *  Execute Update "INSERT"
	 *
	 */
	private void executeUpdate(String query) {
		try {
			Dotenv dotenv = Dotenv.load();
			Connection conn = new ConnectionProvider(dotenv.get("CHATBOTDBADRESS"), dotenv.get("CHATBOTDBNAME"),
					dotenv.get("CHATBOTDBUSER"), dotenv.get("CHATBOTDBPASSWORD")).getMySQLConn();

			Statement statement = conn.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public ResultSet getQueryResult() {
		return queryResult;
	}



	public void setQueryResult(ResultSet queryResult) {
		this.queryResult = queryResult;
	}





}
