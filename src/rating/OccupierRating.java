package rating;

import house.House;
import occupancy.OccupancyRequest;

public class OccupierRating extends Rating {
	


	public OccupierRating(double ratingScore) {//testing
		super(ratingScore);
		
	}

	public OccupierRating(double ratingScore,OccupancyRequest or,House house) {
		super(ratingScore,or,house);
		
	}

}
