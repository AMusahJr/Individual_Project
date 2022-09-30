package ICP_Project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



import java.io.*;


public class Objects {
		/**
		 * Creating an airport
		 * @return airport_object
		 */
		
	public static airports airport_object(String[] airport_list) {
		 int airport_id  = 0;
		 String airport_name = " ";
		 String city = " ";
		 String country = " ";
		 String IATA_code = " ";
		 String ICAO_code = " ";
		 double latitude = 0.0;
		 double longitude = 0.0;
		 int altitude = 0;
		 int timezone = 0;
		 String DST = " ";
		 String database_timezone = " ";
		 String type = " ";
		 String source_of_data = " ";
			 
			 
			 
		
		return new airports(airport_id,airport_name, city, country,IATA_code,ICAO_code, latitude, longitude, altitude, timezone, DST, database_timezone, type, source_of_data);
			
	}
	
		public static airlines airline_object(String[] airline_list) {
			int airline_id = 0;
			try {
				airline_id = Integer.parseInt(airline_list[1]);
				
				
			}catch (NumberFormatException nfe) {
				System.out.print("NumberFormatException: " + nfe.getMessage());
			}
			String airline_name = airline_list[1];
			String alias = airline_list[2];
			String IATA_code = airline_list[3];
			String ICAO_code = airline_list[4];
			String callsign = airline_list[5];
			String country = airline_list[6];
			String active = airline_list[7];
			
			
			return new airlines(airline_id, airline_name, alias, IATA_code, ICAO_code, callsign, country, active);
			
		}
		public static routes routes_object(String[] route_list) {
			int airline_id = 0;
			int source_airport_id = 0;
			int destination_airport_id = 0;
			int stops = 0;
			
			try {
				airline_id = Integer.parseInt(route_list[1]);
				source_airport_id = Integer.parseInt(route_list[3]);
				destination_airport_id = Integer.parseInt(route_list[5]);
				stops = Integer.parseInt(route_list[7]);
				
			}catch(NumberFormatException nfe ) {
				System.out.print("NumberFormatException : "+ nfe.getMessage());
			}catch(ArrayIndexOutOfBoundsException ofb) {
				
			}
			String airline_code =route_list[1];
			String source_airport_code = route_list[2];
			String destination_airport_code = route_list[4];
			String code_share = route_list[6];
			String equipment = route_list[route_list.length - 1];
			
			return new routes(airline_code, airline_id, source_airport_code, source_airport_id, destination_airport_code, destination_airport_id, code_share, stops, equipment);
			
			
			
			
		}
		public static void buffered_file_reader() {
			BufferedReader reader = null;
			try {
				File file = new File("/Users/musahamidujunior/Desktop/Intermediate Computer Programming/airports.csv");
				reader = new BufferedReader(new FileReader(file));
				String stuff;
				String[] file_object;
				while ((stuff = reader.readLine()) != null) {
					file_object = stuff.split(",");
					if (file_object.length > 14) {
						System.out.println(file_object[0]);
						System.out.println(stuff);
						System.out.println();
						
					}
				}
			}catch (FileNotFoundException fne) {
				fne.printStackTrace();
			}catch(IOException ie) {
				ie.printStackTrace();
			} finally {
				try {
					if (reader != null)
						reader.close();
					
				}catch (IOException oe) {
					oe.printStackTrace();
				}
			}
			
		}
		/*
		 * code to ensure airport_id exists for a city and country that has been inputed
		 */
		

		public static ArrayList<Integer> getAirport_id(String city, String country) {
			ArrayList<Integer> airport_id = new ArrayList<>();
			for (airports object : Mains.airport_objects) {
				if (object.getCity().equals(city) && object.getCountry().equals(country)) {
					airport_id.add(object.getAirport_id());
				}
				
			}
			return airport_id;
		}
		

		
		
	}

	
