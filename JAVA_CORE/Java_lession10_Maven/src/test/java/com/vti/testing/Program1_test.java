package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Properties;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public abstract class Program1_test {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		
		// Step 1: register the driver class with DriverManager
		Class.forName(driver);

		// Step 2: get a Database Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		Properties properties1 = new Properties();
		properties1.load(new FileInputStream("src/main/resource/message.properties"));
		String connectionMessage = properties1.getProperty("connection.success");

		// READ DATA

		// Step 3: Create a statment object

		Statement statement = connection.createStatement();

		// Step 4: excute query
		String sql = "SELECT username, email, phone FROM testingsystem.user";
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: Handling result set
		while (resultSet.next()) {

			System.out.println(resultSet.getString("username"));
			System.out.println(resultSet.getString("email"));
			System.out.println(resultSet.getLong("phone"));
			System.out.println("--------------");
		}

		// CREATE DATA

		// Step 4: Create a statment object
		String sql1 = "INSERT INTO `Question_Category` 	(`name` ,	`Testing_Category_ID`,author_ID)\r\n"
				+ "VALUE								('OOP4',			1, 					4)	";
		int effectedRecodAmount = statement.executeUpdate(sql1);

		// Step 5: Handling result set
		System.out.println("Effected record Amount " + effectedRecodAmount);

		// Step 6: Close Connection
		connection.close();
	}
}
