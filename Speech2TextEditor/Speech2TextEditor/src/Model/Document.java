package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
	
	private String path;
	private ArrayList<Line> contents = new ArrayList<Line>();
	
	public Document(String path) {
		this.path = path;
	}
	
	public void appendLine(Line line) {
		contents.add(line);
	}
	
	public void createDocumentfromPath() {
		try {
			File file = new File(path); 
			Scanner myReader = new Scanner(file);
			while(myReader.hasNextLine()) {
				String line = myReader.nextLine();
				this.appendLine(new Line(line));			// TODO MAY NEED TO BE MODIFIED WITH FACTORY
			}
		}
		catch(Exception e){  
			e.printStackTrace(); 
		}
		
	}  
}
