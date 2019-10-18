package occupancy;
import java.sql.Date;
import java.time.LocalDate;
import db.UpdateDB;
import house.House;
import member.Member;
import teamPublic.DateTransformer;

public class OccupancyRequest {
	private String orID;
	private Member owner,occupier;
	private String result;
	private LocalDate checkinDay;
	private Date requestTime;
	private House house;

	
	public OccupancyRequest(Member owner, Member occupier,House house,LocalDate checkinDay) {//first create
		
		this.owner = owner;
		this.occupier = occupier;
		this.result = "Pending";
		this.requestTime =new java.sql.Date(System.currentTimeMillis());
		this.house=house;		
		this.checkinDay=checkinDay;
		this.orID=owner.getAccountName() +"_" +occupier +"_"+ String.valueOf(requestTime);
	
	}
	
	public OccupancyRequest(String orID,Member owner, Member occupier,String result,Date requestTime,House house,LocalDate checkinDay) {// from db
		
		this.orID=orID;
		this.owner = owner;
		this.occupier = occupier;
		this.result = result;
		this.requestTime =requestTime;
		this.house=house;		
		this.checkinDay=checkinDay;
	
	
	}

	
	public boolean checkWeekAvailable(House house,LocalDate date) // the week is Available for rent in  this  then return true
	{
		boolean result;
		
		if(this.house.getHouseID().compareTo(house.getHouseID())==0 && DateTransformer.checkSameWeek(this.checkinDay, date) && this.result.compareTo("Reject")!=0)// not allow request in same week expect pass request is reject
			result =false;
		else
			result=true;	
		return result;
	}
	
	public void timecheck()
	{
		Date nowDate=new java.sql.Date(System.currentTimeMillis());
		
		long diff =nowDate.getTime()-this.requestTime.getTime();
		
		long hour =diff/(1000 * 60 * 60);
		
		if(hour>24)
		{
			UpdateDB.RejectRequest(this);
			this.result="Reject";
		}
	}	
	
	public Member getOwner() {
		return this.owner;
	}

	public Member getOccupier() {
		return this.occupier;
	}

	public Date getRequestTime() {
		return this.requestTime;
	}

	public String getResult() {
		return result;
	}

	public House getHouse() {
		return house;
	}
	public LocalDate getCheckinDay() {
		return checkinDay;
	}

	public String getOrID() {
		return orID;
	}


		
	

	

}
