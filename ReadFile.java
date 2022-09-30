package ICP_Project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	public static ArrayList<String[]> ReadFile(String filename) {
		ArrayList<String[]> contents = new ArrayList<>();
			BufferedReader reader = null;
		try {
			File file = new File(filename);
			reader = new BufferedReader(new FileReader(file));
			String stuff;
			String[] file_object;
			String[] new_object;
			
			while ((stuff = reader.readLine()) != null) {
				
				file_object = stuff.split(",");
				contents.add(file_object);
				
				
			}
		}catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			
		}
		finally {
			try {
				if (reader != null)
					reader.close();
				
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		} return contents;
	}
	

}
