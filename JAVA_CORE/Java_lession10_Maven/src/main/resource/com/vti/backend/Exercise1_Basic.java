package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exercise1_Basic {
	private Properties properties;
	private Connection connection;

	public Exercise1_Basic() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));
		properties.load(new FileInputStream("src/main/resource/message.properties"));
		connect();
	}

//	Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
//	Tạo connection tới database Testing System
//	In ra "Connect success!" khi kết nối thành công.

	public void connect() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		// Step 1: register the driver class with DriverManager
		Class.forName(driver);

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);
		String connectionMessage = properties.getProperty("connect.success");

	}

//	Question 2: Tạo method để in ra các thông tin của position gồm có id, name
	public void readPosition() throws SQLException {
		// Step 3: Create a statment object
		Statement statement = connection.createStatement();

		// Step 4: excute query

		String positionSql = "SELECT * FROM testingsystem.position";
		ResultSet resultSet = statement.executeQuery(positionSql);

		// Step 5: Handling result set
		while (resultSet.next()) {
			System.out.println(resultSet.getString("PositionID"));
			System.out.println(resultSet.getString("PositionName"));
		}

	}

//	Question 3: Tạo method để tạo position, user sẽ nhập vào name.

	public void createPosition() throws SQLException {
		// Step 3: Create a statment object
		Statement statement = connection.createStatement();
		String positionUpdate = "INSERT INTO Position   (PositionName) " + "VALUES	(	?	)";
		PreparedStatement preparedStatement = connection.prepareStatement(positionUpdate);

		// input from scanner
		String positionName = "New Position 1";

		// set parameter
		preparedStatement.setString(1, positionName);

		// Step 4: Excute SQl query
		int effectAmount = preparedStatement.executeUpdate();

		// step 5: hanlding result set
		System.out.println("Effect Record Amount: " + effectAmount);
	}

	// Question 4: Tạo method để update tên của position gồm có id = 5 thành "Dev".
	public void updatePosition() throws SQLException {
		// Step 3: Create a statment object
		String updatePosition = "UPDATE `Position` " + "SET PositionName = ? " + "WHERE PositionID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(updatePosition);

		// input from scanner

		String groupName = "DEV";
		int groupId = 5;

		// set parameter

		preparedStatement.setString(1, groupName);
		preparedStatement.setInt(2, groupId);

		// Step 4: Execute SQL query
		int effectRound = preparedStatement.executeUpdate();

		// Step 5: Handling Update
		System.out.println("Số hàng được update thành công " + effectRound);
	}

//	Question 5: Tạo method để delete position theo id và user sẽ nhập vào id
	public void deletePosition() throws SQLException {
		String deletePosition = "DELETE " + "FROM Position " + "WHERE PositionID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(deletePosition);

		// input from scanner
		int positionId = 1;

		// set parameter
		preparedStatement.setInt(1, positionId);

		// Step 4: Excute SQl query
		int effectAmount = preparedStatement.executeUpdate();

		// Step 5: Handling delete
		System.out.println("Đã xóa " + effectAmount + " hàng");
		connection.close();
	}
}
