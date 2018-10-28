package com.comcast.coding;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SumTests {

	AddDigits addDigits;
	
	@Before
	public void beforeStarting() {
		addDigits = new AddDigits();
	}
	
	//@Rule
    //public ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	private final PrintStream originalOut = System.out;
//	
//
//	@Before
//	public void setUpStreams() {
//	    System.setOut(new PrintStream(outContent));
//	}
//	
//	@After
//	public void restoreStreams() {
//	    System.setOut(originalOut);
//	}
	
	@Test
	public void testMain_Throws_Illegal_Argument_Exception(){
	    String[] args = new String[0];
	    exceptionRule.expect(Exception.class);
	    exceptionRule.expectMessage("Argument list is empty");
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
	// throws Exception
	
	@Test
	public void sumOfDigitsTest_Throws_NoSuchFileFoundException() throws Exception{
	    String[] args = {"-f", "src/daa.txt"};
	    //exceptionRule.expect(IllegalArgumentException.class);
	    //exceptionRule.expectMessage("Argument list is empty");
	    Options commandLineOptions = addDigits.parseCommandLineArgs(args);		
		addDigits.sumOfDigits(commandLineOptions);
	}
}
