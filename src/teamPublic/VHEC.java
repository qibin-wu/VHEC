package teamPublic;

import java.time.LocalDate;
import java.util.*;


import db.SelectDB;
import house.House;
import member.Member;
import occupancy.OccupancyRequest;
import rating.OccupierRating;
import rating.Rating;
import rating.UtilityRating;

public class VHEC {
	
	private ArrayList<House> house;
	private ArrayList<OccupancyRequest> OR;
	private Member member=null;
	private  ArrayList<Rating> rating;
	public VHEC() {//non-member view All house
		
		this.house=SelectDB.getAllHouse();
	}
	
	public VHEC(Member member) {//member view house
		
		this.house=SelectDB.getHousebyMember(member);
		this.OR=SelectDB.getOccupancyRequest();
		this.member=member;
		this.rating=SelectDB.getRating();
	}
	
	public VHEC(String accountName,String password) {		//  login
		
		if(SelectDB.LoginCheck(accountName, password))		
		{
			this.member=SelectDB.getMemberbyAccount(accountName);
			this.OR=SelectDB.getOccupancyRequest();
			this.house=SelectDB.getHousebyMember(member);
			this.rating=SelectDB.getRating();
			
		}
	}
	
	public ArrayList<OccupierRating> getOccupierRating()
	{
		ArrayList<OccupierRating> occupierRateList =new ArrayList<>();
		OccupierRating occRate;
		
		for(int i=0;i<this.rating.size();i++)
		{
						
			
			if (this.rating.get(i) instanceof OccupierRating && this.rating.get(i).getOwner().getAccountName().compareTo(this.member.getAccountName())==0)
			{
				occRate = (OccupierRating)(this.rating.get(i));		
				occupierRateList.add(occRate);
			}
			
			
		}
	 
		
		
		return occupierRateList;
	}
	public ArrayList<UtilityRating> getUtilityRating()
	{
		ArrayList<UtilityRating> utilityRatingRateList =new ArrayList<>();
		UtilityRating utiRate;
		
		for(int i=0;i<this.rating.size();i++)
		{
						
			
			if (this.rating.get(i) instanceof UtilityRating && this.rating.get(i).getOccupier().getAccountName().compareTo(this.member.getAccountName())==0)
			{
				utiRate = (UtilityRating)(this.rating.get(i));		
				utilityRatingRateList.add(utiRate);
			}
			
			
		}
	 
		
		
		return utilityRatingRateList;
	}
	public void addHouse(House house)
	{
		this.house.add(house);
	}
	public boolean checkWeek(House house,LocalDate date) 
	{
		boolean result=true;
		
		for(int i=0;i<this.OR.size();i++)
		{
			if(!(this.OR.get(i).checkWeekAvailable(house, date))) // !true = not available = return false
			{
				result=false;
			}
			
		}
		
		return result;
		
	}
	
	public HashSet<String> getCity()
	{
		HashSet<String> city =new HashSet<String>(); 
		for(int i=0;i<this.house.size();i++)
		{
			city.add(this.house.get(i).getCity());
		
		}
		return city;
	}


	public ArrayList<House> getHouse() {
		return house;
	}

	public Member getMember() {
		return member;
	}

	public ArrayList<OccupancyRequest> getOR() {
		return OR;
	}

	public ArrayList<Rating> getRating() {
		return rating;
	}

}
