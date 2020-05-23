package test;

import static org.junit.Assert.*;

import org.junit.Test;
import Control.Rot13Encoding;

public class Rot13Test {

	@Test
	public void encodeTest() {
		Rot13Encoding test = new Rot13Encoding();
		String output = test.encode("FOR");
		assertEquals("SBE",output);
	}

}
