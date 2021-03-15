package com.vti.entity;

public class Product {

	private String Code;
	private String name;
	private String price;

	public Product(String code, String name, String price) {
		Code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode() {
		return Code;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

}
