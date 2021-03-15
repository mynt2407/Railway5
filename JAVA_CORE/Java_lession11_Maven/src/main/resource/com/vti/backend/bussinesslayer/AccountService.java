package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository;

	public AccountService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		accountRepository = new AccountRepository();
	}

	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		return accountRepository.getListAccounts();
	}

	@Override
	public Account getAccountById() throws Exception {
		return accountRepository.getAccountById();
	}

	@Override
	public Account getAccountByIdbyScanner(int id) throws ClassNotFoundException, SQLException {
		return accountRepository.getAccountByIdbyScanner(id);
	}

	@Override
	public boolean isAccountNameExists(String name) throws ExceptionNameAccount, ClassNotFoundException, SQLException {
		return accountRepository.isAccountNameExists(name);
	}

	@Override
	public boolean isAccountIdExists(int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, ExceptionIdAccount {
		return accountRepository.isAccountIdExists(id);
	}

	@Override
	public int deleteAccount(int id)
			throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount {
		return accountRepository.deleteAccount(id);
	}

	@Override
	public int updateAccountName(int id, String newUserName, String gender) throws Exception {

		return accountRepository.updateAccountName(id, newUserName, gender);
	}

	@Override
	public int createAccount(String email, String userName, String fullName, int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, Exception, ExceptionIdAccount {
		return accountRepository.createAccount(email, userName, fullName, id);
	}

	@Override
	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {

		return accountRepository.isAccountEmailExists(email);
	}

}
