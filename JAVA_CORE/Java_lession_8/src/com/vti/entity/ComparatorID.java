package com.vti.entity;

import java.util.Comparator;

public class ComparatorID implements Comparator<NhanVien> {

	@Override
	public int compare(NhanVien nhanvien1, NhanVien nhanvien2) {
		if (nhanvien1 == null) {
			return -1;
		}
		if (nhanvien2 == null) {
			return 1;
		}

		if (nhanvien1.getId() > nhanvien2.getId()) {
			return 1;
		} else if (nhanvien1.getId() < nhanvien2.getId()) {
			return -1;
		}
		return 0;
	}

}