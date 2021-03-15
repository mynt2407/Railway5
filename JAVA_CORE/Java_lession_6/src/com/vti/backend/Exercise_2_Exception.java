package com.vti.backend;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.entity.InvValidAgeLessZero;
import com.vti.entity.ScannerUtils;


public class Exercise_2_Exception {

//	public static Department[] initDepartments() {
//		Department[] departments = new Department[3];
//
//		Department department1 = new Department(1, "my nguyen");
//		Department department2 = new Department(2, "my nguyen123");
//		Department department3 = new Department(3, "my nguyen1234");
//
//		return departments;
//	}

	// public Department[] departments = { department1, department2, department3 };

	public static void question3() {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (ArithmeticException e) {
			System.out.println("Ket qua chua dung!");
		} finally {
			System.out.println("Chuong trinh ket thuc!");
		}

	}
//	Question4
//	Tạo 1 array departments gồm 3 phần tử
//	Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ 
//	index trong array departments. Nếu index vượt quá length lấy ra thì sẽ
//	in ra text "Cannot find department."

	public static void getIndex(int index) throws Exception {
		Department[] departments = new Department[3];
		try {
			System.out.println(departments[index]);
		} catch (IndexOutOfBoundsException iob) {
			throw new IndexOutOfBoundsException("Cannot find department!");
		}
	}

//Question 5:Tạo 1	method inputAge() và trả về 1 số int.
//Trong method hãy cài đặt như sau:
//B1: dùng scanner để nhập vào 1 số
//B2: Check exeption
//Nếu người dùng nhập vào 1 số thì return về số đó
//Nếu người dùng không nhập vào 1 số thì sẽ in ra dòng
//text "wrong inputing! Please input an age as int, input
//again."
//Nếu người dùng không nhập vào 1 số < 0 thì sẽ in ra
//dòng text "Wrong inputing! The age must be greater
//than 0, please input again."
//B3: hãy demo trong method main()

	public static int inputAge() throws InvValidAgeLessZero {
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("please input your age!");
			int age = scanner.nextInt();
			System.out.println("Tuổi là : " + age);
			if (age < 0) {
				throw new InvValidAgeLessZero("Wrong inputing! The age must be greater than 0");
			}
			return age;

		} catch (InputMismatchException ime) {
			throw new InputMismatchException("wrong inputing! Please input an age as int, input again");

		} finally {
			System.out.println("finish!");
		}
	}

//	Question 6: Tiếp tục Question 5
//	Sửa lại method inputAge() như sau:
//	Tại B2 của Question 5, Nếu người dùng không nhập vào 1 số thì sẽ in
//	ra dòng text "wrong inputing! Please input an age as int, input again.",
//	đồng thời yêu cầu người dùng nhập lại
//	Gợi ý: sử dụng while

	public static int inputAge1() throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			try {
				System.out.println("please input your age! ");
				int age = scanner.nextInt();
				System.out.println("Tuổi là: " + age);
				return age;

			} catch (InputMismatchException ime) {
				System.out.println("Wrong inputing! Please input an age as int, input again");
				scanner.nextLine();

			}
		}
	}

	// Question 7:
	public static void idInput() {

		System.out.println("Nhập id: ");
		int id = ScannerUtils.inputPositiveInt("id phải là 1 số nguyên dương, mời nhập lại! ");
		System.out.println("id của bạn: " + id);
	}

	// Question 8:
	public static void inputFloat() {
		System.out.print("Mời bạn nhập số tiền: ");
		float money = ScannerUtils.inputPositiveMoney("Số tiền phải là số thực. Mời nhập lại! ");
		System.out.println("So tien cua ban la: " + money);
	}

}