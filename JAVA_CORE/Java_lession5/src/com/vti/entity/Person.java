package com.vti.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Person {
	protected String name;
	protected String sex;
	protected Date birthDay;
	protected String address;

	public Person(String name, String sex, Date birthDay, String address) {
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.address = address;
	}

	public Person() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào tên: ");
		this.name = scanner.nextLine();
		
		System.out.print("Mời bạn nhập vào giới tính: ");
		this.sex = scanner.nextLine();
		
		System.out.print("Mời bạn nhập vào ngày sinh: ");
		this.birthDay = scanner.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(format.format(scanner.nextLine()));
		System.out.println("\n");
		
		
		scanner.nextLine();
		
		System.out.print("Mời bạn nhập vào địa chỉ: ");
		this.address = scanner.nextLine();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
@Override
public String toString() {
	String result = "";
	result += "Tên: " + name + "\n";
	result += "Giới tính: " + sex + "\n";
	result += "Ngày sinh: " + birthDay + "\n";
	result += "Địa chỉ: " + address +"\n";
	return result;
}
}
