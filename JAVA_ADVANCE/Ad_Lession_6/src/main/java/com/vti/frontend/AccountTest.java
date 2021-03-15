package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;

public class AccountTest {
	public static void main(String[] args) {

		AccountRepository AccountRepository = new AccountRepository();

		System.out.println("***********GET ALL Account***********");
		List<Account> accounts = AccountRepository.getAllAccount();
		for (Account account : accounts) {
			Department department = account.getDepartment();
			System.out.println(department.getName());
			System.out.println(account);
		}

//		System.out.println("\n\n***********CREATE Account ***********");
//		Account Account = new Account();
//		Account.setEmail("mynt2407@gmail.com");
//		Account.setUserName("NeoNguyen123");
//		Account.setFirstName("Neo");
//		Account.setLastName("Nguyen");
//		Account.setDepartment(new Department());
//		AccountRepository.createAccount(Account);

	}
}
