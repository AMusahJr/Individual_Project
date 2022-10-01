package ICP_Project;
import java.util.ArrayList;

public class inputs {
	
	public static String [ ] readInput (String filename) {
		
		String[] res = new String[2];
		ArrayList<String[]> city_country_Array;
		city_country_Array = new ArrayList<> (ReadFile.ReadFile(filename));
		for (int i = 0; i < city_country_Array.size(); i++) {
			String code = Objects.getAirport_id(city_country_Array.get(i) [0] ,city_country_Array.get(i)[1]);
			res[i] = code;
			
		}
		return res;
	}

}
