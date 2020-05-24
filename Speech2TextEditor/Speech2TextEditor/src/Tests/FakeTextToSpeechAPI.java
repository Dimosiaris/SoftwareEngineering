package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import Model.Document;

public class FakeTextToSpeechAPI {

	public static void assertReaders(String expected,BufferedReader actual) throws IOException {
		for(String line : expected.split("\n")){
			String cont[] = line.split(" ");
			String newLine = "";
			for(String x : cont) {
				newLine += x;
			}
			assertEquals(newLine, actual.readLine());
		}
		assertNull("Actual had more lines then the expected.", actual.readLine());
	}

	@Test
	public void playTest() throws IOException {
		String filename = "test.txt";
		Document testDoc = new Document(filename, 100, 100, 100, "FakeAPI", "Rot13");
		testDoc.createDocumentfromPath();
		
		
	    BufferedReader in
	    = new BufferedReader(new FileReader(filename));
	    
	    String conts = "";
	    String x;
	    while((x = in.readLine()) != null) {
	    	String line[] = x.split(" ");
	    	for(String y : line) {
				conts += y;
			}
	    }
	    
		assertEquals(conts, testDoc.playFake());
	}

}
