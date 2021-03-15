package com.vti.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import com.vti.Ultils.JdbcUltils;

//Question 1:
//Tạo 1 method để thực thi các bước sau:
//B1: xóa tất cả các nhân viên thuộc phòng ban 3
//B2: xóa phòng ban 3
//Với điều kiện: khi xóa B1 bị lỗi thì sẽ rollback lại

public class Exercise4_Transaction {
	private JdbcUltils jdbcUltils;
	private Connection connection;

	public Exercise4_Transaction() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
		connection = jdbcUltils.connect();
	}

	public int deleteAccount() throws ClassNotFoundException, SQLException {
		// Step 3:
		String sql = "{CALL xoa_Account (1)}";
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall(sql);

		// Step 4: Execute Query
		int effectAmout = callableStatement.executeUpdate();

		// Step 5: Handling resultSet
		System.out.println("So Account da xoa " + effectAmout);

		return effectAmout;

	}

	public int deleteDepartment() throws ClassNotFoundException, SQLException {
		// Step 3:
		String sql = "{CALL xoa_Department (abc)}";
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall(sql);

		// Step 4: Execute Query
		int effectAmout = callableStatement.executeUpdate();

		// Step 5: Handling resultSet
		System.out.println("So Department da xoa " + effectAmout);

		return effectAmout;

	}

	public void transaction() throws ClassNotFoundException, SQLException {
		// turn off auto commit
		connection.setAutoCommit(false);

		// Delete transaction
		try {
			deleteAccount();
			deleteDepartment();

			// comit transaction
			connection.commit();
			System.out.println("Transaction comit");

		} catch (Exception e) {
			// e.printStackTrace();
			connection.rollback();
			System.out.println("Transaction RollBack!");
		}

		// turn on auto comit
		connection.setAutoCommit(true);

		// step 6: Close connection
		connection.close();
	}

}
