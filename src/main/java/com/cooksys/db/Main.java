package com.cooksys.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args)
	 {
		
		Main m = new Main();
		

	
		try
		{
			m.findActor(1);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }


	private void findActor(int id) throws ClassNotFoundException, SQLException
	{
		String query = "select first_name, last_name from public.actor "; //or select * for entire table
//					+ "where actor_id = '" + id + "'";

		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres","postgres", "bondstone");
				Statement state = connection.createStatement(); //create statement
				ResultSet result = state.executeQuery(query)) //statement realizes where it's statement is
				//ResultSet is a table not saved (a temporary table)
		{
			while (result.next())  //moves you to the next item on the list so it's non idempotem, affects what happens next
			{
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				
				String firstNameByIndex = result.getString(1);

				log.info("Found user: " + firstName + " " + lastName);
			}
		}
	}

}



// private static final Logger Log =

// }
//

// Class.forName("org.postgresql.Driver");
//
// try (Connection connection = DriverManager.getConnection
// ("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
// {
//
// } catch (SQLException e) {
// ))
// {
// // TODO: handle exception
// }

//JDBC 
