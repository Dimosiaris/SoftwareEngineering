package Control;

import View.Speech2TextEditorView;

public class SettingsButtonCommand implements Command {

	Speech2TextEditorView gui;
	
	public SettingsButtonCommand(Speech2TextEditorView gui) {
		this.gui	= gui;
	}
	public void execute() {
		gui.setPanel(gui.getSettingsPanel());
	}
}
