package com.vti.entity;

public class IN_CLASS {
	public static void main(String[] args) {
		try {
			float result = divide(7, 1);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Phuong thuc ban chia chua dung!");
		} finally {
			System.out.println("Divide complete!");
		}

	}

	public static float divide(int a, int b) {
		return a / b;

	}
}
