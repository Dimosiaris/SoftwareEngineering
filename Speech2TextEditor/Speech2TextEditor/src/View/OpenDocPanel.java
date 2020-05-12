package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;

public class OpenDocPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextArea docArea = new JTextArea();

	public OpenDocPanel() {
		setBackground(new Color(128, 128, 128));
		setBounds(6, 6, 521, 504);
		setLayout(null);
		
		docArea.setText("Hi");
		docArea.setEditable(false);
		docArea.setBounds(22, 6, 482, 472);
		add(docArea);

	}
	
	public void setText(String contents) {
		docArea.setText(contents);
		return;
	}

}
