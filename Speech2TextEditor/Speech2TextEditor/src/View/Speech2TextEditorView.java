package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Speech2TextEditorView {

	private JFrame frame;	
	
	// The Panels
	private JPanel sidePanel;
	private JPanel mainPanel;
	private OpenDocPanel openDocPanel;
	private JLabel titleLabel;
	private EditDocPanel editDocPanel;
	private JButton saveButton;
	private JButton newDocButton;
	
	// The filename we're working on
	private String filename;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Speech2TextEditorView window = new Speech2TextEditorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Speech2TextEditorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setPanel(JPanel panel) {
		mainPanel.setVisible(false);
		openDocPanel.setVisible(false);
		editDocPanel.setVisible(false);
		
		panel.setVisible(true);
		System.out.println("DID IT");
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// Panels Initialization
		
		openDocPanel = new OpenDocPanel();
		openDocPanel.setBounds(214, 6, 538, 485);
		openDocPanel.setVisible(false);
		frame.getContentPane().add(openDocPanel);
		
		editDocPanel = new EditDocPanel();
		editDocPanel.setBounds(214, 6, 538, 485);
		editDocPanel.setVisible(false);
		frame.getContentPane().add(editDocPanel);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(0, 128, 128));
		sidePanel.setBounds(6, 6, 196, 496);
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		TextArea startingTextArea = new TextArea();
		
		JButton openDocButton = new JButton("Open Document");
		openDocButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename = startingTextArea.getText();
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
				setPanel(openDocPanel);
				openDocPanel.setText(contents);
			}
		});
		openDocButton.setBounds(21, 148, 146, 29);
		sidePanel.add(openDocButton);
		
		JButton editDocButton = new JButton("Edit Document");
		editDocButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename = startingTextArea.getText();
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
				setPanel(editDocPanel);
				editDocPanel.setText(contents);
			}
		});
		editDocButton.setBounds(21, 199, 136, 29);
		sidePanel.add(editDocButton);
		
		titleLabel = new JLabel("TEXT 2 SPEECH");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		titleLabel.setForeground(new Color(255, 255, 240));
		titleLabel.setBounds(21, 26, 146, 47);
		sidePanel.add(titleLabel);
		
		JButton titleButton = new JButton("Home");
		titleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(mainPanel);
			}
		});
		titleButton.setBounds(21, 97, 117, 29);
		sidePanel.add(titleButton);
		
		saveButton = new JButton("Save Document");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SAVE BUTTON
				try {
				      FileWriter myWriter = new FileWriter(filename);
				      myWriter.write(editDocPanel.getText());
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				    } catch (IOException err) {
					      System.out.println("An error occurred.");
					      err.printStackTrace();
				    }
			}
		});
		saveButton.setBounds(21, 251, 146, 29);
		sidePanel.add(saveButton);
		
		newDocButton = new JButton("New Document");
		newDocButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				filename = startingTextArea.getText();
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
		});
		newDocButton.setBounds(21, 302, 136, 29);
		sidePanel.add(newDocButton);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(UIManager.getColor("MenuBar.disabledForeground"));
		mainPanel.setBounds(214, 6, 538, 496);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		
		
		
		
		
		startingTextArea.setText("abc.txt");
		startingTextArea.setBounds(0, 0, 538, 496);
		mainPanel.add(startingTextArea);		
		
	}
}
