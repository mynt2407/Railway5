package com.vti.entity;

public class Employee<S> {
	private int id;
	private String name;
	private S salaries;
	
	public Employee(int id, String name, S[] salaries) {
	
		this.id = id;
		this.name = name;
		this.salaries = (S) salaries;
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

	public S getSalaries() {
		return salaries;
	}

	public void setSalaries(S salaries) {
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "Employee [id = " + id + ", name = " + name + ", salaries = " + salaries + "]";
	}
	

	
}
