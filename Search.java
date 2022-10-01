package ICP_Project;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Objects;


public class Search {
	
	/*
	 * Instance Variables 
	 * start_city_code as starting point, destination_city_code as destination 
	 */
	private static String start_city_code;
	private static String destination_city_code;
	
	// constructor for search class
	
	public Search(String start_city_code, String destination_city_code) {
		Search.start_city_code = start_city_code;
		Search.destination_city_code = destination_city_code;
		
	}
	@Override
	public String toString() {
		return "Journey to destination: ";
	}
	
	/*
	 * Goal test method to check if destination has been reached and also to check the hash map for the expected destination
	 */
	
	public static boolean goal_test(String location) {
		return false;
		
	}
	
	/*
	 * Method called actions to display the sequence of actions that was taken in order to reach the goal
	 */
	
	public ArrayList<ArrayList<String>> actions() {
		return null;
	}
	public static class optimal_distance extends Search{
		private static HashMap<String, ArrayList<ArrayList<String>>> my_map;
		
		/*
		 * Constructor for optimal_distance class
		 * @param my_map = hash map to take into account the key-value pairs
		 */
		
		public optimal_distance(String start_city_code, String destination_city_code, HashMap<String, ArrayList<ArrayList<String>>> my_map) {
			super(start_city_code, destination_city_code);
			optimal_distance.my_map = my_map;
		}
		
		
		/*
		 * A goal test to check if the right destination has been reached
		 */
		
		public static boolean goal_test(String location, String destination) {
			return location.equals(destination);
			
		}
		/*
		 * Method to return an array of all the routes taken to reach the destination
		 * 
		 */
		
		public static ArrayList<ArrayList<String>> actions(String source_code) {
			HashMap< String, ArrayList<ArrayList<String>>> transit = routes.route_map;
			/*
			 * Array Lists for transition cost, successor states and sequences
			 */
			
			 ArrayList<String> transition_cost = new ArrayList<>();
			 
			 ArrayList<String> successor_states = new ArrayList<>();
			 
			 ArrayList<ArrayList<String>> sequence = new ArrayList<>();
			 if(transit.containsKey(source_code)) {
				 System.out.println("Checked : " + source_code);
				 ArrayList<ArrayList<String>> values =  transit.get(source_code);
				 
				 //Looping through the array list and adding a transition cost at index 0 and a successor state at index 1 to the array list and returning the sequence
				 for(ArrayList<String> countries_on_the_way : values) {
					 transition_cost.add(countries_on_the_way.get(0));
					 successor_states.add(countries_on_the_way.get(1));
					 
				 }
				 sequence.add(transition_cost);
				 sequence.add(successor_states);
				 return sequence;
			 }
			 return sequence;
				 
			 
			
			
			
		}
	}
	
	/*
	 * Node class that implements an interface in order to get access to the CompateTo method to compare if two objects are equal
	 * 
	 * 
	 */
	
	public static class Node implements Comparable<Search.Node> {
		private String airport_code;
		private Node parent;
		private double path_cost;
		
		// Constructor for Node class
		
		public Node(String airport_code, Node parent, double path_cost) {
			this.airport_code = airport_code;
			this.parent = parent;
			this.path_cost = path_cost;
			
		}
		
		// overloading constructor
		
		public Node(String airport_code) {
			this.airport_code = airport_code;
			
		}
		
		public void solution_path() {
			ArrayList<Node> result = new ArrayList<> ();
			Node last_node = this;
			while (last_node != null) {
				result.add(0, last_node);
				last_node = last_node.parent;
			}
			wite_file(result);
			
			
		}
		// Method to write output into a file
		
		public void wite_file(ArrayList<Node> result) {
			try {
				PrintWriter out = new PrintWriter("output.txt");
				String res = null;
				int i = 0;
				for(i = 1; i < result.size(); i++) {
					res = (i) + ".From " + result.get(i).parent + " to" + result.get(i).airport_code;
					out.write(res + "\n");
					System.out.println(res);
					
				}
				
				out.write("Total Distance: " + result.get(result.size() - 1 ) .path_cost + "KM\n");
				out.write("Total number of flights: " +i);
				out.close();
			 
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				
			
			
				
				
			}
		
		}
		@Override
		public int compareTo(Search.Node o) {
			return Double.compare(this.path_cost,o.path_cost);
			
		}
		@Override
		public String toString() {
			return " " + airport_code;
			
		}
		
		@Override
		
		public boolean equals(Object o) {
			if( this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return Objects.equals(airport_code, node.airport_code);
			
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(airport_code);
			 // to prevent duplicate keys i had to override the hash code function
		}
		
		
		/*
		 * Uniform cost search to compute the optimal distance from one location to the destination
		 * 
		 */
		
//		public static boolean Uniform_cost_search ( String start_city, String destination_city) {
//			System.out.println(" Performing Uniform Cost Search from " + start_city + "to" + destination_city);
//			Node root = new Node (start_city);
//			
//			PriorityQueue<Node> frontier = new PriorityQueue<> ();
//			frontier.add(root);
//			HashSet <Node> explored = new HashSet<> ();
//			System.out.println("Initially, frontier was = " + frontier);
//			System.out.println("Initially, explored set was = " + explored);
//			while (frontier.size() > 0) {
//				Node popped_node = frontier.remove();
//				System.out.println("Checking .........");
//				if(optimal_distance.goal_test(popped_node.airport_code,destination_city)) {
//					popped_node.solution_path();
//					System.out.println("I have found a solution: " + popped_node.airport_code);
//					return true;
//					
//				}
//				explored.add(popped_node);
//				System.out.println(" Expanding : " + popped_node);
//				
//				ArrayList<String> costs = optimal_distance.actions(popped_node.airport_code).get(0);
//		        ArrayList<String> successors = optimal_distance.actions(popped_node.airport_code).get(1);
//		        
//		        for (int i = 0; i < costs.size(); i++){
//		            double old_path_cost = Double.parseDouble(costs.get(i)) + popped_node.path_cost;
//		            Node child = new Node(successors.get(i), popped_node, Double.parseDouble(costs.get(i)) + popped_node.path_cost);
//		            
//		            if (! (explored.contains(child) && frontier.contains(child))){
//		            	
//		                frontier.add(child);
//		                }
//		            
//		            else {
//		            	if (child.path_cost < old_path_cost) {
//		            		old_path_cost = child.path_cost;
//		            		child.parent = popped_node.parent;
//		            		frontier.add(child); {
//		            			
//		            		}
//		            	}
//		            		
//		            	}
//		            }
//		        
//			}
//			return false;
//			
//			
			
		}
		
		
	}

	public static boolean Uniform_cost_search(String start_city, String destination_city) {
		System.out.println(" Performing Uniform Cost Search from " + start_city + "to" + destination_city);
		Node root = new Node (start_city);
		
		PriorityQueue<Node> frontier = new PriorityQueue<> ();
		frontier.add(root);
		HashSet <Node> explored = new HashSet<> ();
		System.out.println("Initially, frontier was = " + frontier);
		System.out.println("Initially, explored set was = " + explored);
		while (frontier.size() > 0) {
			Node popped_node = frontier.remove();
			System.out.println("Checking .........");
			if(optimal_distance.goal_test(popped_node.airport_code,destination_city)) {
				popped_node.solution_path();
				System.out.println("I have found a solution: " + popped_node.airport_code);
				return true;
				
			}
			explored.add(popped_node);
			System.out.println(" Expanding : " + popped_node);
			
			ArrayList<String> costs = optimal_distance.actions(popped_node.airport_code).get(0);
	        ArrayList<String> successors = optimal_distance.actions(popped_node.airport_code).get(1);
	        
	        for (int i = 0; i < costs.size(); i++){
	            double old_path_cost = Double.parseDouble(costs.get(i)) + popped_node.path_cost;
	            Node child = new Node(successors.get(i), popped_node, Double.parseDouble(costs.get(i)) + popped_node.path_cost);
	            
	            if (! (explored.contains(child) && frontier.contains(child))){
	            	
	                frontier.add(child);
	                }
	            
	            else {
	            	if (child.path_cost < old_path_cost) {
	            		old_path_cost = child.path_cost;
	            		child.parent = popped_node.parent;
	            		frontier.add(child); {
	            			
	            		}
	            	}
	            		
	            	}
	            }
	        
		}
		// TODO Auto-generated method stub
		return false;
	}

	
	}
	
	

	
}
