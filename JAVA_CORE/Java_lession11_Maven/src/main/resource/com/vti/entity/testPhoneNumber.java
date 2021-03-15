package com.vti.entity;

import com.vti.Ultils.ScannerUtils;

public class testPhoneNumber {
	public static void main(String[] args) {
		while (true) {
			System.out.print("Mời bạn nhập vào SĐT: ");
			String phone = ScannerUtils.inputPhoneNumber("Số sai! Mời nhập lại");
			return;
		}
	}
}
