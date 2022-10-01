package ICP_Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * INSTANCE VARIABLE
 */
public class routes {
	private String airline_code;
	private int airline_id;
	private String source_airport_code;
	private int source_airport_id;
	private String destination_airport_code;
	private int destination_airport_id;
	private String code_share;
	private int stops;
	private String equipment;
	private String start_city_code;
	
	
	static HashMap<String, ArrayList<ArrayList<String>>> route_map = new HashMap<>();
	
	/*
	 * CONSTRUCTOR
	 */
	
	public routes(String airline_code, int airline_id, String source_airport_code, int source_airport_id, String destination_airport_code, int destination_airport_id, String code_shares, int stops, String equipment) {
		this.airline_code = airline_code;
		this.airline_id = airline_id;
		this.source_airport_code = source_airport_code;
		this.source_airport_id = source_airport_id;
		this.destination_airport_code = destination_airport_code;
		this.destination_airport_id = destination_airport_id;
		this.code_share = code_shares;
		this.stops = stops;
		this.equipment = equipment;
		
	}
	@java.lang.Override
	public java.lang.String toString() {
		return "routes{" +
				"airline_id = " + airline_id +
				",airline_code = " + airline_code + '\'' + 
				", source_airport_code = '" + source_airport_code + '\'' +
				",source_airport_id = '" + source_airport_id + '\'' + 
				",source_airport_code = '" + source_airport_code + '\'' +
				",destination_airport_code = '" + destination_airport_code + '\'' +
				",destination_airport_id = '" + destination_airport_id+ '\'' +
				",code_share = '" + code_share + '\'' +
				",stops = '" + stops + '\'' +
				",equipment = '" + equipment + '\'' +
				'}';
	}
				
	
	/*
	 * ACCESSORS AND MUTATORS
	 */
	

	public String getAirline_code() {
		return airline_code;
	}



	public void setAirline_code(String airline_code) {
		this.airline_code = airline_code;
	}



	public int getAirline_id() {
		return airline_id;
	}



	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}



	public String getSource_airport_code() {
		return source_airport_code;
	}



	public void setSource_airport_code(String source_airport_code) {
		this.source_airport_code = source_airport_code;
	}



	public int getSource_airport_id() {
		return source_airport_id;
	}



	public void setSource_airport_id(int source_airport_id) {
		this.source_airport_id = source_airport_id;
	}



	public String getDestination_airport_code() {
		return destination_airport_code;
	}



	public void setDestination_airport_code(String destination_airport_code) {
		this.destination_airport_code = destination_airport_code;
	}



	public int getDestination_airport_id() {
		return destination_airport_id;
	}



	public void setDestination_airport_id(int destination_airport_id) {
		this.destination_airport_id = destination_airport_id;
	}



	public String getCode_share() {
		return code_share;
	}



	public void setCode_share(String code_share) {
		this.code_share = code_share;
	}



	public int getStops() {
		return stops;
	}



	public void setStops(int stops) {
		this.stops = stops;
	}



	public String getEquipment() {
		return equipment;
	}



	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static HashMap<String, ArrayList<ArrayList<String>>> populate_hashmap(){
        ArrayList<String[]> result = ReadFile.ReadFile("/Users/musahamidujunior/Desktop/Intermediate Computer Programming/routes.csv");
        for (String[] element: result){
            ArrayList<ArrayList<String>> values = new ArrayList<>();
            routes routeobjects = Objects.route_objects(element);
            String key = routeobjects.start_city_code;
            ArrayList<String> routeCost = new ArrayList<>();
            double cost = Haversline.route_distance(key, routeobjects.getdestination_city_code());
            routeCost.add(String.valueOf(cost));
            routeCost.add(routeobjects.getdestination_city_code());
            // If the key is already in the hash map, I add the values in an ArrayList of an ArrayList of strings to it (i.e. extending thr values)
            if (route_map.containsKey(key)){
                values = route_map.get(key);
                values.add(routeCost);
                route_map.put(key, values);
            }
            // Else I insert the key into the hash map and append its corresponding value
            else{
                values.add(routeCost);
                route_map.put(key, values);
            }
        }
        return route_map;
    }
}
