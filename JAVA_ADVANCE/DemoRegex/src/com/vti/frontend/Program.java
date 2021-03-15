package com.vti.frontend;

import java.util.regex.Pattern;

public class Program {
	public static void main(String[] args) {
	//	inputCharacter();
	//	repetitions();
		anyWhiteSpace();
	}

	public static void inputCharacter() {

		// input from user
		String input = "z";

		Pattern pattern = Pattern.compile("[a-l]");

		boolean result = pattern.matcher(input).matches();

		System.out.println(result);
	}
	
	public static void repetitions() {

		// input from user
		String input = "aacc";

		Pattern pattern = Pattern.compile("aa+b*c+");

		boolean result = pattern.matcher(input).matches();

		System.out.println(result);
	}
	
	public static void anyWhiteSpace() {

		// input from user
		String input = "3.    my nguyen";

		Pattern pattern = Pattern.compile("\\d\\.\\s+.+");

		boolean result = pattern.matcher(input).matches();

		System.out.println(result);
	}
}
