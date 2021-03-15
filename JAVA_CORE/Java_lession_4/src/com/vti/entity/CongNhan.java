package com.vti.entity;

import java.util.Scanner;

public class CongNhan extends CanBo {
	private byte level;

	public CongNhan(String name, byte age, String sex, byte level) {
		super(name, age, sex);
		this.level = level;
	}

	public byte getLevel() {
		return level;
	}


	public CongNhan() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("moi ban nhap vao cap bac: ");
		byte levell = scanner.nextByte();

	}
	@Override
	public String toString() {
		String result = super.toString();
		result += "Cap do: " + level + "\n";
		return result;
	}

}
