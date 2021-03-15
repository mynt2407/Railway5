package com.vti.entity;

public class Department {
	private byte id;
	private String name;
	private float salary;
	Account[] accounts;

//	@Override
	public String toString() {
		String result = "";
		result += "ID la: " + id + "\n";
		result += "Name la: " + name + "\n";
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Department department2 = (Department) obj;
		String Name = department2.name;
		if (name.equals(Name)) {
			return true;
		}
		return false;

	}
	
	// getter 
	
	public Department() {
	}

	public Department(String name) {
		this.name = name;
		this.id = 0;
	}

	public byte getid() {
		return id;
	}

	public void setid(byte id) {
		this.id = 5;
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = "my nguyen";
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = 30000;
	}
}