package com.comcast.coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class AddDigits {
	private static final String FILE_INPUT_OPTION = "-f";
	private static final String STDIN_INPUT_OPTION = "-i";
	private static final String DECIMAL = "decimal";
	private static final String HEXA = "hexa";

	public static void main(String[] args) {
		int result = 0;
		AddDigits addDigits = new AddDigits();
		// if no arguments passed, showing result as 0
		if (args.length == 0) {
			System.out.println("0");
			throw new IllegalArgumentException("Argument list is empty");
		}

		Options commandLineOptions = addDigits.parseCommandLineArgs(args);
		System.out.println(commandLineOptions.toString());

		result = addDigits.sumOfDigits(commandLineOptions);
		System.out.println("Sum is :" + result);

	}

	// checking digit&hexa
	private boolean isDigitOrHexa(char c) {
		if ((Character.isDigit(c)) || (c >= 'a' && c <= 'f'))
			return true;
		return false;
	}

	// method to calculate sum of digits
	public int sumOfDigits(Options commandLineOptions){

		String inputSource = commandLineOptions.getInputSource();
		String numberFormat = commandLineOptions.getNumberFormat();
		String inputData = commandLineOptions.getInputData();

		int sum = 0;
		String filePath = inputData;
		Path path = Paths.get(filePath);
		HashMap<Character, Integer> hash = new HashMap<>();
		hash.put('a', 10);
		hash.put('b', 11);
		hash.put('c', 12);
		hash.put('d', 13);
		hash.put('e', 14);
		hash.put('f', 15);

		try {
			if (inputSource == "-f") {
				inputData = new String(Files.readAllBytes(path));
			}
			if (numberFormat == "decimal") {
				for (char c : inputData.toCharArray()) {
					if (Character.isDigit(c))
						sum += Character.getNumericValue(c);
				}
			} else {
				for (char ch : inputData.toCharArray()) {
					if (isDigitOrHexa(Character.toLowerCase(ch))) {
						if (Character.isDigit(ch))
							sum += Character.getNumericValue(ch);
						else
							sum += hash.get(Character.toLowerCase(ch));
					}

				}
			}
		} catch (NoSuchFileException ex) {
			ex.printStackTrace();
			//throw new NoSuchFileException("Argument list is empty");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// System.out.println("Sum of digits: " + sum);
		return sum;
	}

	// method to check entered input options are valid
	private boolean validOption(String option) {

		String[] validOptions = { "-f", "-x" };
		for (String o : validOptions) {
			if (option.equalsIgnoreCase(o)) {
				return true;
			}
		}
		return false;
	}

	// method to generate input Options object
	public Options parseCommandLineArgs(String args[]) {

		Options options = new Options("", "");
		String numberFormat = DECIMAL;
		try {
			if (args[0].startsWith("-") && !validOption(args[0])) {
				System.out.println(String.format("Error: Unknown option : %s", args[0]));
				System.exit(1);
			}

			if (args[0].equalsIgnoreCase("-x")) {
				System.out.println("0");
				System.exit(0);
			}

			if (args[0].equalsIgnoreCase("-f")) {
				if (args.length < 2) {
					System.out.println("Error: -f takes an argument");
					System.exit(1);
				}

				options.setInputSource(FILE_INPUT_OPTION);
				options.setInputData(args[1]);

				if (args.length > 2 && args[2].equalsIgnoreCase("-x")) {
					numberFormat = HEXA;
				}
				else if(args.length > 2 && !(args[2].equalsIgnoreCase("-x"))) {
					System.out.println(String.format("Error: Unknown option : %s", args[2]));
					System.exit(1);
				}

			} else {

				options.setInputSource(STDIN_INPUT_OPTION);
				options.setInputData(args[0]);

				if (args.length > 1 && args[1].equalsIgnoreCase("-x")) {
					numberFormat = HEXA;
				}
			}

			options.setNumberFormat(numberFormat);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return options;

	}

}
