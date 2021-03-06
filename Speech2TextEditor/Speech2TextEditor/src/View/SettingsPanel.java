package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.en.us.CMUDiphoneVoice;

import Model.Document;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SettingsPanel extends JPanel {


	private Document document;
	private int volume;
	private int pitch;
	private int rate;
	private String API;
	private String encryption;
	
		/**
	 * Create the panel.
	 */
	public SettingsPanel() {
	
		// Initialization of parameters
		API = "FreeTTS";
		encryption = "Rot13";
		setBackground(Color.DARK_GRAY);
		setBounds(6, 6, 521, 504);
		setLayout(null);
		
		
		JLabel titleLabel = new JLabel("Settings");
		titleLabel.setBounds(167, 28, 154, 46);
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		add(titleLabel);
		
		JRadioButton freeTTSRadioButton = new JRadioButton("Free TTS");
		freeTTSRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				API = "FreeTTS";
				document.setAPI(API);
			}
		});
		freeTTSRadioButton.setSelected(true);
		freeTTSRadioButton.setForeground(Color.WHITE);
		freeTTSRadioButton.setBounds(282, 115, 141, 23);
		add(freeTTSRadioButton);
		
		JRadioButton FakeAPIRadioButton = new JRadioButton("Fake API");
		FakeAPIRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				API = "FakeAPI";
				document.setAPI(API);
			}
		});
		FakeAPIRadioButton.setForeground(Color.WHITE);
		FakeAPIRadioButton.setBounds(282, 162, 141, 23);
		add(FakeAPIRadioButton);
		
		ButtonGroup APIGroup = new ButtonGroup();
		APIGroup.add(FakeAPIRadioButton);
		APIGroup.add(freeTTSRadioButton);
		
		JLabel chooseAPILabel = new JLabel("Choose API:");
		chooseAPILabel.setForeground(Color.WHITE);
		chooseAPILabel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		chooseAPILabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAPILabel.setBounds(45, 139, 131, 33);
		add(chooseAPILabel);
		
		JRadioButton rot13RadioButton = new JRadioButton("Rot 13");
		rot13RadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encryption = "Rot13";
				document.setEncryption(encryption);
			}
		});
		rot13RadioButton.setSelected(true);
		
		rot13RadioButton.setForeground(Color.WHITE);
		rot13RadioButton.setBounds(282, 232, 141, 23);
		add(rot13RadioButton);
		
		JRadioButton atBashRadioButton = new JRadioButton("At Bash");
		atBashRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encryption = "AtBash";
				document.setEncryption(encryption);
			}
		});
		atBashRadioButton.setForeground(Color.WHITE);
		atBashRadioButton.setBounds(282, 278, 141, 23);
		add(atBashRadioButton);
		
		JLabel encryptionLabel = new JLabel("Encryption:");
		encryptionLabel.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		encryptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		encryptionLabel.setForeground(Color.WHITE);
		encryptionLabel.setBounds(45, 244, 131, 33);
		add(encryptionLabel);
		
		ButtonGroup encryptionGroup = new ButtonGroup();
		encryptionGroup.add(rot13RadioButton);
		encryptionGroup.add(atBashRadioButton);
		
		JSlider pitchSlider = new JSlider();
		pitchSlider.setValue(110);
		pitchSlider.setMaximum(250);
		pitchSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(pitchSlider.getValue());
				document.setPitch(pitchSlider.getValue());
			}
		});
		
		pitchSlider.setToolTipText("Pitch");
		pitchSlider.setBounds(233, 396, 190, 29);
		add(pitchSlider);
		
		JSlider volumeSlider = new JSlider();
		volumeSlider.setMinorTickSpacing(10);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setValue(70);
		this.volume = 70;
		volumeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(volumeSlider.getValue());
				document.setVolume(volumeSlider.getValue());
			}
		});
		
		volumeSlider.setBounds(233, 355, 190, 29);
		add(volumeSlider);
		
		JSlider rateSlider = new JSlider();
		rateSlider.setMaximum(200);
		rateSlider.setValue(125);
		rateSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(rateSlider.getValue());
				document.setRate(rateSlider.getValue());
			}
		});
		
		rateSlider.setBounds(233, 437, 190, 29);
		add(rateSlider);
		
		JLabel volumeSliderLabel = new JLabel("Volume:");
		volumeSliderLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		volumeSliderLabel.setForeground(Color.WHITE);
		volumeSliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumeSliderLabel.setBounds(65, 355, 111, 16);
		add(volumeSliderLabel);
		
		
		JLabel pitchSliderLabel = new JLabel("Pitch:");
		pitchSliderLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		pitchSliderLabel.setForeground(Color.WHITE);
		pitchSliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pitchSliderLabel.setBounds(65, 402, 111, 16);
		add(pitchSliderLabel);
		
		JLabel rateSliderLabel = new JLabel("Rate:");
		rateSliderLabel.setForeground(Color.WHITE);
		rateSliderLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		rateSliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rateSliderLabel.setBounds(65, 449, 111, 16);
		add(rateSliderLabel);
		
		
	}

	public String getAPI() {
		return API;
	}

	public void setAPI(String api) {
		API = api;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public void setDocument(Document doc) {
		this.document = doc;
	}
}
