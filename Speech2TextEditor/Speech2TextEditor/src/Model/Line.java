package Model;

import java.util.ArrayList;

import Control.EncodingStrategy;
import Control.FakeTextToSpeechAPI;
import Control.StrategiesFactory;
import Control.TextToSpeechAPI;
import Control.TextToSpeechAPIFactory;

public class Line {
	
	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> encodedWords = new ArrayList<String>();
	private String line;
	private String encodedLine;
	
	public Line(String line) {
		this.line = line;
		String s[] = line.split("\\s+");
		for(String i : s) {
			words.add(i);
		}
	}
	
	public String getWords() {
		String line = "";
		for(String word : words) {
			line += word;
		}
		return line;
	}
	
	public String getReversedWords() {
		String line = "";
		for(String word : words) {
			line = word + line;
		}
		return line;
	}

	public void playLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI(API);
		// Play the words
		text2speech.play(getWords(), volume, pitch, rate);
	}
	
	public void playReversedLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI("FreeTTS");
		// Play the words
		text2speech.play(getReversedWords(), volume, pitch, rate);
	}
	
	public void encodeLine(String encryption) {
		// Create the factory
		StrategiesFactory factory = new StrategiesFactory();
		EncodingStrategy encodingStrategy = factory.createStrategy(encryption);
		
		// The encoding of the line
		encodedLine = encodingStrategy.encode(line);
		String s[] = encodedLine.split("\\s+");
		for(String i : s) {
			encodedWords.add(i);
		}
	}
	
	public String getEncodedWords() {
		String returnLine = "";
		for(String word : encodedWords) {
			returnLine += word;
		}
		return returnLine;
	}
	
	public void playEncodedLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI("FreeTTS");
		// Play the words
		text2speech.play(getEncodedWords(), volume, pitch, rate);
		encodedWords.clear();
	}
	public String playFakeLine(int volume, int pitch, int rate) {
		// Create the factory and the API
		FakeTextToSpeechAPI fakeAPI = new FakeTextToSpeechAPI();
		
		// Play the words
		fakeAPI.play(getWords(), volume, pitch, rate);
		return fakeAPI.getTextToBePlayed();
	}
}

