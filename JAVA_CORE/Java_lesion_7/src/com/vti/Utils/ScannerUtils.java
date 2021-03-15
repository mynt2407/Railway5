package com.vti.Utils;

import java.util.Scanner;



// NHẬP VÀO S�? NGUYÊN DƯƠNG
public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int id = ScannerUtils.inputInt(errorMessage);
			if (id < 0) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}

	
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = scanner.nextLine();
				input = input.trim();
				int output = Integer.parseInt(input);
				return output;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	// NHẬP VÀO TIỀN
	
	public static float inputPositiveMoney(String erroMessage2) {
		while (true) {
			float money = ScannerUtils.inputMoney(erroMessage2);
			if (money < 0) {
				System.err.print(erroMessage2);
			} else {
				return money;
			}
		}
	}


	public static float inputMoney(String errorMessage) {
		while (true) {
			try {
				String inputMoney = scanner.nextLine();
				inputMoney = inputMoney.trim();
				float outputMoney = Float.parseFloat(inputMoney);
				return outputMoney;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	// NHẬP VÀO TÊN VÀ CHUẨN HÓA TÊN:
	
	public static String inputString(String errorMessage) {
		String inputString = scanner.nextLine();
		inputString = inputString.trim();
		inputString = inputString.replaceAll("\\s+", " ");

		return inputString;
	}

	public static String inputName() {
		
		String name = ScannerUtils.inputString("Ban phai nhap vao ten!");

		String[] words = name.split(" ");
		name = "";
		for (String word : words) {

			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1).toLowerCase();
			word = firstCharacter + leftCharacter;
			name += word + " ";
		}
		return name;
	}
}
