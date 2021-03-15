package com.vti.entity;

import java.util.Scanner;

public class TapChi extends TaiLieu {
	private int soPhatHanh;
	private byte thangPHatHanh;

	public TapChi() {
		super();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Mời bạn nhập Số Phát hành: ");
		this.soPhatHanh = scanner.nextInt();

		System.out.print("Mời bạn nhập Tháng Phát hành: ");
		this.thangPHatHanh = scanner.nextByte();
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public byte getThangPHatHanh() {
		return thangPHatHanh;
	}

	public void setThangPHatHanh(byte thangPHatHanh) {
		this.thangPHatHanh = thangPHatHanh;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "Số phát hành Tạp Chí: " + soPhatHanh + "\n";
		result += "Tháng phát hành Tạp Chí " + thangPHatHanh + "\n";
		return result;

	}

}
