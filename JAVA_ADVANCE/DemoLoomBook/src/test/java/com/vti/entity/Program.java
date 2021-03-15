package com.vti.entity;

public class Program {
	public static void main(String[] args) {
		Department department = new Department();
		
		department.id(2);
		department.name("Neo Nguyen");
		System.out.println(department);
	}

}
