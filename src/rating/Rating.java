package rating;

import house.House;
import member.Member;
import occupancy.OccupancyRequest;

public abstract class Rating {
	private double  RatingScore;
	private OccupancyRequest or;
	private House house;
	
	public Rating(double ratingScore) {//testing
		this.RatingScore = ratingScore;
		
	}
	
	public Rating(double ratingScore,OccupancyRequest or,House house) {
		this.RatingScore = ratingScore;		
		this.or=or;
		this.house=house;
		
		
	}

	public double getRatingScore() {
		return RatingScore;
	}


	public void setRatingScore(double ratingScore) {
		RatingScore = ratingScore;
	}

	public OccupancyRequest getOr() {
		return or;
	}

	public Member getOccupier() {
		return or.getOccupier();
	}

	public Member getOwner() {
		return or.getOwner();
	}

	public House getHouse() {
		return house;
	}
	

}
