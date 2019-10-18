package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOccupancyRequest {

	

	public static void main(String[] args) throws SQLException {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "OccupancyRequest";
		
		//use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			int result = stmt.executeUpdate("CREATE TABLE OccupancyRequest ("
										+ "orID VARCHAR(50) NOT NULL,"
										+ "OwnerAcc VARCHAR(50) NOT NULL,"
										+ "OccupierAcc VARCHAR(50) NOT NULL," 
										+ "result VARCHAR(20) NOT NULL,"
										+ "requestTime DATE NOT NULL,"
										+ "houseID VARCHAR(50) NOT NULL,"									
										+ "checkinDate DATE NOT NULL,"
										+ "PRIMARY KEY (orID))");
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
