package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import com.mysql.cj.jdbc.CallableStatement;
import com.vti.Ultils.JdbcUltils;
import com.vti.entity.ExeceptionIdDepartment;
import com.vti.entity.ExeceptionNameDepartment;

public class Exercise3_Call_Procedure {
	JdbcUltils jdbcUltils;
	Connection connection;

	public Exercise3_Call_Procedure() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
	}

//	Question 1:
//		Tạo method để yêu cầu người dùng nhập vào id của department, sau đó
//		sẽ xóa department đó. (sử dụng store procedure ở trong MySQL)
//		Gợi ý:
//		B1: Tạo 1 store procedure trong MySQL tên là
//		sp_delete_department() có in parameter là id
//		B2: Trên backend sẽ viết method void
//		deleteDepartmentUsingProcedure(int id)
//		Check xem đã có department nào có id như id
//		parameter chưa (sử dụng method ở Question 6 để check)
//		Nếu không tìm thấy department có id = id
//		parameter thì sẽ throw ra Exception có message
//		"Cannot find department which has id = " + id
//		Nếu tìm thấy thì sẽ delete department đó
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra

	public boolean isDepartmentIdExists(int id) throws ExeceptionNameDepartment, ClassNotFoundException, SQLException {
		// Step 2: get connect
		connection = jdbcUltils.connect();

		// Step 3: Create a statement object

		String sql = "SELECT * \r\n" + "FROM testingsystem.department \r\n" + "WHERE DepartmentID = ? ";
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

	}

	public int deleteDepartmentUsingProcedure(int id)
			throws ClassNotFoundException, ExeceptionNameDepartment, SQLException, ExeceptionIdDepartment {
		if (!isDepartmentIdExists(id)) {
			throw new ExeceptionIdDepartment("Cannot find department which has id = " + id);
		} else {
			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3:
			String sql = "{CALL sp_delete_department (?)}";
			CallableStatement callableStatement = (CallableStatement) connection.prepareCall(sql);

			// Set parameter
			callableStatement.setInt(1, id);

			// Step 4: Execute Query
			int effectAmout = callableStatement.executeUpdate();

			// Step 5: Handling resultSet
			System.out.println("So hang da xoa " + effectAmout);

			return effectAmout;
		}
	}

}
