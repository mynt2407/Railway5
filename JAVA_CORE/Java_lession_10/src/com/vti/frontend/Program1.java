package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Program1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/TestingSystem?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: get a Database Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success!");

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
				    + "VALUE								('OOP1',			1, 					4)	";
		int effectedRecodAmount = statement.executeUpdate(sql1);

		// Step 5: Handling result set
		System.out.println("Effected record Amount " + effectedRecodAmount);

		// Step 6: Close Connection
		connection.close();
	}
}
