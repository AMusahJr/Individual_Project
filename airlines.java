package ICP_Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class airlines {
	private int airline_id;
	private String name;
	private String alias;
	private String IATA_code;
	private String ICAO_code;
	private String callsign;
	private String country;
	private String  active;
	
	
	public airlines(int airline_id, String name, String alias, String IATA_code, String ICAO_code, String callsign, String country, String active) {
		this.airline_id = airline_id;
		this.name = name;
		this.alias = alias;
		this.IATA_code = IATA_code;
		this.ICAO_code = ICAO_code;
		this.callsign = callsign;
		this.country = country;
		this.active = active;
		
	}
	@java.lang.Override
	public java.lang.String toString() {
		return "airlines{" +
				"airline_id = " + airline_id +
				",airline_name = " + name + '\'' + 
				", alias = '" + alias + '\'' +
				",IATA_code = '" + IATA_code + '\'' + 
				",ICAO_code = '" + ICAO_code + '\'' +
				",callsign = '" + callsign + '\'' +
				",country = '" + country + '\'' +
				",active = '" + active + '\'' +
				'}';
				
				
				
	}
				
				
				
	
	
	

	public int getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	

}
