package com.cooksys.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main2
{
	
	static String DRIVER = "";
	static String URL = "jdbc:postgres//localhost:5432/postgres";
	static String USER = "postgres";
	static String PASS = "bondstone";

	public static void main(String[] args)
	{
		Class.forName(DRIVER);
		try (
				Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(QUERY);
				ResultSet rs = stmt.executeQuery()) {
		
		
		{
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

	}

}
