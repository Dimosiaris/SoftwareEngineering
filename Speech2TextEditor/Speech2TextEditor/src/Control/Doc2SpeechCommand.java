package Control;

import Model.Document;
import View.Speech2TextEditorView;

public class Doc2SpeechCommand implements Command {
	
	Document doc;
	Speech2TextEditorView gui;
	
	public Doc2SpeechCommand(Speech2TextEditorView gui){
		this.gui = gui;
		this.doc = gui.getDoc();
	}
	
	public void execute() {
		if(doc != null) {
			if(gui.getEncryptedBoxValue()) {
				doc.playEncodedContents();
			}
			else {
				doc.playContents();
			}
		}else {
			System.out.println("An error occurred. There is no document open or in edit.");
		}
	}
}
