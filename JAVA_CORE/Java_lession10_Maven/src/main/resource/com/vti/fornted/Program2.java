package com.vti.fornted;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.Ultils.FileManager;
import com.vti.Ultils.ScannerUtils;
import com.vti.backend.DepartmentDao;
import com.vti.entity.Department;
import com.vti.entity.ExeceptionIdDepartment;
import com.vti.entity.ExeceptionNameDepartment;

public class Program2 {

	public static void main(String[] args) throws Exception {
		DepartmentDao department = new DepartmentDao();
//		List<Department> departments = department.getDepartment();
//		System.out.println(departments);
//		System.out.println(department.getDepartmentById());

		// Question 3: read data – get department by id

		Scanner scanner = new Scanner(System.in);

//		System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: Tim department theo id\n"
//				+ "2: Thoat khoi chuong trinh\n ");
//
//		while (true) {
//			System.out.println("Moi ban nhap chuc nang ");
//			int choose = scanner.nextInt();
//			switch (choose) {
//			case 1:
//				System.out.print("Moi ban nhap id: ");
//				int input = ScannerUtils.inputPositiveInt("So ban nhap phai la so nguyen duong! Moi nhap lai: ");
//				System.out.println(department.getDepartmentByIdbyScanner(input));
//				break;
//			case 2:
//				System.out.println("Ban da thoat khoi chuong trinh!");
//				return;
//			default:
//				System.out.println("Ban da nhap sai! Moi nhap lai!");
//				break;
//			}
//		}

// Question 4 

//		try {
//
//			System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: Tim department theo ten\n"
//					+ "2: Thoat khoi chuong trinh\n ");
//			while (true) {
//				System.out.println("Moi ban nhap chuc nang ");
//				int choose = scanner.nextInt();
//				switch (choose) {
//				case 1:
//					System.out.print("Moi ban nhap ten can tim : ");
//					String input = ScannerUtils.inputString("Ban phai nhap vao ten! Moi nhap lai: ");
//					System.out.println(department.isDepartmentNameExists(input));
//					break;
//				case 2:
//					System.err.println("Ban da thoat khoi chuong trinh!");
//					return;
//				default:
//					System.err.println("Ban da nhap sai! Moi nhap lai!");
//					break;
//				}
//			}
//		} catch (ExeceptionNameDepartment die) {
//			throw new ExeceptionNameDepartment("Ten phong ban ban tim khong co!");
//		}

		// Question 5: create data – create department

//		try {
//
//			System.out.println(
//					"Moi ban nhap chuc nang muon su dung:\n" + "1: Tao department\n" + "2: Thoat khoi chuong trinh\n ");
//			while (true) {
//				System.out.println("Moi ban nhap chuc nang ");
//				int choose = scanner.nextInt();
//				switch (choose) {
//				case 1:
//					System.out.print("Moi ban nhap ten phong ban : ");
//					String input = ScannerUtils.inputString("Ban phai nhap vao ten! Moi nhap lai: ");
//
//					System.out.println(department.createDepartment(input));
//					break;
//				case 2:
//					System.err.println("Ban da thoat khoi chuong trinh!");
//					return;
//				default:
//					System.err.println("Ban da nhap sai! Moi nhap lai!");
//					break;
//				}
//			}
//		} catch (ExeceptionNameDepartment die) {
//			throw new ExeceptionNameDepartment("Department name da ton tai!");
//		} catch (Exception e) {
//			throw new Exception("Ban da nhap sai! Moi nhap lai!");
//		}

		// Question 6: update

//		try {
//
//			System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: Update ten cua department\n"
//					+ "2: Thoat khoi chuong trinh\n ");
//			while (true) {
//				System.out.println("Moi ban nhap chuc nang ");
//				int choose = scanner.nextInt();
//				switch (choose) {
//				case 1:
//					System.out.print("Moi ban nhap ID cua phong ban : ");
//					int input = ScannerUtils.inputPositiveInt("Ban phai nhap vao ID! Moi nhap lai: ");
//
//					System.out.println("Moi ban nhap vao ten phong ban");
//					String str = ScannerUtils.inputString("Ban phai nhap vao chu");
//
//					System.out.println(department.updateDepartmentName(input, str));
//					break;
//				case 2:
//					System.err.println("Ban da thoat khoi chuong trinh!");
//					return;
//				default:
//					System.err.println("Ban da nhap sai! Moi nhap lai!");
//					break;
//				}
//			}
//		} catch (ExeceptionIdDepartment eid) {
//			throw new ExeceptionIdDepartment(eid.getMessage());
//		} catch (ExeceptionNameDepartment exnd) {
//			throw new ExeceptionNameDepartment(exnd.getMessage());
//		} catch (Exception e) {
//			throw new Exception("Loi!");
//		}

		// Question 7: delete

		try {

			System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: Delete department\n"
					+ "2: Thoat khoi chuong trinh\n ");
			while (true) {
				System.out.println("Moi ban nhap chuc nang ");
				int choose = scanner.nextInt();
				switch (choose) {
				case 1:
					System.out.print("Moi ban nhap ID cua phong ban : ");
					int input = ScannerUtils.inputPositiveInt("Ban phai nhap vao ID! Moi nhap lai: ");
					department.deleteDepartment(input);
					break;
				case 2:
					System.err.println("Ban da thoat khoi chuong trinh!");
					return;
				default:
					System.err.println("Ban da nhap sai! Moi nhap lai!");
					break;
				}
			}
		} catch (ExeceptionIdDepartment eid) {
			throw new ExeceptionIdDepartment(eid.getMessage());
		}
	}

}