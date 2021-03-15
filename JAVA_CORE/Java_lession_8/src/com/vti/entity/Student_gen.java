package com.vti.entity;

public class Student_gen<N extends Number> {
	private N id;
	public String name;

	public Student_gen(N id, String name) {
		this.id = id;
		this.name = name;

		
	}

	public Student_gen(float f, String name2) {
		// TODO Auto-generated constructor stub
	}

	public N getId() {
		return id;
	}

	public void setId(N id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
