package com.vti.service;


import java.util.List;

import javax.validation.constraints.NotNull;

import com.vti.datalayer.AccountRepository;
import com.vti.dto.AccountDto;
import com.vti.entity.Account;

public class AccountService {
	private AccountRepository repository;

	public AccountService() {
		repository = new AccountRepository();
	}

	public List<Account> getAllAccount() {
		return null;
	}

	public Account getAccountByEmail(@NotNull String email) {
		return repository.getAccountByEmail(email);
	}

	public boolean isAccountExistByEmail(@NotNull String email) {
		return repository.isAccountExistByEmail(email);
	}

	public Account getAccountByUserName(@NotNull String userName) {
		return repository.getAccountByUserName(userName);
	}

	public boolean isAccountExistByUserName(@NotNull String userName) {
		return repository.isAccountExistByUserName(userName);
	}

	public void createAccount(AccountDto dto) {
		Account entity = dto.toEntity();
		repository.createAccount(entity);
	}

	public Account getAccountById(@NotNull short id) {
		return repository.getAccountById(id);
	}

	public boolean isAccountExistById(@NotNull short id) {
		return repository.isAccountExistById(id);
	}

	public void updateAccount(AccountDto dto) {
		Account entity = dto.toEntity1();
		repository.updateAccount(entity);
	}
}
