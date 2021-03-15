package com.vti.entity;

public class Student {
	public static int count = 0;

	private int id;
	private String name;

	public Student(String name) {
		this.name = name;
		count = count + 1;
		id = count;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Id la: " + id + "\n";
		result += "Name la: " + name + "\n";
		return result;
	}

}
