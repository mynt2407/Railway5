package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.GroupAccountRepository;
import com.vti.entity.GroupAccount;

public class GroupAccountTest {
	public static void main(String[] args) {

		GroupAccountRepository groupAccountRepository = new GroupAccountRepository();

		System.out.println("***********GET ALL GROUP ACCOUNT***********");
		List<GroupAccount> groupAccounts = groupAccountRepository.getAllGroupAccount();
		for (GroupAccount groupAccount : groupAccounts) {
			System.out.println(groupAccount);
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
