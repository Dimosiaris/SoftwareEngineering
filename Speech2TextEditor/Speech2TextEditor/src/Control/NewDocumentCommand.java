package Control;

import java.io.File;
import java.io.IOException;

import View.Speech2TextEditorView;

public class NewDocumentCommand implements Command {

	Speech2TextEditorView gui;
	String filename;
	
	public NewDocumentCommand(Speech2TextEditorView gui, String filename) {
		this.filename	 = filename;
		this.gui		 = gui;
	}
	
	public void execute() {
		try {
			File myObj = new File(filename);
		    if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		    } else {
		        System.out.println("File already exists.");
		    }
		} catch (IOException err) {
		      System.out.println("An error occurred.");
		      err.printStackTrace();
	    }
	}
}
