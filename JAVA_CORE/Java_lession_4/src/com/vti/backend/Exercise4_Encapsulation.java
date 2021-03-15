package com.vti.backend;

import com.vti.entity.Account1;
import com.vti.entity.Date1;
import com.vti.entity.Student_Ex;

public class Exercise4_Encapsulation {
	public static void main(String[] args) {
//		question1();
//		question1c();
//		question1d();
//		question1e();
		question2();
	}

//	Exercise 4 : Encapsulation
//	Question 1:
//	Tạo Object Student có các property id, name, hometown, điểm học lực
//	a) Tất cả các property sẽ để là private để các class khác không
//	chỉnh sửa hay nhìn thấy
//	b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//	dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//	c) Tạo 1 method cho phép set điểm vào
//	d) Tạo 1 method cho phép cộng thêm điểm
//	e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//	điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//	4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//	thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
//	Demo các chức năng trên bằng class ở front-end

	public static void question1() {
		// Cau b
		Student_Ex student = new Student_Ex("Nguyen thi my", "Nam Dinh");

		student.setName("Nguyen Ngoc Duy");
		System.out.println(student.getName());

		student.setHomeTown("Ha Noi");
		System.out.println(student.getHomeTown());

		System.out.println(student.getPoint());

	}

	public static void question1c() {
		Student_Ex student = new Student_Ex("Tong Thi Nhung", "Nghe An");
		student.setPoint(7);
		System.out.println(student.getPoint());
	}

	public static void question1d() {
		Student_Ex student = new Student_Ex("Tong Thi Nhung", "Nghe An");
		student.setPoint(10);
	}

	public static void question1e() {
		Student_Ex student = new Student_Ex("Nhung", (float) 8.2);
		student.getName();
		student.getPoint2();
	}

//	Question 2 (Optional): Tạo class phù hợp cho thiết kế sau:
	public static void question2() {
//		Account1 account = new Account1("abc123", "my", 20);
//		account.debit(30);
//		System.out.println("\n");
//		account.credit(50);

//		Account1 account1 = new Account1("mynguyen123", "mynt", 60);
//		Date1 date = new Date1(20, 3, 100);
//		System.out.println(date.getDay());

		int months[] = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int j = 0; j < months.length -1 ; j++) {

			for (int i = 0; i < months.length  ; i++) {
				if (months[i] == months[i] + 1) {
					System.out.println("Nam nay la nam nhuan!");
					break;
				} else {
					System.out.println("Nam nay khong phai nam nhuan!");
				}
			}
		}
	}

}
