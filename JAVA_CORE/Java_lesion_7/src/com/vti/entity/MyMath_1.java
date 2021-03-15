package com.vti.entity;

public class MyMath_1 {
	public static void main(String[] args) {

		// max(7, 5);
		// min(7, 5);
		   sum(2, 3);
	}

	public static int max(int a, int b) {
		int c = a - b;
		if (c > 0) {
			System.out.println(a);

		} else {
			System.out.println(b);
		}
		return c;

	}

	public static int min(int a, int b) {
		int c = a - b;
		if (c > 0) {
			System.out.println(b);

		} else {
			System.out.println(a);
		}
		return c;

	}

	public static int sum(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
		return sum;
		
	}
}
