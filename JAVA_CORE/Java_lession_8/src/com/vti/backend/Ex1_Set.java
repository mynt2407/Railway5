package com.vti.backend;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.vti.entity.Student;

public class Ex1_Set {
//	Tạo 1 student có property id, name (trong đó có 3 student có name
//			trùng nhau, id sẽ là auto increment)
//			Khai báo 1 ArrayList students, sau đó
//			a) In ra tổng số phần tử của students
//			b) Lấy phần tử thứ 4 của students
//			c) In ra phần tử đầu và phần tử cuối của students
//			d) Thêm 1 phần tử vào vị trí đầu của students
//			e) Thêm 1 phần tử vào vị trí cuối của students
//			f) Đảo ngược vị trí của students
//			g) Tạo 1 method tìm kiếm student theo id
//			h) Tạo 1 method tìm kiếm student theo name
//			i) Tạo 1 method để in ra các student có trùng tên
//			j) Xóa name của student có id = 2;
//			k) Delete student có id = 5;
//			l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
//			studentCopies
	LinkedHashSet<Student> students = new LinkedHashSet<Student>();

	Scanner scanner = new Scanner(System.in);

	// Cau a: In ra tổng số phần tử của students
	public void getAmountStudent() {
		students.add(new Student("My1"));
		students.add(new Student("My2"));
		students.add(new Student("My3"));
		students.add(new Student("My4"));
		students.add(new Student("My5"));

		System.out.println(students);
		System.out.println("--------------");

	}

	// b : Lấy phần tử thứ 4 của students
	public void getElement() {

		// cach 1: in thu cong. hihi^^

//		System.out.println("Phan tu thu 1 la:\n " + iterator.next());
//		System.out.println("Phan tu thu 2 la:\n " + iterator.next());
//		System.out.println("Phan tu thu 3 la:\n " + iterator.next());
//		System.out.println("Phan tu thu 4 la:\n " + iterator.next());

		// cach 2:
		Iterator<Student> iterator = students.iterator();
		for (int i = 0; i < 3; i++) {
			iterator.next();
		}
		System.out.println("Phan tu thu 4 la: ");
		System.out.println(iterator.next());
	}

	// c: In ra phần tử đầu và phần tử cuối của students
	public void getFirstNLast() {
		Iterator<Student> iterator = students.iterator();

		System.out.println("Phan tu dau tien la: ");
		System.out.println(iterator.next());
	
		for (int i = 0; i < students.size() - 2  ; i++) {
			iterator.next();
		}
 		System.out.println("Phan tu cuoi la:\n " + iterator.next());
	}
}
