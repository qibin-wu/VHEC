package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateRating {
	
public static void main(String[] args) throws SQLException {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Rating";
		
		//use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			int result = stmt.executeUpdate("CREATE TABLE Rating ("
										+ "ratingID VARCHAR(50) NOT NULL,"										
										+ "utilityRating float ,"
										+ "houseID VARCHAR(50) NOT NULL,"
										+ "FairValue float ,"
										+ "review  varchar(100),"										
										+ "OccupierRating float ,"										
										+ "PRIMARY KEY (ratingID))");
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
