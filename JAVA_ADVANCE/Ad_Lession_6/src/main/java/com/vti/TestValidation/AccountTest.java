package com.vti.TestValidation;

import com.vti.controller.AccountController;
import com.vti.dto.AccountDto;

public class AccountTest {
	public static void main(String[] args) {
		AccountController controller = new AccountController();

//		AccountDto accountCreate = new AccountDto("Neo Nguyen", "", "Neo", "Nguyen");
//		controller.createAccount(accountCreate);
		
		AccountDto accountDto = new AccountDto((short) 0, "My@gmail.com", "NeoNguyen");
		controller.updateAccount(accountDto);
	}
}
