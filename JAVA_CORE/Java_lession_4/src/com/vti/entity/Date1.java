package com.vti.entity;


public class Date1 {
	private int day;
	private int month;
	private int year;

	public Date1() {

	}

	public Date1(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Day la: " + day;
		result += "Month la: " + month;
		result += "Year la: " + year;

		return result;
	}
	

}
