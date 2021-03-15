package com.vti.entity;

public class PrimaryStudent {
	public static int counter = 0;
	int id;
	String name;

	public PrimaryStudent(int id, String name) throws Exception {
		this.id = id;
		this.name = name;
		counter++;
		if (PrimaryStudent.counter > 2) {
			throw new Exception("Chi duoc phep tao toi da 2 PrimaryStudent");
		}
	}

}
