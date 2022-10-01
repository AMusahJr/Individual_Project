package ICP_Project;
import java.util.Scanner;
import java.util.ArrayList;

	public class Mains {

		public static ArrayList<airports> airport_objects = new ArrayList<>();
		public static ArrayList<airlines> airline_objects = new ArrayList<>();
		public static ArrayList<routes> aoute_objects = new ArrayList<>();
		
		public static void main(String[]  args) {
			ArrayList<String[]> airport_stuff_array = new ArrayList<>(ReadFile.ReadFile("/Users/musahamidujunior/Desktop/Intermediate Computer Programming/airports.csv"));
			for (String[] array: airport_stuff_array) {
				airports airport_object = Objects.airport_object(array);
				airport_objects.add(airport_object);
				
				
			}
			routes.populate_hashmap();
			System.out.println(Search.Uniform_cost_search("ACC", "TML"));
		}
		

	}

