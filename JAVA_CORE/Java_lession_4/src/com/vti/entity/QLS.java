package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Bao;
import com.vti.entity.Sach;
import com.vti.entity.TaiLieu;
import com.vti.entity.TapChi;

public class QLS {
	private List<TaiLieu> taiLieus;
	private Scanner scanner;

	public QLS() {
		taiLieus = new ArrayList<TaiLieu>();
		scanner = new Scanner(System.in);
	}

	public void themTL() {

		System.out.print("Nhập số TL muốn thêm: ");
		int soLuong = scanner.nextInt();

		for (int i = 0; i < soLuong; i++) {
			System.out.println("Nhap 1: Sách|| 2: Báo || 3: Tạp Chí");
			int maSo = scanner.nextInt();

			switch (maSo) {
			case 1:
				taiLieus.add(new Sach());
				break;
			case 2:
				taiLieus.add(new Bao());
				break;
			case 3:
				taiLieus.add(new TapChi());
				break;
			default:
				System.out.println("Ban da nhap sai so. Moi nhap lai!");
				break;
			}
			System.out.println("Chuc mung ban da tao thanh cong tai lieu thu " + (i + 1));
			System.out.println("----------------------------");
		}

	}

	public void xoaTL() {
		for (int i = 0; i < taiLieus.size(); i++) {
			boolean isId = false;
			if (taiLieus.get(i) != null && taiLieus.get(i).id == 2) {
				taiLieus.remove(i);
				isId = true;
				System.out.println("Đã xóa thành công!\n");
				break;
			}
			if (!isId) {
				System.out.println("Mã tài liệu bạn tìm không có!");
				System.out.println("----------------------------");
			}
		}
	}

	public void printTL() {
		for (TaiLieu taiLieu : taiLieus) {
			System.out.println("Danh sách tài liệu:\n " + taiLieu);
			System.out.println("----------------------------");
		}
	}

	public void findTL() {

		System.out.println("Mời bạn chọn loại tài liệu cần tìm 1: Sách || 2: Báo || 3: Tạp chí ");
		int choose = scanner.nextInt();
		switch (choose) {
		case 1:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieus instanceof Sach) {
					taiLieu.toString();
					break;
				}
			}
		case 2:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieus instanceof Bao) {
					taiLieu.toString();
					break;
				}
			}
		case 3:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieus instanceof TapChi) {
					taiLieu.toString();
					break;
				}
			}
		default:
			System.out.println("Bạn đã nhập sai. Mời bạn nhập lại!");
			break;

		}
	}
}
