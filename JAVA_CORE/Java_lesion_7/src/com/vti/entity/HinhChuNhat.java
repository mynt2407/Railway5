package com.vti.entity;

public class HinhChuNhat extends HinhHoc implements TinhKichThuoc {

	public HinhChuNhat(float a, float b) throws Exception {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ChuVi(int a, int b) {
		int chuVi = (a+b)*2;
		System.out.println(chuVi);
		
	}

	@Override
	public void DienTich(int a, int b) {
		int dienTich = a*b;
		System.out.println(dienTich);
		
	}




}
