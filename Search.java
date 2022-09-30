package ICP_Project;

public class Search {
	private static String start_city_code;
	private static String destination_city_code;
	public Search( String start_city_code, String destination_city_code) {
		this.start_city_code = start_city_code;
		this.destination_city_code = destination_city_code;
		
	}
	public static boolean goal_test(String location) {
		return false;
		
	}
	public static String breadthFirstSearch(String start_city_code, String destination_city_code) {
		Queue<Node> frontier = new ArrayDeque<>;
		Set<String> exploredList = new HashSet<>();
		Array
	}
	

	
}
