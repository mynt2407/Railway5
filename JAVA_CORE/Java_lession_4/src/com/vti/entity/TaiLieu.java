package com.vti.entity;

import java.util.Scanner;

public abstract class TaiLieu {
	protected int id;
	protected String tenNhaXuatban;
	protected String banPhatHanh;

	public TaiLieu() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Mời bạn nhập vào Mã Tài Liệu: ");
		this.id = scanner.nextInt();

		System.out.print("Mời bạn nhập vào Tên Nhà Sản Xuất: ");
		this.tenNhaXuatban = scanner.nextLine();
		scanner.nextLine();

		System.out.print("Mời bạn nhập vào Số Bản Phát Hành: ");
		this.banPhatHanh = scanner.nextLine();
		scanner.nextLine();
	}

	@Override
	public String toString() {
		String result = "";
		result += "Mã Tài Liệu: " + id + "\n";
		result += "Tên Nhà Sản Xuất: " + tenNhaXuatban + "\n";
		result += "Số Bản Phát Hành: " + banPhatHanh + "\n";
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhaXuatban() {
		return tenNhaXuatban;
	}

	public void setTenNhaXuatban(String tenNhaXuatban) {
		this.tenNhaXuatban = tenNhaXuatban;
	}

	public String getBanPhatHanh() {
		return banPhatHanh;
	}

	public void setBanPhatHanh(String banPhatHanh) {
		this.banPhatHanh = banPhatHanh;
	}

	public void findTL() {
		
	}

}
