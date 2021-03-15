package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.AccountService;
import com.vti.backend.bussinesslayer.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.ExceptionEmailAccount;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		accountService = new AccountService();
	}

	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		return accountService.getListAccounts();
	}

	public Account getAccountById() throws Exception {
		return accountService.getAccountById();
	}

	public Account getAccountByIdbyScanner(int id) throws ClassNotFoundException, SQLException {
		return accountService.getAccountByIdbyScanner(id);
	}

	public boolean isAccountNameExists(String name) throws Exception {
		if (name == null || name.length() > 20 || name.length() < 4) {
			throw new Exception("Xin lỗi! Tên phải dài hơn 4 kí tự và nhỏ hơn 20 kí tự");
		}
		return accountService.isAccountNameExists(name);
	}

	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: My Nguyen
	 * @create_date: Oct 23, 2020
	 * @version: 1.0
	 * @modifer: My Nguyen
	 * @modifer_date: Oct 23, 2020
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param id
	 * @return
	 * @throws ExceptionNameAccount
	 * @throws ExceptionIdAccount
	 * @throws ExceptionEmailAccount
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public int createAccount(String email, String userName, String fullName, int id)
			throws ExceptionNameAccount, ExceptionIdAccount, ExceptionEmailAccount, ClassNotFoundException, SQLException, Exception {

		if (email == null || !email.contains("@gmail.com")) {
			throw new ExceptionEmailAccount("Email của bạn chưa chính xác! Mời nhập lại!");
		}
		if (fullName == null || fullName.length() < 6) {
			throw new ExceptionNameAccount("Tên của bạn phải dài hơn 6 kí tự! Mời nhập lại!");
		}
	
		return accountService.createAccount(email, userName, fullName, id);
	}

	public boolean isAccountIdExists(int id)
			throws ExceptionIdAccount, ClassNotFoundException, SQLException, ExceptionNameAccount {
		return accountService.isAccountIdExists(id);
	}

	public int updateAccountName(int id, String newUserName, String gender) throws Exception {
		if (newUserName == null || newUserName.length() < 6) {
			throw new ExceptionNameAccount("UserName của bạn phải dài hơn 6 kí tự! Mời nhập lại!");
		}
		return accountService.updateAccountName(id, newUserName, gender);
	}

	public int deleteAccount(int id)
			throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount {
		return accountService.deleteAccount(id);
	}
}
