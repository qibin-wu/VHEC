package db;

import java.sql.Connection;
import java.sql.Statement;

import member.Member;
import occupancy.OccupancyRequest;
import rating.OccupierRating;
import rating.UtilityRating;

public class UpdateDB {
	
	public static void RejectRequest(OccupancyRequest or) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "OccupancyRequest";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  result = 'Reject'" +
					" WHERE orID = '"+or.getOrID() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void AcceptRequest(OccupancyRequest or) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "OccupancyRequest";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  result = 'Accept'" +
					" WHERE orID = '"+or.getOrID() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void EarnPoints(Member owner,Double points) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  points =points + "+ points +" " +
					" WHERE accountName = '"+owner.getAccountName() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	public static void DeductPoints(Member owner,Double points) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  points =points - "+ points +" " +
					" WHERE accountName = '"+owner.getAccountName() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void performOccupierRating(OccupierRating occrate,Double score) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Rating";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  OccupierRating = "+ score +" " +
					" WHERE ratingID = '"+occrate.getOr().getOrID() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void performUtilityRating(UtilityRating utirate,Double score,Double fairvalue,String review) {
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Rating";
	
		
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			String query = "UPDATE " + TABLE_NAME +
					" SET  utilityRating = "+ score +", FairValue="+ fairvalue +", review='"+ review +"' " +
					" WHERE ratingID = '"+utirate.getOr().getOrID() +"'";
			
			int result = stmt.executeUpdate(query);
			
			System.out.println("Update table " + TABLE_NAME + " executed successfully");
			System.out.println(result + " row(s) affected");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
