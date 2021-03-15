package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class Program1 {
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		AccountController accountcontroller = new AccountController();
		
		List<Account> accounts = accountcontroller.getListAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
