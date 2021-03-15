package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Configs;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhHocException;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.SoLuongException;
import com.vti.entity.Student;

public class Exercise1 {
//	Question 1: static variable
//	Khai báo 1 class student có các thuộc tính id, name, college
//	Với college là static variable.
//	Hãy khởi tạo các student sau:
//	Student có id = 1, name ="Nguyễn Văn A"
//	Student có id = 2, name = " Nguyễn Văn B "
//	Student có id = 3, name = " Nguyễn Văn C "
//	Và tất cả các student này đều học ở "Đại học bách khoa".
//	Dùng vòng for để in ra thông tin các student
//	Sau đó hãy chuyển các student này sang "Đại học công nghệ"
//	Dùng vòng for để in ra thông tin các student
	public static void question1() throws Exception {
		Student student1 = new Student(1, "Nguyễn Văn A");
		Student student2 = new Student(2, "Nguyễn Văn B");
		Student student3 = new Student(3, "Nguyễn Văn C");

		Student[] students = { student1, student2, student3 };
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}

		Student.college = "Đại học Công Nghệ";
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}

	}

//	Question 2: tiếp tục question 1
//	Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ
//	lớp - dùng chung cho tất cả các student).
//	Hãy viết chương trình main() để mô tả các bước sau:
//	B1: Các Student sẽ nộp quỹ, mỗi Student 100k
//	B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
//	B3: Student thứ 2 lấy 20k đi mua bánh mì
//	B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
//	B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
//	In ra số tiền còn của nhóm tại mỗi bước 
	public static void question2() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Nguyễn Văn A"));
		students.add(new Student(2, "Nguyễn Văn B"));
		students.add(new Student(3, "Nguyễn Văn C"));

//		Student student1 = new Student(1, "Nguyễn Văn A");
//		Student student2 = new Student(2, "Nguyễn Văn B");
//		Student student3 = new Student(3, "Nguyễn Văn C");
//
//		Student[] students = { student1, student2, student3 };

//		Trong Array List có thể ko dùng for cũng được

		students.get(0).withdrawMoneyGroup(50);
		System.out.println(Student.getMoneyGroup());

		students.get(1).withdrawMoneyGroup(20);
		System.out.println(Student.getMoneyGroup());

		students.get(2).withdrawMoneyGroup(150);
		System.out.println(Student.getMoneyGroup());

		for (Student student : students) {
			student.addMoneyGroup(50);
			System.out.println(Student.getMoneyGroup());
		}

	}

//Question 3:	
//a) Viết class MyMath để thay thế cho class Math của java.
//b) Viết thêm method min(), sum vào class MyMath
	public static void question3() {

	}

//	Question 4: tiếp tục Question 1
//	Trong class Student
//	a) Viết method cho phép thay đổi college
//	b) Viết method cho phép lấy giá trị của college 
	public static void question4() throws Exception {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
		students.add(new Student(3, "Nguyen Van C"));
		students.add(new Student(4, "Nguyen Van D"));

		Student.college = "Dai hoc Phuong Dong";
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println(Student.college);

		// Question5:
		System.out.println("Hien tai co " + Student.count + " hoc sinh");
	}

//	Question 6: tiếp tục Question 5
//	Tạo class PrimaryStudent, SecondaryStudent, hãy viết chương trình
//	đếm số lượng PrimaryStudent được sinh ra, SecondaryStudent được
//	sinh ra.
//	Viết chương trình demo.
//	Khởi tạo 6 Student, trong đó có 2 PrimaryStudent và 4
//	SecondaryStudent, sau đó in ra số lượng Student,
//	PrimaryStudent, SecondaryStudent được sinh ra.

	public static void question6() throws Exception {

		PrimaryStudent primary1 = new PrimaryStudent(1, "My1");
		PrimaryStudent primary2 = new PrimaryStudent(2, "My2");

		SecondaryStudent primary4 = new SecondaryStudent(4, "My4");
		SecondaryStudent primary5 = new SecondaryStudent(5, "My5");
		SecondaryStudent primary6 = new SecondaryStudent(6, "My6");
		SecondaryStudent primary7 = new SecondaryStudent(7, "My7");

		System.out.println(PrimaryStudent.counter);
		System.out.println(SecondaryStudent.counter);

		Student student1 = new Student(1, "My");
		Student student2 = new Student(2, "My");
		Student student3 = new Student(3, "My");
		Student student4 = new Student(4, "My");
		Student student5 = new Student(5, "My");
		Student student6 = new Student(6, "My");
		Student student7 = new Student(7, "My");

		System.out.println(Student.count);

	}

//	Question 8:
//		Tạo class Configs có các static property
//		SO_LUONG_HINH_TOI_DA = 5;
//		Tạo class HinhHoc, và class HinhTron, HinhChuNhat sẽ kế thừa từ
//		class HinhHoc, implement method tính chu vi, diện tính
//		Viết chương trình chỉ cho phép khởi tạo được tối đa 5 hình, nếu người
//		dùng khởi tạo tới hình thứ 6 thì sẽ throw ra 1 custom Exception có tên
//		là HinhHocException có message là: "Số lượng hình tối đa là: " +
//		Configs. SO_LUONG_HINH_TOI_DA

	public static void question8() throws Exception {

		HinhHoc hinh1 = new HinhHoc(0.1f, 1.22f);
		HinhHoc hinh2 = new HinhHoc(0.2f, 1.22f);
		HinhHoc hinh3 = new HinhHoc(0.3f, 1.22f);
		HinhHoc hinh4 = new HinhHoc(0.4f, 1.22f);
		HinhHoc hinh5 = new HinhHoc(0.5f, 1.22f);

		System.out.println(HinhHoc.counter);

	}
}