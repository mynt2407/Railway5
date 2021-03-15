package com.vti.entity;

public class HinhHoc implements TinhKichThuoc {

	public static int counter = 0;

	private float a;
	private float b;

	public HinhHoc(float a, float b) throws Exception {
		this.a = a;
		this.b = b;
		counter++;
		if (counter > Configs.SO_LUONG_HINH_TOI_DA) {
			throw new HinhHocException("So luong toi da la: " + Configs.SO_LUONG_HINH_TOI_DA);
		}
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
