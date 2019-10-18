package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import house.House;
import member.Member;
import occupancy.OccupancyRequest;
import rating.OccupierRating;
import rating.Rating;
import rating.UtilityRating;



public class SelectDB {
	
	public static ArrayList<House> getAllHouse() {
		House house;
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "House";
		String query;
		String city,pTransport,heating,swimmingPool,image,status,accountName,map;
		int roomNum;
		double distance,pointsRequire,discount,rateRequire;
		ArrayList<House> houseList = new ArrayList<>();

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				while (resultSet.next()) {
					
					//houseID = resultSet.getString("houseID");
					city = resultSet.getString("city");					
					pTransport = resultSet.getString("pTransport");
					heating = resultSet.getString("heating");
					swimmingPool = resultSet.getString("swimmingPool");
					image = resultSet.getString("image");
					status = resultSet.getString("status");
					accountName = resultSet.getString("accountName");
					roomNum = resultSet.getInt("roomNum");
					distance = resultSet.getFloat("distance");
					pointsRequire = resultSet.getFloat("pointsRequire");
					discount = resultSet.getFloat("discount");
					map=resultSet.getString("map");
					rateRequire=resultSet.getFloat("rateRequire");
					
					
					house = new House(city,distance, pTransport, roomNum, heating, swimmingPool, image, pointsRequire, discount,status,map, getMemberbyAccount(accountName),rateRequire);
						houseList.add(house);
					}

				}

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		return houseList;
	}
	
	public static ArrayList<House> getHousebyMember(Member member) { // return house list that points is enough and not owed house
		House house;
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "House";
		String query;
		String city,pTransport,heating,swimmingPool,image,status,accountName,map;
		int roomNum;
		double distance,pointsRequire,discount,rateRequire;
		ArrayList<House> houseList = new ArrayList<>();

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				while (resultSet.next()) {
					
					pointsRequire= resultSet.getFloat("pointsRequire");
					accountName = resultSet.getString("accountName");
					
					if(member.getPoints()<pointsRequire || member.getAccountName().compareTo(accountName)==0)
						continue;
					
					//houseID = resultSet.getString("houseID");
					city = resultSet.getString("city");
					pTransport = resultSet.getString("pTransport");
					heating = resultSet.getString("heating");
					swimmingPool = resultSet.getString("swimmingPool");
					image = resultSet.getString("image");
					status = resultSet.getString("status");					
					roomNum = resultSet.getInt("roomNum");
					distance = resultSet.getFloat("distance");
					
					discount = resultSet.getFloat("discount");
					map=resultSet.getString("map");
					rateRequire=resultSet.getFloat("rateRequire");
					
					
					house = new House(city,distance, pTransport, roomNum, heating, swimmingPool, image, pointsRequire, discount,status,map, getMemberbyAccount(accountName),rateRequire);
						houseList.add(house);
					}

				}

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		return houseList;
	}
	
	private static ArrayList<Member> getMember() {
		Member member;
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
		String query;
		String accountName,name,address,phoneNum;		
		double points;
		ArrayList<Member> memberList = new ArrayList<>();

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				while (resultSet.next()) {
					
					//houseID = resultSet.getString("houseID");
					accountName = resultSet.getString("accountName");
					name = resultSet.getString("name");
					address = resultSet.getString("address");
					phoneNum = resultSet.getString("phoneNum");					
					points = resultSet.getFloat("points");
					member= new Member(accountName,name, address, phoneNum, points);
					memberList.add(member);
					}

				}

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		return memberList;
		
	}
	
	
	public static ArrayList<OccupancyRequest> getOccupancyRequest() {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "OccupancyRequest";
		String query;
		String orID,OwnerAcc,OccupierAcc,result,houseID;		
		LocalDate checkinDate;
		Date requestTime;
		ArrayList<OccupancyRequest> ORList = new ArrayList<>();

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				while (resultSet.next()) {
					
					orID=resultSet.getString("orID");
					OwnerAcc = resultSet.getString("OwnerAcc");
					OccupierAcc = resultSet.getString("OccupierAcc");
					result = resultSet.getString("result");
					requestTime = resultSet.getDate("requestTime");
					houseID=resultSet.getString("houseID");
					checkinDate=resultSet.getDate("checkinDate").toLocalDate();
					
					OccupancyRequest or =new OccupancyRequest(orID,getMemberbyAccount(OwnerAcc),getMemberbyAccount(OccupierAcc),result,requestTime,getHousebyID(houseID),checkinDate);
					ORList.add(or);
				
					}

				}

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		return ORList;
		
	}
	
	public static boolean LoginCheck(String accountNamem,String Password)
	{
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Member";
		String query;
		boolean check=false;
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME +" where accountname ='" +accountNamem + "' and password ='"+ Password +"' ";

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				if(resultSet.next())
					check= true;
			
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return check;
	}
	
	
	public static Member getMemberbyAccount(String accountName)
	{
		Member owner=null;
		ArrayList<Member> memberList=getMember();
		for(int i=0;i<memberList.size();i++)
		{
			if(accountName.compareTo(memberList.get(i).getAccountName())==0)
			{
				owner=memberList.get(i);
			}
				
		}
		
		
		
		return owner;
		
	}
	public static House getHousebyID(String houseID)
	{
		House house=null;
		ArrayList<House> houseList= getAllHouse();
		for(int i=0;i<houseList.size();i++)
		{
			if(houseID.compareTo(houseList.get(i).getHouseID())==0)
			{
				house=houseList.get(i);
			}
				
		}
		
		
		
		return house;
		
	}
	public static OccupancyRequest getOccupancyRequestbyID(String orID)
	{
		OccupancyRequest or=null;
		ArrayList<OccupancyRequest> orList= getOccupancyRequest();
		for(int i=0;i<orList.size();i++)
		{
			if(orID.compareTo(orList.get(i).getOrID())==0)
			{
				or=orList.get(i);
			}
				
		}
		
		
		
		return or;
		
	}

	public static ArrayList<Rating> getRating() {
		
		final String DB_NAME = "vhecDB";
		final String TABLE_NAME = "Rating";
		String query;
		String ratingID,houseID,review;		
		double UtilityRating,FairValue,OccupierRating;
		ArrayList<Rating> RatingList = new ArrayList<>();

		// use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME); Statement stmt = con.createStatement();) {
			query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {

				while (resultSet.next()) {
					
					ratingID=resultSet.getString("ratingID");					
					UtilityRating = resultSet.getFloat("utilityRating");
					FairValue = resultSet.getFloat("FairValue");
					houseID=resultSet.getString("houseID");
					OccupierRating=resultSet.getFloat("OccupierRating");
					review=resultSet.getString("review");
					
					Rating occupierRating =new OccupierRating(OccupierRating,getOccupancyRequestbyID(ratingID),getHousebyID(houseID));
					Rating utilityRating =new UtilityRating(UtilityRating, FairValue, review,getOccupancyRequestbyID(ratingID), getHousebyID(houseID));
					
					RatingList.add(occupierRating);
					RatingList.add(utilityRating);
					}

				}

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		return RatingList;
	}

}
