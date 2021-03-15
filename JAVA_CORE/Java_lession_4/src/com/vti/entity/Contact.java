package com.vti.entity;

import java.util.Scanner;

public class Contact {

	private int number;
	private String name;

	public Contact() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Mời bạn nhập vào sđt: ");
		number = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Mời bạn nhập tên: ");
		name = scanner.nextLine();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Tên là: " + name + "\n";
		result += "SĐT là: " + number + "\n";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		String str = (String) obj.toString();
		if (name.equals(str)) {
			return true;
		} else {
			return false;
		}

	}
}
