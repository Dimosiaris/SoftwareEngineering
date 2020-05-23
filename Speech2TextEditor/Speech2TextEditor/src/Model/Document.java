package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;




public class Document {
	
	private String path;
	private ArrayList<Line> contents = new ArrayList<Line>();
	private int volume;
	private int pitch;
	private int rate;
	private String API;
	private String encryption;
	
	public Document(String path, int volume, int pitch, int rate) {
		this.path = path;
		this.volume = volume;
		this.pitch = pitch;
		this.rate = rate;
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
			myReader.close();
		}
		catch(Exception e){  
			e.printStackTrace(); 
		}
	} 
	
	public void playReversedContents(String API) {
		// Play the whole document, every line in the document
		for(int i = contents.size() - 1; i >= 0; i--) {
			contents.get(i).playReversedLine(API, volume, pitch, rate);
		}
	}
	
	public void playContents(String API) {
		// Play the whole document, every line in the document
		for(Line line : contents) {
			line.playLine(API, volume, pitch, rate);
		}
	}
	
	public void encodeContents() {
		for(Line line : contents) {
			line.encodeLine(encryption);
		}
	}
	
	public void playEncodedContents(String API) {
		encodeContents();
		// Play the whole document, every line in the document
		for(Line line : contents) {
			line.playEncodedLine(API, volume, pitch, rate);
		}
	}
	
	public void playLine(String API, int i) {
		// Play the whole document, every line in the document
		contents.get(i).playLine(API, volume, pitch, rate);
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getAPI() {
		return API;
	}

	public void setAPI(String aPI) {
		API = aPI;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}
}
