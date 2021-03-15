package com.vti.entity;

public class NhanVien {

	private int id;
	private String name;
	private int point;

	public NhanVien(int id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "NhanVien [id = " + id + ", name = " + name + ", point = " + point + "]";
	}

	//Compable
	
//	@Override
//	public int compareTo(NhanVien other) {
//		if (other == null) {
//			return -1;
//		} else if (id < other.id) {
//			return -1;
//		} else if (id > other.id) {
//			return 1;
//		}
//		return id;
//
//	}
//	
	
}
