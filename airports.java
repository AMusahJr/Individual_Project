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
public class airports {
	private int airport_id;
	private String airport_name;
	private String city;
	private String country;
	private String IATA_code;
	private String ICAO_code;
	private double latitude;
	private double longitude;
	private int altitude;
	private int timezone;
	private String DST;
	private String database_timezone;
	private String type;
	private String source_of_data;
	
	
	/*
	 * CONSTRUCTOR
	 */
	
	public airports(int airport_id, String airport_name, String city, String country, String IATA_code, String ICAO_code, double latitude, double longitude, int altitude, int timezone, String DST, String database_timezone, String type, String source_of_data) {
		this.airport_id = airport_id;
		this.airport_name = airport_name;
		this.city = city;
		this.country = country;
		this.IATA_code = IATA_code;
		this.ICAO_code = ICAO_code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.timezone = timezone;
		this.DST = DST;
		this.database_timezone = database_timezone;
		this.type = type;
		this.source_of_data = source_of_data;
		
	}
	public airports() {
		this.airport_id = 0;
		this.airport_name = " ";
		this.city = " ";
		this.country = " ";
		this.IATA_code = " ";
		this.ICAO_code = " ";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.altitude = 0;
		this.timezone = 0;
		this.DST = " ";
		this.database_timezone = " ";
		this.type = " ";
		this.source_of_data = " ";
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		return "airports{" +
				"airport_id = " + airport_id +
				",airport_name = " + airport_name + '\'' + 
				", city = '" + city + '\'' +
				",country = '" + country + '\'' +
				",IATA_code = '" + IATA_code + '\'' + 
				",ICAO_code = '" + ICAO_code + '\'' +
				",latitude = '" + latitude + '\'' +
				",longitude = '" + longitude + '\'' +
				",altitude = '" + altitude + '\'' +
				",timezone = '" + timezone + '\'' +
				",DST = '" + DST + '\'' +
				",database_timezone = '" + database_timezone + '\'' +
				",type = '" + type + '\'' +
				",source_of_data = '" + source_of_data + '\'' +
				'}';
	}
		
		
	/*
	 * ACCESSORS AND MUTATORS
	 */
				
	
	

	public int getAirport_id() {
		return airport_id;
	}



	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}



	public String getAirport_name() {
		return airport_name;
	}



	public void setAirport_name(String name) {
		this.airport_name = airport_name;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getIATA_code() {
		return IATA_code;
	}



	public void setIATA_code(String iATA_code) {
		IATA_code = iATA_code;
	}



	public String getICAO_code() {
		return ICAO_code;
	}



	public void setICAO_code(String iCAO_code) {
		ICAO_code = iCAO_code;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public int getAltitude() {
		return altitude;
	}



	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}



	public int getTimezone() {
		return timezone;
	}



	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}



	public String getDST() {
		return DST;
	}



	public void setDST(char dST) {
		DST = DST;
	}



	public String getDatabase_timezone() {
		return database_timezone;
	}



	public void setDatabase_timezone(String database_timezone) {
		this.database_timezone = database_timezone;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getSource_of_data() {
		return source_of_data;
	}



	public void setSource_of_data(String source_of_data) {
		this.source_of_data = source_of_data;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
