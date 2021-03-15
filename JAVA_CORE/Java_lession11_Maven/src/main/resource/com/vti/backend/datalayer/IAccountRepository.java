package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.ExceptionEmailAccount;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public interface IAccountRepository {
	List<Account> getListAccounts() throws ClassNotFoundException, SQLException;

	Account getAccountById() throws Exception;

	Account getAccountByIdbyScanner(int id) throws ClassNotFoundException, SQLException;

	boolean isAccountNameExists(String name) throws ExceptionNameAccount, ClassNotFoundException, SQLException;

	int createAccount(String email, String userName, String fullName, int id)
			throws ExceptionNameAccount, ExceptionIdAccount, ExceptionEmailAccount, ClassNotFoundException, SQLException, Exception;

	boolean isAccountIdExists(int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, ExceptionIdAccount;

	boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException;

	int updateAccountName(int id, String newUserName, String gender) throws Exception;

	int deleteAccount(int id) throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount;

}
