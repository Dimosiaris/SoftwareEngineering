package test;

import static org.junit.Assert.*;
import Control.AtBashEncoding;
import org.junit.Test;

public class AtBashTest {

	@Test
	public void encodeTest() {
		AtBashEncoding test = new AtBashEncoding();
		String output = test.encode("FOR");
		assertEquals("ULI", output);
		
	}

}
