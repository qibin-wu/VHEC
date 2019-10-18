package house;

import java.util.ArrayList;
import db.SelectDB;
import member.Member;
import rating.Rating;
import rating.UtilityRating;



public class House {

	private  String houseID;
	private  String city;	
	private  double distance;
	private  String pTransport;
	private  int roomNum;
	private  String heating;
	private  String swimmingPool;
	private  String image;
	private  double pointsRequire;
	private  double discount;
	private  String status;
	private  ArrayList<Rating> utilityRatingList;
	private  Member owner;
	private  String map;
	private  double ratingRequire;
	
	
	
	public House(String city,double distance, String pTransport, int roomNum, String heating,
			String swimmingPool, String image, double pointsRequire, double discount,String map,Member owner, double ratingRequire) {		
		this.city = city;		
		this.distance = distance;
		this.pTransport = pTransport;
		this.roomNum = roomNum;
		this.heating = heating;
		this.swimmingPool = swimmingPool;
		this.image = image;
		this.pointsRequire = pointsRequire;
		this.discount = discount;
		this.utilityRatingList = new ArrayList<>();
		this.owner=owner;
		this.status="Available";
		this.houseID= owner.getAccountName()+city.toLowerCase().trim()+roomNum;
		this.map=map;
		this.ratingRequire=ratingRequire;
		
		
	}
	
	public House(String city,double distance, String pTransport, int roomNum, String heating,
			String swimmingPool, String image, double pointsRequire, double discount,String status,String map,Member owner, double ratingRequire) {		
		this.city = city;
		
		this.distance = distance;
		this.pTransport = pTransport;
		this.roomNum = roomNum;
		this.heating = heating;
		this.swimmingPool = swimmingPool;
		this.image = image;
		this.pointsRequire = pointsRequire;
		this.discount = discount;
		this.utilityRatingList = new ArrayList<>();
		this.owner=owner;
		this.status=status;
		this.houseID= owner.getAccountName()+city.toLowerCase().trim()+roomNum;
		this.map=map;
		this.ratingRequire=ratingRequire;
		
		
	}
	
	public House() {//testing
		this.utilityRatingList = new ArrayList<>();
	}

	public double getAvgUntilityRating() {//Calculate average Untility Rating 
		this.utilityRatingList=SelectDB.getRating();
		double result, temp = 0;
		int i, num = 0;

		for (i = 0; i < this.utilityRatingList.size(); i++) {
			if (this.utilityRatingList.get(i) instanceof UtilityRating && this.utilityRatingList.get(i).getHouse().getHouseID().compareTo(this.houseID)==0) {// Find the UtilityRating
				temp += this.utilityRatingList.get(i).getRatingScore();
				num++;
			}
		}
		if (num == 0) {
			result = 0;
		} else {
			result = temp / num;
		}
		
		if(result == -11)//not yet rate
		{
			result=0;
		}
		return result;
	}
	public double getFairValue() {//Calculate average Fair Value
		this.utilityRatingList=SelectDB.getRating();
		double result, temp = 0;
		int i, num = 0;
		UtilityRating uR;

		for (i = 0; i < this.utilityRatingList.size(); i++) {
			if (this.utilityRatingList.get(i) instanceof UtilityRating && this.utilityRatingList.get(i).getHouse().getHouseID().compareTo(this.houseID)==0) {
			     uR=(UtilityRating)this.utilityRatingList.get(i);
				temp += uR.getFairValue() ;
				num++;
			}
		}
		if (num == 0) {
			result = 0;
		} else {
			result = temp / num;
		}
		if(result == -1)//not yet rate
		{
			result=0;
		}
		return result;
	}
	public String getReview() {
	 String review="";
	 this.utilityRatingList=SelectDB.getRating();
	 for(int i=0;i<this.utilityRatingList.size();i++)
	 {	UtilityRating tempUR;
		 if(this.utilityRatingList.get(i) instanceof UtilityRating && this.utilityRatingList.get(i).getHouse().getHouseID().compareTo(this.houseID)==0)
			 tempUR= (UtilityRating)this.utilityRatingList.get(i);
		 else
			 continue;
		
		 if(tempUR.getFairValue()==-1 && tempUR.getRatingScore()==-11)//not yet rate
			 continue;
		 
		 if(tempUR.getHouse().getHouseID().compareTo(this.houseID)==0 )
		 {
			 review+= tempUR.getOccupier().getName() + ": " + tempUR.getReview()+ "\n";
		 }		 
	 }
	 
	 if(review.compareTo("")==0)
		 review ="No occupancy history ";
		return review;
	}
	
	public void addRating(Rating newRating) {
		
		if(newRating instanceof UtilityRating)
		this.utilityRatingList.add(newRating);		
	}
		

	public Member getOwner() {
		return this.owner;
	}

	public ArrayList<Rating> getUtilityRatingList() {
		return this.utilityRatingList;
	}
	public String getCity() {
		return this.city;
	}
	public double getDistance() {
		return this.distance;
	}
	
	public int getRoomNum() {
		return this.roomNum;
	}
	

	public double getPointsRequire() {
		return this.pointsRequire;
	}
	public double getDiscount() {
		return this.discount;
	}

	public String getStatus() {
		return status;
	}
	public String getHouseID() {
		return houseID;
	}

	public String getImage() {
		return image;
	}

	public String getpTransport() {
		return pTransport;
	}

	public String getHeating() {
		return heating;
	}

	public String getSwimmingPool() {
		return swimmingPool;
	}
	public String getMap() {
		return map;
	}

	public double getRatingRequire() {
		return ratingRequire;
	}
	
	

}
