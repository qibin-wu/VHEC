package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateHouse {

	public static void main(String[] args) throws SQLException {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "House";
		
		//use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			int result = stmt.executeUpdate("CREATE TABLE House ("
										+ "houseID VARCHAR(50) NOT NULL,"
										+ "city VARCHAR(20) NOT NULL," 										
										+ "distance float NOT NULL,"
										+ "pTransport VARCHAR(20) NOT NULL,"
										+ "roomNum int NOT NULL,"
										+ "heating VARCHAR(20) NOT NULL,"
										+ "swimmingPool VARCHAR(20) NOT NULL,"
										+ "image varchar(50) NOT NULL, "
										+ "pointsRequire float NOT NULL, "
										+ "discount float NOT NULL, "
										+ "status varchar(50) NOT NULL, "
										+ "accountName varchar(50) NOT NULL, "
										+ "map varchar(50) NOT NULL, "
										+ "rateRequire float NOT NULL, "
										+ "PRIMARY KEY (houseID))");
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
