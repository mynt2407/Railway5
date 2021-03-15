package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.PHONE;

import com.vti.entity.VNPHONE;

public class Excercise6_Abstraction {

//Question 1: abstract class & abstract method
//Tạo 1 class Phone để lưu thông tin liên lạc, trong Phone có chứa 1
//property có kiểu dữ liệu là Array contacts, trong từng contact có lưu thông tin number, name
//a) Tạo các abstract method
//a. void insertContact(String name, String phone)
//b. void removeContact(String name)
//c. void updateContact(String name, String newPhone)
//d. void searchContact(String name)
//b) Tạo class VietnamesePhone kế thừa Phone và triển khai các method abstract
//Viết chương trình demo 
	public static void question1() {

		VNPHONE vnPhone = new VNPHONE();
		Scanner scanner = new Scanner(System.in);

		System.out.println(" + 1: Thêm SĐT\n + 2: Xóa SĐT\n + 3: In SĐT\n + 4: Tìm kiếm SĐT\n + 5: update SĐT\n");

		while (true) {
			System.out.print("Mời bạn nhập vào chức năng muốn sử dụng: ");
			int choose = scanner.nextInt();

			switch (choose) {
			case 1:
				vnPhone.insertContact();
				break;
			case 2:
				vnPhone.removeContact();
				break;
			case 3:
				vnPhone.print();
				break;
			case 4:
				vnPhone.searchContact();
				break;
			case 5:
				vnPhone.updateContact();
				break;
			case 6:
				System.out.println("Chương trình kết thúc!");
				return;
			default:
				System.out.println("Bạn đã nhập sai. Mời bạn nhập lại!");
				break;
			}
		}
	}
}
