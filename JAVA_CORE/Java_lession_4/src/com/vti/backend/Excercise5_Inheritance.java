package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.HighSchoolStudent;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;
import com.vti.entity.QLCB;
import com.vti.entity.QLS;

public class Excercise5_Inheritance {
	public static void main(String[] args) {

//		question1();
		question2();
//		question3();
//		question4();

	}

//Question 1: inheritance
//Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
//Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
//Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//Các nhân viên có thuộc tính riêng: công việc.
//Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo

	public static void question1() {
		CongNhan congNhan = new CongNhan("Tran Van Toan", (byte) 20, "Male", (byte) 8);
		System.out.println(congNhan.getName());
		System.out.println(congNhan.getLevel());
		System.out.println("\n");

		KySu kySu = new KySu("Nguyen The Hung", (byte) 30, "Male", "manager");
		System.out.println(kySu.getTrainingIndustry());
		System.out.println("\n");

		NhanVien nhanVien = new NhanVien("Tran Lam Anh", (byte) 37, "Female", "Diretor");
		System.out.println(nhanVien.getWork());
		System.out.println(nhanVien.getSex());

//		KySu kySu = new KySu();
//		System.out.println(kySu);
	}

//	Question 2: Tiếp tục Question 1
//	Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
//	d) Nhập vào tên của cán bộ và delete cán bộ đó
//	e) Thoát khỏi chương trình.

	public static void question2() {
		Scanner scanner = new Scanner(System.in);
		QLCB qlcb = new QLCB();
		System.out.print("Moi ban nhap vao chuc nang muon dung\n" + "1: Them moi can bo\n" + "2: Tim kiem theo ho ten\n"
				+ "3: Hien thi thong tin\n" + "4: Delete can bo\n" + "5: Thoat khoi chuong trinh\n");
		while (true) {
			System.out.print("Moi ban chon chuc nang: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				qlcb.themMoi();
				break;
			case 2:
				qlcb.findName();
				break;
			case 3:
				qlcb.print();
				break;
			case 4:
				qlcb.delete();
				break;
			case 5:
				System.out.println("Ban da thoat khoi chuong trinh!");
				return;

			default:
				System.out.println("Ban da nhap sai. Moi ban nhap lai!");
				break;
			}

		}

	}

//	Question 3 (Optional): constructor inheritance
//	Tạo class abstract Person gồm các property name và tạo constructor có 1 parameter name
//	Tạo class abstract Student kế thừa Person gồm các property id, name
//	và tạo constructor có 2 parameter id, name
//	Tạo class HighSchoolStudent kế thừa Student bao gồm các property id,
//	name, clazz (Lớp đang học), desiredUniversity (trường đại học mong
//	muốn vào) và tạo constructor có 4 parameter id, name, clazz,
//	desiredUniversity.
//	Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name =
//	"Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công nghệ"

	public static void question3() {
		HighSchoolStudent highschool = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
		System.out.println(highschool.clazz);
		System.out.println(highschool.desiredUniversity);
	}

//	Question 4 (Optional):
//		Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
//		tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
//		Tên nhà xuất bản, số bản phát hành.
//		Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
//		Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
//		Các báo cần quản lý thêm: Ngày phát hành.
//		Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
//		cách hiệu quả.
//		Xây dựng lớp QuanLySach có các chức năng sau
//		a) Thêm mới tài liêu: Sách, tạp chí, báo.
//		b) Xoá tài liệu theo mã tài liệu.
//		c) Hiện thị thông tin về tài liệu.
//		d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
//		e) Thoát khỏi chương trình.

	public static void question4() {

		QLS qls = new QLS();
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				" + 1: Thêm mới tài liệu\n + 2: Xóa tài liệu\n + 3: Hiển thị thông tin về tài liệu\n + 4: Tìm kiếm theo loại\n + 5: Thoát khỏi chương trình\n");

		while (true) {
			System.out.print("Mời bạn nhập chức năng muốn sử dụng: ");
			int choose = scanner.nextInt();
			switch (choose) {

			case 1:
				qls.themTL();
				break;
			case 2:
				qls.xoaTL();
				break;
			case 3:
				qls.printTL();
				break;
			case 4:
				qls.findTL();
				break;
			case 5:
				System.out.println("Bạn đã thoát chương trình!");
				return;
			default:
				System.out.println("Bạn đã nhập sai. Mời nhập lại!");
				break;
			}
		}
	}
}
