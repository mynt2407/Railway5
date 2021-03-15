package com.vti.entity;

public class SecondaryStudent {

	public static int counter = 0;
	int id;
	String name;

	public SecondaryStudent(int id, String name) throws Exception {
		this.id = id;
		this.name = name;
		counter++;
		if (SecondaryStudent.counter > 4) {
			throw new Exception("Chi duoc phep tao toi da 4 PrimaryStudent");
		}
	}
}
