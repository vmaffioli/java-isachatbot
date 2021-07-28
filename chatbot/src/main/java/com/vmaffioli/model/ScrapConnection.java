package com.vmaffioli.model;

import java.io.IOException;

import org.jsoup.nodes.Document;

import com.vmaffioli.connections.ConnectionProvider;

/**
 * Connection provider using
 * https://github.com/vmaffioli/GenericConnectionProvider_Java to manage the connector
 * 
 * @author https://github.com/vmaffioli
 *
 */
public class ScrapConnection {
	private Document result;
	
	public ScrapConnection(String url) {
		try {
			result = new ConnectionProvider(url).getURLConn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Document getResult() {
		return result;
	}
	
	
}
