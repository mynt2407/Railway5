package com.vti.entity;

import java.util.Scanner;

public class Sach extends TaiLieu {
	private String authorName;
	private int page;

	public Sach() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập tên Tác Giả: ");
		this.authorName = scanner.nextLine();

		System.out.print("Mời bạn nhập Số trang: ");
		this.page = scanner.nextInt();

	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "Tên tác giả Sách là: " + authorName + "\n";
		result += "Số trang Sách là: " + page + "\n";
		return result;
	}
}
