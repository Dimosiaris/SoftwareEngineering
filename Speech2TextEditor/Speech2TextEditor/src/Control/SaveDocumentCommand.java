package Control;

import java.io.FileWriter;
import java.io.IOException;

import Model.Document;
import View.Speech2TextEditorView;

public class SaveDocumentCommand implements Command {
	
	Speech2TextEditorView 	gui;
	String 				  	filename;
	int 			     	volume;
	int 				 	pitch;
	int 					rate;
	String 					API;
	String 					encryption;
	
	public SaveDocumentCommand(Speech2TextEditorView gui, String filename, int volume, int pitch, int rate, String API, String encryption) {
		this.gui 			= gui;
		this.filename 		= filename;
		this.volume 		= volume;
		this.pitch 			= pitch;
		this.rate 			= rate;
		this.API 			= API;
		this.encryption 	= encryption;
	}

	public void execute() {
		try {
		      FileWriter myWriter = new FileWriter(filename);
		      myWriter.write(gui.getEditDocPanel().getText());
		      myWriter.close();
		      
		      // Create the new Document
			  Document doc = new Document(filename, volume,  pitch,  rate,  API,  encryption);
			  gui.setDoc(doc);
			
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException err) {
			  System.out.println("An error occurred.");
			  err.printStackTrace();
		}
	}
}
