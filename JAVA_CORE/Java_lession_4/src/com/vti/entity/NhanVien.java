package com.vti.entity;

import java.util.Scanner;

public class NhanVien extends CanBo {
	private String work;

	public NhanVien(String name, byte age, String sex, String work) {
		super(name, age, sex);
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	public NhanVien() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao cong viec cua ban: ");
		String work = scanner.nextLine();

	}
	@Override
	public String toString() {
		String result = super.toString();
		result += "Cong viec duoc phan cong la: " + work + "\n";
		return result;
	}

}