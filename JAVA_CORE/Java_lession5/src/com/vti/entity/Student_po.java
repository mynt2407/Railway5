package com.vti.entity;

import java.util.Scanner;

public class Student_po implements IStudent {
	private int id;
	private String name;
	private int group;

	public Student_po() {
	}
// cach 1: 

	public Student_po(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

// cach 2: 

//	public Student_po() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Moi ban nhap vao id: " );
//		this.id = scanner.nextInt();
	
//	System.out.println("Moi ban nhap vao ten: " );	
//		this.name = scanner.nextLine();
	
//	System.out.println("Moi ban nhap vao group: " );
//		this.group = scanner.nextInt();
//	}

	@Override
	public void diemDanh() {
		System.out.println(name + " diem danh" + " nhom: " + group );

	}

	@Override
	public void hocBai() {
		System.out.println(name + " dang hoc bai" + " nhom: " + group);
	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " di don ve sinh" + " nhom: " + group);

	}

	public int getGroup() {
		return group;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		String result = "";
		result += "ten :" + name +"\n";
		return result;
	}
}
