package Model;

import java.util.ArrayList;

import Control.EncodingStrategy;
import Control.StrategiesFactory;
import Control.TextToSpeechAPI;
import Control.TextToSpeechAPIFactory;

public class Line {
	
	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> encodedWords = new ArrayList<String>();
	private String line;
	private String encodedLine;
	// initialize line
	public Line(String line) {
		this.line = line;
		String s[] = line.split("\\s+");
		for(String i : s) {
			words.add(i);
		}
	}
	// get words in regular order
	public String getWords() {
		String line = "";
		for(String word : words) {
			line += word;
		}
		return line;
	}
	// get words in reverse order
	public String getReversedWords() {
		String line = "";
		for(String word : words) {
			line = word + line;
		}
		return line;
	}

	// play given line in regular order
	public void playLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI(API);
		// Play the words
		text2speech.play(getWords(), volume, pitch, rate);
	}
	
	// play given line in reverse order
	public void playReversedLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI("FreeTTS");
		// Play the words
		text2speech.play(getReversedWords(), volume, pitch, rate);
	}
	// encode given line with rot13 or AtBash
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
	// get encoded words with rot13 or AtBash
	public String getEncodedWords() {
		String returnLine = "";
		for(String word : encodedWords) {
			returnLine += word;
		}
		return returnLine;
	}
	
	// play the given line encoded with rot13 or AtBash
	public void playEncodedLine(String API, int volume, int pitch, int rate) {
		// Create the factory and the API
		TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
		TextToSpeechAPI text2speech = factory.createAPI("FreeTTS");
		// Play the words
		text2speech.play(getEncodedWords(), volume, pitch, rate);
		encodedWords.clear();
	}
}

