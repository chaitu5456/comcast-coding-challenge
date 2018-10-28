package com.comcast.coding;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;


public class SumTests {

	AddDigits addDigits;
	
	@Before
	public void beforeStarting() {
		addDigits = new AddDigits();
	}
	
	@Test
	public void testMain_Throws_Illegal_Argument_Exception() throws Exception{
	    String[] args = new String[0];
	    AddDigits.main(args);
	}
	
	@Test
	public void sumOfDigitsTest1() {
		String[] args = {"abc"};	
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(0, addDigits.sumOfDigits(commandLineOptions));
	}

	@Test
	public void sumOfDigitsTest2() {
		String[] args = {"abc", "-x"};
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(33, addDigits.sumOfDigits(commandLineOptions));
	}
	
	@Test
	public void sumOfDigitsTest3() throws IOException {
		String[] args = {"-f", "src/data.txt"};
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(6, addDigits.sumOfDigits(commandLineOptions));
	}
	
	@Test
	public void sumOfDigitsTest4() {
		String[] args = {"-f", "src/data.txt", "-x"};
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(39, addDigits.sumOfDigits(commandLineOptions));
	}
	
	@Test
	public void sumOfDigitsTest5() {
		// if option is in wrong order it ignores
		String[] args = {"abc", "-f", "-x"};
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(0, addDigits.sumOfDigits(commandLineOptions));
	}
	
	@Test
	public void sumOfDigitsTest6() {
		String[] args = {"qq"};
		Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		assertEquals(0, addDigits.sumOfDigits(commandLineOptions));
	}
	// throws Exception
	
	@Test
	public void sumOfDigitsTest_Throws_NoSuchFileFoundException() throws Exception{
	    String[] args = {"-f", "src/daa.txt"};
	    Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		addDigits.sumOfDigits(commandLineOptions);
	}
}
