package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
// open document panel in gui
public class OpenDocPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextArea docArea = new JTextArea();

	public OpenDocPanel() {
		setBackground(new Color(51, 153, 153));
		setBounds(6, 6, 521, 504);
		setLayout(null);
		
		docArea.setText("Open Doc Panel");
		docArea.setEditable(false);
		docArea.setBounds(0, 60, 521, 472);
		add(docArea);
		
		JLabel lblNewLabel = new JLabel("The Document:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 22));
		lblNewLabel.setBounds(30, 15, 173, 35);
		add(lblNewLabel);

	}
	// set text for the document
	public void setText(String contents) {
		docArea.setText(contents);
		return;
	}
}
