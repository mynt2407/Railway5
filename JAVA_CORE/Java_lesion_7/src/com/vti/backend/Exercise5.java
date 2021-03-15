package com.vti.backend;

import java.util.Scanner;

import com.vti.Utils.IO_Stream;
import com.vti.Utils.ScannerUtils;

public class Exercise5 {
//	Exercise 5: Demo File & IO Stream
//	Question 1: Tạo class Student có property id, name.
//	a) Sau đó khởi 3 instance từ console (sử dụng ScannerUtils)
//	b) Write 3 student này ra file tên là StudentInformation.txt
//	c) Sau đó đọc thông tin file StudentInformation.txt và in ra màn hình

	public static void question1() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ban muon nhap bao nhieu hoc sinh? ");
		int number = scanner.nextInt();
		for (int i = 0; i < number; i++) {

			System.out.print("Moi ban nhap id: ");
			int id = ScannerUtils.inputPositiveInt("Ban phai nhap vao so lon hon 0! Moi nhap lai!");

			System.out.print("Moi ban nhap vao ten: ");
			String name = ScannerUtils.inputName();
			IO_Stream.writeFile("C:\\Users\\MyNguyen\\Desktop\\StudentInformation.txt", true,
					"Student " + (i + 1) + " :\n" + "        ID la: " + id + "\n" + "        Ten la: " + name + "\n");

		}
		IO_Stream.readFile("C:\\Users\\MyNguyen\\Desktop\\StudentInformation.txt");
	}

}
