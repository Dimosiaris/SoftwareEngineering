package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.AtBashEncoding;

public class AtBashTest {

	@Test
	public void encodeTest() {
		AtBashEncoding test = new AtBashEncoding();
		String output = test.encode("FOR", "AtBash");
		assertEquals("ULI", output);
		
	}
}
