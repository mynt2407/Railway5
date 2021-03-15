package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public interface IAccountService {
	List<Account> getListAccounts() throws ClassNotFoundException, SQLException;

	Account getAccountById() throws Exception;

	Account getAccountByIdbyScanner(int id) throws ClassNotFoundException, SQLException;

	boolean isAccountNameExists(String name) throws ExceptionNameAccount, ClassNotFoundException, SQLException;

	public int createAccount(String email, String userName, String fullName, int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, Exception, ExceptionIdAccount;

	boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException;

	boolean isAccountIdExists(int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, ExceptionIdAccount;

	int deleteAccount(int id) throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount;

	int updateAccountName(int id, String newUserName, String gender) throws Exception;

}
