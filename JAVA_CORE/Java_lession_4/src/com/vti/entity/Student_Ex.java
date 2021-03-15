package com.vti.entity;

public class Student_Ex {
	private int id;
	private String name;
	private String homeTown;
	private Float point;

	public Student_Ex(String name, String homeTown) {
		this.name = name;
		this.homeTown = homeTown;
		this.point = (float) 0;

	}

	public Student_Ex(String name, Float point) {
		this.name = name;
		this.point = point;
	}

	// getter

	public String getName() {
		return name;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public Float getPoint() {
		return point;
	}

	public Float getPoint2() {
		
		if (point <= 4) {
			System.out.println("Yeu");
		} else if (point <= 6) {
			System.out.println("trung binh");
		} else if (point <= 8) {
			System.out.println("kha");
		} else if (point > 8) {
			System.out.println("gioi");
		}
		return point;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public void setPoint(float point1) {
		this.point = point1 + point;
	}

}