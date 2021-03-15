package com.vti.backend;

import com.vti.entity.Student;
import com.vti.entity.Student_2;

public class Exercise2 {

//	Question 1: final variable
//	Tạo class MyMath, khai báo final variable số PI = 3.14
//	Viết method sum(int a) và trả về tổng của a và PI
//	Thử thay đổi số PI = 3.15 trong method xem có được ko?
	public static void question2() {
		Student_2 student = new Student_2("My nguyen");
		System.out.println(student.getName());
		System.out.println(student.getId());
		

	}

//	Question2:
//	Tạo class Student có property id, name hãy thiết kế class Student sao
//	cho khi đã khởi tạo Student thì id là không thể thay đổi trong suốt quá
//	trình chạy chương trình chương trình

	
//	Question 3: Tiếp tục Question 2 (final method) (Student question 2 và
//			question 3 không liên quan gì tới nhau)
//			Student bắt buộc phải học bài, và việc học bài là như nhau đối với các
//			học sinh  ta viết method void study(), bên trong method ta sẽ in ra
//			text "Đang học bài…"
//			Tiếp theo ta có các loại Student như sau: PrimaryStudent,
//			SecondaryStudent, và có thể còn có nhiều loại học sinh khác trong
//			tương lai, tất cả các student này đều kế thừa Student
//			Hãy thiết kế chương trình để tất cả các học sinh đều có method study()
//			như nhau (nghĩa là PrimaryStudent, SecondaryStudent không thể
//			override được method study())

	public static void quesion3() {
		Student_2 student = new Student_2("my nguyen");
		System.out.println(student.getName());
		System.out.println(student.getId());
	}
}
