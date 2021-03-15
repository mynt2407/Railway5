package com.vti.entity;

public class Account1 {
	private String id;
	private String name;
	private int balance;

	public Account1(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int debit(int amount) {
		int x = balance - amount;
		if (x > 0) {
			System.out.println("thanh toan thanh cong!");
		} else {
			System.out.println("So tien hien tai cua ban khong du!");
		}
		return x;
	}

	public int credit(int amount) {
		int y = balance + amount;
		System.out.println("Ban vua nhan duoc so tien la " + amount + "k");
		System.out.println("So du hien tai cua ban la " + y + "k");
		return y;
	}

//	public int tranferTo(Account1 account, int amount) {
//		int result = amount - balance;
//		if (balance == 0) {
//			break;
//		}
//		else if (result < 0) {
//			System.out.println("So du cua ban khong du de thuc hien giao dich nay!");
//		} else {
//			System.out.println("Giao dich thanh cong");
//		}
//		return result;
//	}

	@Override
	public String toString() {
		String result = "";
		result += "id la: " + id + "\n";
		result += "Name la: " + name + "\n";
		result += "Balance la: " + balance + "\n";
		return result;
	}

}
