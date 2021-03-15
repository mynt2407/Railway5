package com.vti.entity;

import java.util.Comparator;

public class ComparatorName implements Comparator<NhanVien> {

	@Override
	public int compare(NhanVien nhanVien1, NhanVien nhanVien2) {
		if (nhanVien1 == null) {
			return -1;
		}
		if (nhanVien2 == null) {
			return 1;
		}

		String firstName1;
		String firstCharacter1;
		String[] arrayName1 = nhanVien1.getName().split(" ");
		firstName1 = arrayName1[arrayName1.length - 1];
		firstCharacter1 = firstName1.substring(0, 1).toUpperCase();

		String firstName2;
		String firstCharacter2;
		String[] arrayName2 = nhanVien2.getName().split(" ");
		firstName2 = arrayName2[arrayName2.length - 1];
		firstCharacter2 = firstName2.substring(0, 1).toUpperCase();

		return firstCharacter1.compareTo(firstCharacter2);

	}

}
