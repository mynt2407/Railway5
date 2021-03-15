package com.vti.entity;

public class Student_2 {

	private final int id = 1;
	private String name;

	public final void study() {
		System.out.println("Đang học bài");

	}

	public Student_2(String name) {
//		this.id = 3;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
