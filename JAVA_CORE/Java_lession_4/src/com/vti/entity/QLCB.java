package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {

	private List<CanBo> canBos;
	private Scanner scanner;

	public QLCB() {
		canBos = new ArrayList<CanBo>(); // khởi tạo 1 thằng rỗng 
		scanner = new Scanner(System.in);
	}

	public QLCB(List<CanBo> canBos) { // khởi tạo thêm, array list này có sẵn 1 vài thằng rồi
		this.canBos = canBos;
	}

	public void themMoi() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Moi ban nhap so can bo muon nhap: ");
		int x = scanner.nextInt();

		byte y;
		for (int i = 0; i < x; i++) {
			System.out.println("Moi ban chon can bo can nhap: 1: Cong Nhan || 2: Ky Su || 3: Nhan vien");
			y = scanner.nextByte();

			switch (y) {
			case 1:
				canBos.add(new CongNhan());
				break;
			case 2:
				canBos.add(new NhanVien());
				break;
			case 3:
				canBos.add(new KySu());
				break;
			default:
				System.out.println("Ban da nhap sai. Moi ban nhap lai!");
				break;
			}
			System.out.println("Chuc mung! Ban da tao thanh cong nguoi thu " + (i + 1));
			System.out.println("--------------------------\n");
		}
	}

	public void findName() {
		boolean hasName = false;
		for (int i = 0; i < canBos.size(); i++) {
			if (canBos.get(i).equals("my nguyen")) {
				System.out.println(canBos.get(i));
				hasName = true;
			}
			if (!hasName) {
				System.out.println("Khong co thong tin ban can tim!");
			}
		}
	}

	public void print() {
		for (CanBo canBo : canBos) {
			if (canBo != null) {
				System.out.println("Thong tin can bo la:\n " + canBo);
			}
		}
		System.out.println("----------------------------");
	}

	public void delete() {
		boolean hasName1 = false;
		for (int i = 0; i < canBos.size(); i++) {
			if (canBos.get(i) != null && canBos.get(i).equals("my nguyen")) {
				canBos.remove(i);
				System.out.println("đã xóa thành công");
				hasName1 = true;
				break;
			}
			if (!hasName1) {
				System.out.println("Khong tim thay thong tin can xoa!");
			}
		}

	}
}
