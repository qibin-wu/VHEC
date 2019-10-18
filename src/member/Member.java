package member;

import java.util.ArrayList;

import db.SelectDB;
import db.UpdateDB;
import rating.OccupierRating;
import rating.Rating;

public class Member {
	private ArrayList<Rating> occupierRatingList;
	private String accountName;
	private String name;
	private String address;
	private String phoneNum;
	private double points;

	public Member() {// testing
		occupierRatingList = new  ArrayList<>();
	}

	public Member(ArrayList<Rating> occupierRatingList) {// testing
		this.occupierRatingList = occupierRatingList;
	}

	public Member(String accountName,String name, String address, String phoneNum) {
		this.accountName=accountName;
		occupierRatingList = new  ArrayList<Rating>();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.points=1000;
		
	}
	public Member(String accountName,String name, String address, String phoneNum,Double points) {
		this.accountName=accountName;
		occupierRatingList = new  ArrayList<Rating>();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.points=points;
		
	}

	public double getOccupierRating() {// Calculate average Occupier Rating
		
		this.occupierRatingList= SelectDB.getRating();
		double result, temp = 0;
		int i, num = 0;
		for (i = 0; i < this.occupierRatingList.size(); i++) {
			if (this.occupierRatingList.get(i) instanceof OccupierRating && this.occupierRatingList.get(i).getOccupier().getAccountName().compareTo(this.accountName)==0) {// Find the occupierRating
				temp += this.occupierRatingList.get(i).getRatingScore();
				num++;
			}
		}
		if (num == 0) {
			result = 0;
		} else {
			result = temp / num;
		}
		if(result==-11)
		{
			result=0;
		}
		return result;

	}
	
	public void addRating(Rating newRating) {
		
		if(newRating instanceof OccupierRating)
		this.occupierRatingList.add(newRating);		
	}
	
	public void earnPoints(double points)
	{
		this.points+=points;
		UpdateDB.EarnPoints(this, points);
	}
	public void deductPoints(double points)
	{
		this.points=this.points-points;
		UpdateDB.DeductPoints(this, points);
	}

	
	public ArrayList<Rating> getOccupierRatingList() {
		return occupierRatingList;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public double getPoints() {
		return points;
	}
	public String getAccountName() {
		return accountName;
	}

}
