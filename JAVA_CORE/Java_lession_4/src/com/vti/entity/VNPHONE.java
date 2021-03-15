package com.vti.entity;

import java.util.List;
import java.util.Scanner;

public class VNPHONE extends PHONE implements IPhoneMethod {

	@Override
	public void insertContact() {
		System.out.print("Bạn muốn thêm bao nhiêu SĐT: ");
		int soLan = scanner.nextInt();

		for (int i = 0; i < soLan; i++) {

			contacts.add(new Contact());

			System.out.println("Chúc mừng! Bạn vừa thêm thành công sđt thứ " + (i + 1));
			System.out.println("\n");
		}
		System.out.println("-----------------------------");
	}

	public void print() {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i) != null) {
				System.out.println(contacts.get(i));
			}
			System.out.println("-----------------------------");
		}
	}

	@Override
	public void removeContact() {
		System.out.print("Bạn muốn xóa sdt nào? ");
		int sdt = scanner.nextInt();

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i) != null && contacts.get(i).getNumber() == sdt) {
				contacts.remove(i);
				System.out.println("Ban da xoa thanh cong!");
				break;
			}
			System.out.println("-----------------------------");

		}

	}

	@Override
	public void updateContact() {

		boolean hasPhoneNumber = false;
		System.out.print("Bạn muốn update SĐT nào? ");
		int element1 = scanner.nextInt();

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i) != null && contacts.get(i).getNumber() == element1) {

				System.out.print("Mời bạn nhập sđt cập nhật ");
				int element2 = scanner.nextInt();
				hasPhoneNumber = true;

				contacts.get(i).setNumber(element2);
				System.out.println("Chúc mừng bạn vừa update sdt thành công!");
				break;
			}
		}
		if (!hasPhoneNumber) {
			System.out.println("SĐT bạn cần cập nhật không tồn tại! Mời nhập lại!");
		}
		System.out.println("-----------------------------");

	}

	@Override
	public void searchContact() {

		boolean hasInformation = false;

		System.out.print("Bạn muốn tìm ai? ");
		String str = scanner.nextLine();
		scanner.nextLine();

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i) != null && contacts.get(i).equals(str)) {
				System.out.println("Thong tin ban can tim la: " + "\n" + contacts.get(i));
				hasInformation = true;
				break;
			}
		}

		if (!hasInformation) {
			System.out.println("Khong co thong tin ban can tim!");
		}

	}

}
