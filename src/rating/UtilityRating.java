package rating;

import house.House;
import occupancy.OccupancyRequest;

// currently not in testing
public class UtilityRating extends Rating {
	private double  FairValue;
	private String Review;

	
	public UtilityRating(double ratingScore, double fairValue, String review) {//testing
		super(ratingScore);
		FairValue = fairValue;
		Review = review;

	}
	public UtilityRating(double ratingScore, double fairValue, String review,OccupancyRequest or,House house) {
		super(ratingScore,or,house);
		FairValue = fairValue;
		Review = review;
		
	}

	public double getFairValue() {
		return FairValue;
	}

	public String getReview() {
		return Review;
	}

	
	public void setFairValue(double fairValue) {
		FairValue = fairValue;
	}
	public void setReview(String review) {
		Review = review;
	}
	
}
