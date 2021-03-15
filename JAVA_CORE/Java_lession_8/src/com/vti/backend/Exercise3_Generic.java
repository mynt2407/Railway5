package com.vti.backend;

import java.util.HashMap;

import com.vti.entity.Student_gen;

public class Exercise3_Generic {
//	Question 1: T generic (class)
//	Tạo class student có property id, name (trong đó id của student có thể
//	là int, long, float)
//	a) Tạo đối tượng student có id là int
//	b) Tạo đối tượng student có id là float
//	c) Tạo đối tượng student có id là double

	public static void question1() {
		Student_gen<Float> student1 = new Student_gen<Float>(2f, "Neo");
		Student_gen<Integer> student2 = new Student_gen<Integer>(2, "Neo123");
		Student_gen<Long> student3 = new Student_gen<Long>(2l, "Neo1234");

	}
//	Question 2: T generic (method)
//	Tạo method để in ra thông tin nhập vào (parameter)
//	(parameter có thể là họ và tên, hoặc student, hoặc int)
//	Gợi ý: tạo method print(T a) và cài đặt system out (a) ra
//	Demo chương trình với print(student), print(4), print(4.0)

	public static <T> void print(T a) {
		System.out.println(a);

	}

//	Question 4: E generic
//	Tạo 1 array int, 1 array float, 1 array long, 1 array double
//	Tạo 1 method có parameter là array và in ra các số trong array đó

	public static <T> void question4(T[] array) {
		for (T t : array) {
			System.out.println(t);
		}
	}
	// Question 5:
//		Tạo 1 class Employee có property id, name, salaries với salaries là
//		lương các tháng của Employee đó và là 1 array có data type có thể là
//		int, long, float.
//		Viết method trong Employee để in ra thông tin của Employee bao gồm
//		id, name, salaris.
//		Viết method trong Employee để in ra thông tin tháng lương cuối cùng
//		của Employee
//		a) Hãy tạo chương trình demo với Employee có salaries là
//		datatype int
//		b) Hãy tạo chương trình demo với Employee có salaries là
//		datatype float
//		c) Hãy tạo chương trình demo với Employee có salaries là
//		datatype double

	public static <S> void question5(S[] salaries) {
		for (S s : salaries) {
			System.out.println(s);
		}
	}
//	

//	Question 6 + 7:  K & V generic
//	Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value
//	Tạo các method
//	a) GetValue()
//	b) getKey ()
//	Viết chương trình demo: tạo 1 object Student có key là Mã sinh viên
//	và value là tên của sinh viên đó

	public static <K> void question6(K key) {
		System.out.println(key);
	}
	
//	Question 8: K & V generic
//	Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng key, value (extends MyMap)
//	Với key là id của Staff (ID có thể là int, long)
//	Với value là tên của Staff
//	Tạo các method
//	a) GetId ()
//	b) getName ()
//	Viết chương trình demo
}
