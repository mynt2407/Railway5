package com.vti.backend;

import java.util.Random;
import java.util.Scanner;
import com.vti.entity.QLN;
import com.vti.entity.Student_po;

public class Exercise2_Polymorphism {
	public static void main(String[] args) {
	//	question1();
		question2();
	}

//Question 1: Interface Management
//Tạo 1 class Student gồm các property id, name, group(int)
//Tạo 1 interface IStudent bao gồm các method : điểmDanh(), họcBài(),
//đi dọn vệ sinh()
//Class Student sẽ implement interface như sau:
//Method điểm danh() sẽ in ra nội dung như sau:
//"Nguyễn Văn A điểm danh"
//"Nguyễn Văn B điểm danh"
//"Nguyễn Văn C điểm danh"
//….
//Method học Bài () sẽ in ra nội dung như sau:
//"Nguyễn Văn A đang học bài"
//"Nguyễn Văn B đang học bài "
//"Nguyễn Văn C đang học bài "
//…
//Tương tự với các method còn lại
	public static void question1() {
		Random random = new Random();

		Student_po[] student2 = new Student_po[10];
		for (int i = 0; i < student2.length; i++) {
			int group = 1 + random.nextInt(3);
//			int group;
//			
//			if (i <= 2) {
//				group = 1;
//			} else if (i <= 5) {
//				group = 2;
//			} else {
//				group = 3;
//			}
			student2[i] = new Student_po(i, "Nguyen Van A" + (i + 1), group);

		}
		// cau b: keu ca lop di diem danh

		for (Student_po student : student2) {
			student.diemDanh();
		}
		// cau c: Gọi nhóm 1 đi học bài
		for (Student_po student : student2) {
			if (student.getGroup() == 1) {
				student.hocBai();
			}
		}
		// d) Gọi nhóm 2 đi dọn vệ sinh
		for (Student_po student : student2) {
			if (student.getGroup() == 2) {
				student.donVeSinh();
			}
		}
	}

//	Question 2 (Optional): Abstract Management
//	Tạo 1 class Person chứa các property sau: tên, giới tính, ngày sinh, địa
//	chỉ với đầy đủ getter setter, constructor không tham số, constructor đầy đủ tham số
//	a) Viết phương thức inputInfo(), nhập thông tin Person từ bàn phím
//	b) Viết phương thức showInfo(), hiển thị tất cả thông tin Person
//	Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên:
//	Mã sinh viên, Điểm trung bình, Email
//	a) Override phương thức inputInfo(), nhập thông tin Student từ bàn phím
//	b) Override phương thức showInfo(), hiển thị tất cả thông tin Student
//	c) Viết phương thức xét xem Student có được học bổng không?
//	Điểm trung bình từ 8.0 trở lên là được học bổng
	public static void question2() {

		QLN qln = new QLN();
		Scanner scanner = new Scanner(System.in);
		System.out.println(" + 1: Nhập thông tin vào:\n + 2: Hiển thị thông tin:\n");

		while (true) {
			System.out.print("Mời bạn chọn chức năng muốn sử dụng:");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				qln.inputInfo();
				break;
			case 2:
				qln.showInfo();
				break;
			case 3:
				System.out.println("Kết thúc chương trình!");
				return;
			default:
				System.out.println("Bạn đã nhập sai! Mời bạn nhập lại!");
				break;
			}
		}
	}
}
