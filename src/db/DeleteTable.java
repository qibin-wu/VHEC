package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteTable {

	public static void main(String[] args) throws SQLException {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";

	
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			int result = stmt.executeUpdate("DROP TABLE Member");

			if (result == 0) {
				
				System.out.println("Table " + TABLE_NAME + " has been deleted successfully");	
				
			} else {
				System.out.println("Table " + TABLE_NAME + " was not deleted");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
