package com.vti.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.User;
import com.vti.utils.JdbcUltils;

public class UserRepository implements IUserRepository {
	private JdbcUltils jdbcUltils;
	private Connection connection;

	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
	}

	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listUser = "SELECT * FROM testingsystem.user";
			ResultSet resultSet = statement.executeQuery(listUser);

			// Step 5: Handling result set
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setFullName(resultSet.getString("firstName"));
				user.setRole(resultSet.getString("role"));

				users.add(user);

			}
			return users;
		} finally {
			// Step 6: Close connection
			connection.close();
		}

	}

	@Override
	public User getUserById(int id) throws Exception {
		try {
			// step 2: get connection
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "SELECT *\n" + "FROM `user`\n" + "WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setFullName(resultSet.getString("firstName"));
				user.setRole(resultSet.getString("role"));
				return user;
			} else {
				throw new Exception("Can't find that!");
			}
		} finally {
			// Step 6: close connect
			connection.close();
		}
	}

	@Override
	public boolean isUserNameExists(String name) throws ClassNotFoundException, SQLException {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT *\n" + "FROM `user`\n" + "WHERE username = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, name);

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
	public int createUser(String userName, String password, String firstName, String lastName)
			throws ClassNotFoundException, SQLException, Exception {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "INSERT INTO `User` (`username`,			`password`,			`firstName`,	`lastName`)\n"
					+ "VALUE	(?,			?,		?,			?) \n";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, lastName);

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
	public boolean isUserIdExists(int id) throws ClassNotFoundException, SQLException {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT *\n" + "FROM `user`\n" + "WHERE id = ?";
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
	public int updateUserName(int id, String password, String firstName, String lastName) throws Exception {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "UPDATE `User` " + "SET " + "    firstName = ?, " + " lastName = ?, " + "    `password` = ? "
					+ "WHERE " + "    id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(3, lastName);
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
	public int deleteAccount(int id) throws ClassNotFoundException, SQLException {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "DELETE\n" + "FROM `User`\n" + "WHERE id = ?";
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
	public User login(String username, String password) throws Exception {

		// step 2: get connect
		connection = jdbcUltils.connect();

		// Step 3: Create a statement object

		String sql = "SELECT id, username, firstname, role " + "FROM `User`" + "WHERE username = ? AND `password` = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		// Step 4: Execute Query

		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: Handling result
		if (resultSet.next()) {

			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setFullName(resultSet.getString("firstName"));
			user.setRole(resultSet.getString("role"));

			// disconnect
			connection.close();
			return user;
		}else {
			// disconnect
			connection.close();
			return null;
		}

	}

}