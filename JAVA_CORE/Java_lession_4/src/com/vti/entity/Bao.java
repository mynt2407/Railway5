package com.vti.entity;

import java.util.Date;
import java.util.Scanner;

public class Bao extends TaiLieu {
	private String ngayPhatHanh;

	public Bao() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào Ngày phát hành: ");
		this.ngayPhatHanh = scanner.nextLine();
		scanner.nextLine();
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "Ngày phát hành Báo là: " + ngayPhatHanh + "\n";
		return result;
	}
}
