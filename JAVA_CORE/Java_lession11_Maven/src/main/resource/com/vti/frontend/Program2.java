package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.Ultils.ScannerUtils;
import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.entity.ExceptionEmailAccount;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public class Program2 {
	private static AccountController accountController;

	public static void main(String[] args) throws Exception {

		accountController = new AccountController();

		System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: In ra danh sách Account\n"
				+ "2: Tìm account theo ID\n" + "3: Xem Accountid đã tồn tại chưa\n"
				+ "4: Xem AccountName đã tồn tại chưa\n" + "5: Tạo mới account\n" + "6: Cập nhật account\n"
				+ "7: Xóa account\n" + "8: Thoat khoi chuong trinh\n ");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Moi ban nhap chuc nang: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				getListAcc();
				break;

			case 2:
				getAccById();
				break;

			case 3:
				isAccIdExists();
				break;

			case 4:
				isAccNameExists();
				break;

			case 5:
				createNewAcc();
				break;
			case 6:
				updateAcc();
				break;
			case 7:
				deleteAcc();
				break;
			case 8:
				System.err.println("Ban da thoat khoi chuong trinh!");
				return;

			default:
				System.err.println("Ban da nhap sai! Moi nhap lai!");
				break;
			}
		}

	}

	// 1: In ra danh sách Account
	private static void getListAcc() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		System.out.println("Print account");

		List<Account> accounts = accountController.getListAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	// 2: Tìm account theo ID
	private static void getAccById() throws ClassNotFoundException, SQLException {
		while (true) {

			System.out.println("Find account by name!");
			System.out.println("Mời bạn nhập vào id");
			int id2 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");
			System.out.println(accountController.getAccountByIdbyScanner(id2));
			return;
		}
	}

	// 3: Xem Accountid đã tồn tại chưa
	private static void isAccIdExists()
			throws ClassNotFoundException, ExceptionNameAccount, SQLException, ExceptionIdAccount {
		while (true) {

			System.out.println("Check account id exits!");
			System.out.println("Mời bạn nhập vào id");

			int id3 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

			System.out.println(accountController.isAccountIdExists(id3));
			return;

		}
	}

	// 4: Xem AccountName đã tồn tại chưa
	private static void isAccNameExists() throws Exception {
		while (true) {

			System.out.println("Check account name exits!");
			System.out.println("Mời bạn nhập vào tên");
			String name4 = ScannerUtils.inputString("Bạn phai nhập vào chữ");

			System.out.println(accountController.isAccountNameExists(name4));
			return;
		}
	}

	// 5: Tạo mới account
	private static void createNewAcc() throws ClassNotFoundException, ExceptionNameAccount, SQLException, Exception {
		while (true) {
			System.out.println("Create new account!");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			System.out.println("Mời bạn nhập vào email: ");
			String email = ScannerUtils.inputString("Bạn phai nhập vào email: ");

			System.out.println("Mời bạn nhập vào username: ");
			String userName = ScannerUtils.inputString("Bạn phải nhập vào username");

			System.out.println("Mời bạn nhập vào tên đầy đủ: ");
			String fullName = ScannerUtils.inputName("Bạn phải nhập vào tên đầy đủ");

			System.out.println("Mời bạn nhập vào mã phòng ban");
			int id2 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương!");

			try {

				if (!accountController.isAccountNameExists(userName) || !accountController.isAccountIdExists(id2)) {
					System.out.println(accountController.createAccount(email, userName, fullName, id2));
					return;
				} else {
					System.err.println("Tên hoặc id đã tồn tại. Mời nhập lại!");
				}

			} catch (ExceptionNameAccount ena) {
				System.err.println(ena.getMessage());

			} catch (ExceptionEmailAccount eea) {
				System.err.println(eea.getMessage());

			}
		}
	}

	// 6: Cập nhật account
	private static void updateAcc() throws Exception {
		while (true) {
			System.out.println("Update account!");

			System.out.println("Mời bạn nhập vào id của account");
			int id6 = ScannerUtils.inputInt("Bạn phải nhập vào số nguyên dương!");

			System.out.println("Mời bạn nhập vào username: ");
			String username6 = ScannerUtils.inputString("Bạn phải nhập vào Username");

			System.out.println("Mời bạn nhập vào giới tính");
			String gender6 = ScannerUtils.inputString("Bạn phải nhập vào giới tính");
			try {

				if (accountController.isAccountIdExists(id6) && !accountController.isAccountNameExists(username6)) {
					System.out.println(accountController.updateAccountName(id6, username6, gender6));
					return;
				} else {
					System.err.println("id không tồn tại hoặc tên account bị trùng!");
					System.err.println("Mời bạn nhập lại!");
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.err.println("Mời bạn nhập lại!");

			}

		}
	}

	// 7: Xóa account
	private static void deleteAcc()
			throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount {
		while (true) {
			System.out.println("Delete account! ");
			System.out.println("Mời bạn nhập vào id của account: ");
			int id7 = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương!");
			try {
				if (accountController.isAccountIdExists(id7)) {
					System.out.println(accountController.deleteAccount(id7));
					return;
				}

			} catch (ExceptionIdAccount eia) {
				System.err.println("ID không tồn tại! Mời nhập lại! ");
			}

		}
	}
}
