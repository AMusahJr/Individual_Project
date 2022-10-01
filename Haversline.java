/**
 * 
 */
package ICP_Project;

public class Haversline {
	
	    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

	    public static double distance(double startLat, double startLong,
	                                  double endLat, double endLong) {

	        double dLat  = Math.toRadians((endLat - startLat));
	        double dLong = Math.toRadians((endLong - startLong));

	        startLat = Math.toRadians(startLat);
	        endLat   = Math.toRadians(endLat);

	        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	        return EARTH_RADIUS * c; // <-- d
	    }

	    public static double haversin(double val) {
	        return Math.pow(Math.sin(val / 2), 2);
	    }
	    
	    


		public static double route_distance(String start_city_code, String destination_city_code) {
			airports root = Objects.get_airport_code(start_city_code);
	        airports Destination = Objects.get_airport_code(destination_city_code);
	        double result = Haversline.distance(root.getLatitude(), root.getLongitude(), Destination.getLatitude(), Destination.getLongitude());
	        return result;
			// TODO Auto-generated method stub
			
		}
	}
// Reference: https://github.com/jasonwinn/haversine/blob/master/Haversine.java

