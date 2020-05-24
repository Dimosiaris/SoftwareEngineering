package View;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
// edit document panel in gui
public class EditDocPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextArea docArea = new JTextArea();

	public EditDocPanel() {
		setBackground(new Color(51, 102, 102));
		setLayout(null);
		setBounds(6, 6, 521, 504);

		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(new Color(128, 128, 128));
		editPanel.setBounds(0, 60, 521, 444);
		add(editPanel);
		editPanel.setLayout(null);
		
		docArea.setBounds(0, 0, 521, 447);
		docArea.setEditable(true);
		editPanel.add(docArea);
		
		JLabel lblNewLabel = new JLabel("Edit Document:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 22));
		lblNewLabel.setBounds(30, 15, 187, 35);
		add(lblNewLabel);

	}
	// get and set the text for the document
	public void setText(String contents) {
		docArea.setText(contents);
		return;
	}
	
	public String getText() {
		return docArea.getText();
	}


}
