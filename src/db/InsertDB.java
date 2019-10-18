package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import house.House;
import occupancy.OccupancyRequest;

public class InsertDB {

	public static void Register(String accountName, String password, String name, String address, String phoneNum) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
		String query;

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {

			query = "INSERT INTO " + TABLE_NAME + " VALUES ('" + accountName + "','" + password + "','" + name + "', '"
					+ address + "','" + phoneNum + "',1000.0)";

			int result = stmt.executeUpdate(query);

			con.commit();
			con.close();

			System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertHouse(House house) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "House";
		String query;

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {		
		query = "INSERT INTO " + TABLE_NAME + " VALUES ('" +house.getHouseID() + "','"+house.getCity()+"', "+house.getDistance()+",'"+ house.getpTransport() +"',"+house.getRoomNum()+",'"+house.getHeating()+"','"+ house.getSwimmingPool() +"','"+ house.getImage() + "',"+house.getPointsRequire()+","+ house.getDiscount() +",'"+house.getStatus() +"', '" + house.getOwner().getAccountName()+"','"+house.getMap() +"','"+house.getRatingRequire() +"' )";
		int result = stmt.executeUpdate(query);
		con.commit();
		con.close();
		System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
		System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

}
	
	public static void RequestOccupancy(OccupancyRequest newOR) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "OccupancyRequest";
		String query;

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {		
		query = "INSERT INTO " + TABLE_NAME + " VALUES ('" +newOR.getOrID() + "','"+newOR.getOwner().getAccountName()+"','"+ newOR.getOccupier().getAccountName() +"','Pending',CURRENT_DATE,'"+newOR.getHouse().getHouseID() +"','"+Date.valueOf(newOR.getCheckinDay())+"')";
		int result = stmt.executeUpdate(query);
		con.commit();
		con.close();
		System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
		System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

}
	
	public static void CreateRating(OccupancyRequest or) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Rating";
		String query;

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {		
		query = "INSERT INTO " + TABLE_NAME + " VALUES ('" +or.getOrID() + "',-11,'"+ or.getHouse().getHouseID() + "',-1,'',-11)";
		int result = stmt.executeUpdate(query);
		con.commit();
		con.close();
		System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
		System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

}
	

	}
