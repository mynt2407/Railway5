package com.vti.fornted;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Ultils.ScannerUtils;
import com.vti.backend.Exercise3_Call_Procedure;
import com.vti.entity.ExeceptionIdDepartment;
import com.vti.entity.ExeceptionNameDepartment;

public class Program3 {
	public static void main(String[] args) throws ClassNotFoundException, ExeceptionNameDepartment, SQLException,
			ExeceptionIdDepartment, FileNotFoundException, IOException {
		Exercise3_Call_Procedure ex3 = new Exercise3_Call_Procedure();
		try {
			System.out.print("Moi ban nhap vao id cua phong ban can xoa: ");
			int id = ScannerUtils.inputPositiveInt("Ban phai nhap vao so nguyen duong!");

			System.out.println(ex3.deleteDepartmentUsingProcedure(id));
			System.err.println("Da xoa thanh cong!");

		} catch (ExeceptionIdDepartment eid) {
			System.err.println(eid.getMessage());
		}
	}
}
