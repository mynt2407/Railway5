package com.vti.frontned;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.User;

public class Function {

	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, SQLException {
		System.out.println("Print user");
		List<User> users = userController.getListUsers();
		System.out.printf("%-15s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password");
		for (User user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
					user.getPassword());
		}
	}

	public void getUserById() throws Exception {
		System.out.println("Find user by id");
		while (true) {
			System.out.println("Mời bạn nhập vào id");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

			try {
				System.out.println(userController.getUserById(id));
				return;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}
	}

	public void deleteUser() throws ClassNotFoundException, SQLException {
		System.out.println("Delete account ");
		while (true) {
			System.out.println("Mời bạn nhập vào id của account: ");
			int id2 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương!");

			if (userController.isUserIdExits(id2)) {
				System.out.println(userController.deleteUser(id2));
				return;
			} else {
				System.err.println("id khong ton tai! Vui long nhap lai!\n");
			}

		}
	}

	public void login() throws ClassNotFoundException, SQLException {
		System.out.println("Login tài khoản ");
		while (true) {
			System.out.print("Mời bạn nhập vào Email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng. Moi nhap lai!");

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils.inputPassword(
					"Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!\nMoi ban nhap lai!");
			try {
				System.out.println(userController.login(email, password));
				System.out.println("Login successfull!");
				return;

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
