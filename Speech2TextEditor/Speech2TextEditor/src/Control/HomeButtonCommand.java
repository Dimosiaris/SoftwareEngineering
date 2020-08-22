package Control;

import View.Speech2TextEditorView;

public class HomeButtonCommand implements Command{

	Speech2TextEditorView gui;
	
	public HomeButtonCommand(Speech2TextEditorView gui) {
		this.gui	= gui;
	}
	public void execute() {
		gui.setPanel(gui.getMainPanel());
	}
}
