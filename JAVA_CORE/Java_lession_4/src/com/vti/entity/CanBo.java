package com.vti.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class CanBo {
	private String name;
	private byte age;
	private String sex;
	private String address;

// Cach 1
	public CanBo(String name, byte age, String sex) {
		this.name = name;
		this.age = (byte) age;
		this.sex = sex;
	}

	public CanBo() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
		
		try {
			System.out.println("Moi ban nhap vao ten: ");
			this.name = scanner.nextLine();

		} catch (InputMismatchException e) {
			System.out.println("Bạn chỉ được nhập chữ! ");
		}
		
		try {
			System.out.println("Moi ban nhap vao tuoi: ");
			this.age = scanner.nextByte();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Bạn chỉ được nhập số!");
		}

		finally {
			scanner.close();
		}
		System.out.println("Moi ban nhap vao gioi tinh: ");
		this.sex = scanner.nextLine();
		}
	}

	public String getName() {
		return name;
	}

	public byte getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	// Cau a bai 2_ex5

//	public void set_input() {
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("moi ban nhap vao ho ten day du: " + "\n");
//		String name = scanner.nextLine();
//
//		System.out.print("Moi ban nhap vao tuoi: " + "\n");
//		byte age = scanner.nextByte();
//
//		System.out.print("moi ban nhap vao gioi tinh: " + "\n");
//		String sex = scanner.nextLine();
//		scanner.nextLine();
//
//		System.out.print("Moi ban nhap vao dia chi: " + "\n");
//		String Address = scanner.nextLine();
//
//	}

	@Override
	public String toString() {
		String result = "";
		result += "Ten: " + name + "\n";
		result += "tuoi: " + age + "\n";
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		String stringName = (String) obj.toString();
		if (name.toLowerCase().equals(stringName.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

}
