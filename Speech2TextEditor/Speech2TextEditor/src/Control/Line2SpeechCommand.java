package Control;

import Model.Document;
import View.Speech2TextEditorView;

public class Line2SpeechCommand implements Command {

	Document 				doc;
	Speech2TextEditorView 	gui;
	int						line;
	 
	public Line2SpeechCommand(Speech2TextEditorView gui, int line){
		this.gui 	= gui;
		this.doc 	= gui.getDoc();
		this.line	= line;
	}
	
	public void execute() {
		if(doc != null) {
			if(gui.getEncryptedBoxValue()) {
				doc.playEncodedLine(line);
			}
			else {
				doc.playLine(line);
			}
		}else {
			System.out.println("An error occurred. There is no document open or in edit.");
		}
	}
}
