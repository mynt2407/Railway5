package com.vti.entity;

public class HinhTron extends HinhHoc implements TinhKichThuoc {

	public HinhTron(float a, float b) throws Exception {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public static float PI = 3.14f;

	public void ChuVi(int a, int b, float r) {

		float ChuVi = 2 * PI * r;

	}

	public void DienTich(int a, int b, float r) {

		float DienTich = PI * r * r;
	}

	@Override
	public void ChuVi(int a, int b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DienTich(int a, int b) {
		// TODO Auto-generated method stub

	}

}
