package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Ultils.JdbcUltils;
import com.vti.entity.Account;
import com.vti.entity.ExceptionEmailAccount;
import com.vti.entity.ExceptionIdAccount;
import com.vti.entity.ExceptionNameAccount;

public class AccountRepository implements IAccountRepository {
	private JdbcUltils jdbcUltils;
	private Connection connection;

	public AccountRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
	}

	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		List<Account> accounts = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listAccount = "SELECT * FROM testingsystem.account";
			ResultSet resultSet = statement.executeQuery(listAccount);

			// Step 5: Handling result set
			while (resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("AccountID"));
				account.setName(resultSet.getString("Full_name"));
				account.setEmail(resultSet.getString("Email"));
				accounts.add(account);

			}
			return accounts;
		} finally {
			// Step 6: Close connection
			connection.close();
		}

	}

	@Override
	public Account getAccountById() throws Exception {
		try {
			// step 2: get connection
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String sql = "SELECT *\r\n" + "FROM `Account`\r\n" + "WHERE AccountID = 2";
			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: Handling result set

			if (resultSet.next()) {

				Account account = new Account();
				account.setId(resultSet.getInt("AccountID"));
				account.setName(resultSet.getString("Full_name"));
				return account;
			} else {
				throw new Exception("Can't find that!");
			}
		} finally {
			// Step 6: close connect
			connection.close();
		}
	}

	@Override
	public Account getAccountByIdbyScanner(int id) throws ClassNotFoundException, SQLException {
		try {
			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "SELECT *\r\n" + "FROM `Account`\r\n" + "WHERE AccountID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("AccountID"));
				account.setName(resultSet.getString("Full_name"));
				return account;
			}
			return null;

		} finally {
			connection.close();
		}
	}

	@Override
	public boolean isAccountNameExists(String userName)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT *\r\n" + "FROM `Account`\r\n" + "WHERE User_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, userName);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}
	}

	@Override
	public int createAccount(String email, String userName, String fullName, int id) throws ExceptionNameAccount,
			ExceptionIdAccount, ExceptionEmailAccount, ClassNotFoundException, SQLException, Exception {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "INSERT INTO  `Account` (Email, User_name, Full_name, 	DepartmentID) "
					+ " VALUES 						(?,			?,		?,			?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fullName);
			preparedStatement.setInt(4, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			System.out.println("Effect Amount" + effectedRecodAmount);

			return effectedRecodAmount;

		} finally {
			connection.close();
		}
	}

	@Override
	public boolean isAccountIdExists(int id)
			throws ExceptionNameAccount, ClassNotFoundException, SQLException, ExceptionIdAccount {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT *\r\n" + "FROM `Account`\r\n" + "WHERE AccountID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}
	}

	@Override
	public int updateAccountName(int id, String newUserName, String gender) throws Exception {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "UPDATE `Account`" + "SET User_name = ? ," + "	Gender = ? " + " WHERE AccountID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, newUserName);
			preparedStatement.setString(2, gender);
			preparedStatement.setInt(3, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			System.out.println("So hang duoc update thanh cong: " + effectedRecodAmount);

			return effectedRecodAmount;
		} finally {
			connection.close();
		}

	}

	@Override
	public int deleteAccount(int id)
			throws ClassNotFoundException, SQLException, ExceptionIdAccount, ExceptionNameAccount {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "DELETE \r\n" + "FROM `Account`\r\n" + "WHERE AccountID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			System.out.println("So hang da duoc delete: " + effectedRecodAmount);

			return effectedRecodAmount;

		} finally {
			connection.close();
		}
	}

	@Override
	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {

		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT *\r\n" + "FROM `Account`\r\n" + "WHERE Email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}

	}
}