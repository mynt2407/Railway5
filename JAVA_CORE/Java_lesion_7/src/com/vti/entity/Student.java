package com.vti.entity;

public class Student {

	public static String college;
	public static float moneyGroup = 0;
	public static int count = 0;

	private int id;
	private String name;

	public Student(int id, String name) throws Exception {

		this.id = id;
		this.name = name;
		college = "Đại học Bách Khoa";
		addMoneyGroup(100);
		count++;
		if (Student.count > 7) {
			throw new Exception("Ban khong duoc tao qua 7 hoc sinh!");
		}

	}

	public static void study() {
		System.out.println("Dang hoc bai!");
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

	public static float getMoneyGroup() {
		return moneyGroup;
	}

	public static void addMoneyGroup(float amount) {
		moneyGroup += amount;
	}

	public static void withdrawMoneyGroup(float amount) {
		moneyGroup -= amount;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Id là: " + id + "\n";
		result += "Name là: " + name + "\n";
		result += "Trường đại học: " + college + "\n";
		result += "Tiền quỹ lớp: " + moneyGroup + "\n";
		return result;
	}
}
