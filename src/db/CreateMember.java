package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMember {

	public static void main(String[] args) throws SQLException {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
		
		//use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			int result = stmt.executeUpdate("CREATE TABLE Member ("
										+ "accountName VARCHAR(50) NOT NULL,"
										+ "password VARCHAR(50) NOT NULL,"
										+ "name VARCHAR(25) NOT NULL," 
										+ "address VARCHAR(50) NOT NULL,"										
										+ "phoneNum VARCHAR(20) NOT NULL,"
										+ "points float NOT NULL,"										
										+ "PRIMARY KEY (accountName))");
			if(result == 0) {
				System.out.println("Table " + TABLE_NAME + " has been created successfully");
			} else {
				System.out.println("Table " + TABLE_NAME + " is not created");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
