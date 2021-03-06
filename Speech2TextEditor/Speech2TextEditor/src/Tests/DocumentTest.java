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

public class DocumentTest {

	
	@Test
	public void createDocumentfromPathTest() {
		
		String filename = "test.txt";
		Document testDoc = new Document(filename, 100, 100, 100, "FakeAPI", "Rot13");
		testDoc.createDocumentfromPath();
		
		assertTrue(testDoc.getFile().exists());
		
	}
	
	public static void assertReaders(String expected,BufferedReader actual) throws IOException {
			for(String line : expected.split("\n")){
				assertEquals(line, actual.readLine());
			}
     assertNull("Actual had more lines then the expected.", actual.readLine());
	}
	
	
	@Test
	public void editAndSaveDocumentTest() throws IOException {
		String editPanelTextArea;
		String filename = "test.txt";
		Document testDoc = new Document(filename, 100, 100, 100, "FakeAPI", "Rot13");
		testDoc.createDocumentfromPath();
		String contents;
		// Get the contents from the panel
		contents = "This is the new contents";
		editPanelTextArea = contents;
		
		FileWriter myWriter = new FileWriter(filename);
	    myWriter.write(editPanelTextArea);
	    myWriter.close();
	    
	    BufferedReader in
	    = new BufferedReader(new FileReader(filename));
	    assertReaders(contents, in);

	}
	
	@Test
	public void openDocumentTest() throws IOException {
		String filename = "test.txt";
		
		Document testDoc = new Document(filename, 100, 100, 100, "FakeAPI", "Rot13");
		testDoc.createDocumentfromPath();
		
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
		
	    BufferedReader in = new BufferedReader(new FileReader(filename));
	   
	    assertReaders(contents, in);
	}	
	
	@Test
	public void tuneDocumentTest() throws IOException {
		String filename = "test.txt";
		int volume = 100;
		int pitch = 100;
		int rate = 100;
		
		Document testDoc = new Document(filename, volume, pitch, rate, "FakeAPI", "Rot13");
		testDoc.createDocumentfromPath();
		
		// TEST THE VOLUME
		assertEquals(volume, testDoc.getVolume());

		// TEST THE PITCH
		assertEquals(pitch, testDoc.getPitch());
				
		// TEST THE RATE
		assertEquals(rate, testDoc.getRate());
	}
}
