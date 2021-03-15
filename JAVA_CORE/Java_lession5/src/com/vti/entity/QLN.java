package com.vti.entity;

import java.util.Scanner;

public class QLN {
	private Person[] persons;
	private Scanner scanner;

	public QLN() {
		persons = new Person[100];
		scanner = new Scanner(System.in);
	}

	public void inputInfo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bạn muốn thêm bao nhiêu người? ");
		int inputNumber = scanner.nextInt();

		for (int i = 0; i < inputNumber; i++) {
			persons[i] = new Person();

			System.out.println("Bạn vừa nhập thành công người thứ " + (i + 1));
			System.out.println("-----------------------------");
		}
	}

	public void showInfo() {
		for (Person person : persons) {
			if (person != null) {
				System.out.println("Danh sách thông tin là:\n" + person);
			}
		}

	}

}
