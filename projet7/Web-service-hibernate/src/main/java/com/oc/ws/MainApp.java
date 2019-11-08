package com.oc.ws;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.ws.Endpoint;

import com.oc.ws.config.Configuration;
import com.oc.ws.wsService.Bibliotheque;

public class MainApp {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();

		String url = conf.getUrl();
		Endpoint.publish(url, new Bibliotheque());
		System.out.println(url);

		
		Connection connection;
		Statement statement;
		ResultSet result;
	
	}
	
}
