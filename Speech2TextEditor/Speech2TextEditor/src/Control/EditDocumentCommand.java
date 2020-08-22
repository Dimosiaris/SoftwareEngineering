package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Model.Document;
import View.Speech2TextEditorView;

public class EditDocumentCommand implements Command {
	
	Speech2TextEditorView 	gui;
	String 				  	filename;
	int 			     	volume;
	int 				 	pitch;
	int 					rate;
	String 					API;
	String 					encryption;
	
	public EditDocumentCommand(Speech2TextEditorView gui, String filename, int volume, int pitch, int rate, String API, String encryption) {
		
		this.gui 			= gui;
		this.filename 		= filename;
		this.volume 		= volume;
		this.pitch 			= pitch;
		this.rate 			= rate;
		this.API 			= API;
		this.encryption 	= encryption;
	}
	
	public void execute() {		
		// Create the Document
		Document doc = new Document(filename, volume,  pitch,  rate,  API,  encryption);
		doc.createDocumentfromPath();
		gui.getSettingsPanel().setDocument(doc);
		
		String contents = "";
		try {
			 File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		          contents += data;
		          contents += "\n";
		      }
		      myReader.close();
		}catch (FileNotFoundException err) {
			 System.out.println("An error occurred.");
		     err.printStackTrace();
		}
		gui.setDoc(doc);
		gui.setPanel(gui.getEditDocPanel());
		gui.getEditDocPanel().setText(contents);
	}
}