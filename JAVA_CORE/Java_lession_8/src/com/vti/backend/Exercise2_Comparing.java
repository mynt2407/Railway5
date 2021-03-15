package com.vti.backend;

import java.util.Arrays;
import java.util.Collections;

import com.vti.entity.ComparatorID;
import com.vti.entity.ComparatorName;
import com.vti.entity.NhanVien;

public class Exercise2_Comparing {

	public static void question1() {

//	Tạo 1 student có property id, name, ngày sinh, điểm và tạo 5 student
//	Question 1: Comparable
//	In ra học sinh sắp xếp theo name

		NhanVien nhanvien1 = new NhanVien(3, "Nguyen Van Toan", 5);
		NhanVien nhanvien2 = new NhanVien(5, "Tran Van Sang", 8);
		NhanVien nhanvien3 = new NhanVien(4, "Nguyen The TAnh", 4);
		NhanVien nhanvien4 = new NhanVien(1, "Ho Thi Hong Nhung", 2);
		NhanVien nhanvien5 = new NhanVien(5, "Nguyen Van Hung", 3);

		NhanVien[] nhanviens = { nhanvien1, nhanvien2, nhanvien3, nhanvien4, nhanvien5 };

// In ra nhan vien sap xep theo id:
		Collections.sort(Arrays.asList(nhanviens), new ComparatorName());
		for (NhanVien nhanVien : nhanviens) {
			System.out.println(nhanVien);
		}
		System.out.println("-------------------");
		
		Collections.sort(Arrays.asList(nhanviens), new ComparatorID());
		for (NhanVien nhanVien : nhanviens) {
			System.out.println(nhanVien);
		}

// In ra nhan vien sap xep theo ten:



	}
}
