package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;
import com.vti.Ultils.FileManager;
import com.vti.Ultils.JdbcUltils;
import com.vti.Ultils.ScannerUtils;
import com.vti.entity.Department;
import com.vti.entity.ExeceptionIdDepartment;
import com.vti.entity.ExeceptionNameDepartment;

/**
 * This class is .
 * 
 * @Description: .
 * @author: My Nguyen
 * @create_date: Oct 20, 2020
 * @version: 1.0
 * @modifer: My Nguyen
 * @modifer_date: Oct 20, 2020
 */
public class DepartmentDao {
	JdbcUltils jdbcUltils;
	Connection connection;

	/**
	 * Constructor for class DepartmentDao.
	 * 
	 * @Description: .
	 * @author: My Nguyen
	 * @create_date: Oct 20, 2020
	 * @version: 1.0
	 * @modifer: My Nguyen
	 * @modifer_date: Oct 20, 2020
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public DepartmentDao() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();

	}

//	Question 1: read data – get list departments
//	Tạo method để lấy ra danh sách tất cả các Department
//	Gợi ý:
//	Viết method getDepartments() và return ra
//	List<Department>, Nếu có lỗi sẽ throw Exception lên frontend để in ra
//	Trên front-end sẽ gọi class DepartmentDao và demo method này

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: My Nguyen
	 * @create_date: Oct 21, 2020
	 * @version: 1.0
	 * @modifer: My Nguyen
	 * @modifer_date: Oct 21, 2020
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Department> getDepartment() throws ClassNotFoundException, SQLException {

		List<Department> departments = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.connect();
			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listDepartment = "SELECT * FROM testingsystem.department";
			ResultSet resultSet = statement.executeQuery(listDepartment);

			// Step 5: Handling result set
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentID"));
				department.setName(resultSet.getString("DepartmentName"));
				departments.add(department);

			}
			return departments;
		} finally {
			// Step 6: Close connection
			connection.close();
		}

	}

//	Question 2: read data – get department by id
//	Tạo method để lấy ra Department có id = 5
//	Gợi ý: Làm tương tự câu trên
//	Nếu không có department nào có id = 5 thì sẽ in ra là
//	"Cannot find department which has id = 5"
//	Nếu có lỗi sẽ throw Exception lên front-end để in ra
//	Trên front-end sẽ gọi class DepartmentDao và demo method này

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: My Nguyen
	 * @create_date: Oct 20, 2020
	 * @version: 1.0
	 * @modifer: My Nguyen
	 * @modifer_date: Oct 20, 2020
	 * @return
	 * @throws Exception
	 */
	public Department getDepartmentById() throws Exception {
		try {
			// step 2: get connection
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String sql = "SELECT * \r\n" + "FROM testingsystem.department\r\n" + "WHERE DepartmentID = 5";
			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: Handling result set

			if (resultSet.next()) {

				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentID"));
				department.setName(resultSet.getString("DepartmentName"));
				return department;
			} else {
				throw new Exception("Can't find that!");
			}
		} finally {
			// Step 6: close connect
			connection.close();
		}
	}
//	Question 3: Tiếp tục Question 2 (read data – get department by id)
//	Không fix cứng id nữa mà sẽ dùng scanner để yêu cầu người dùng
//	nhập vào id, sau đó trả về thông tin department có id như người dùng nhập vào
//	Gợi ý:
//	Trên backend sẽ viết method getDepartmentById(int id) và
//	return ra Department
//	Nếu tìm thấy department có id = parameter thì sẽ return
//	về department đó
//	Nếu không tìm thấy thì sẽ throw ra với message
//	"Cannot find department which has id = " + id
//	Nếu có lỗi sẽ throw Exception lên front-end để in ra này

	public Department getDepartmentByIdbyScanner(int id) throws ClassNotFoundException, SQLException {

		try {
			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "SELECT * \r\n" + "FROM testingsystem.department\r\n" + "WHERE DepartmentID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentID"));
				department.setName(resultSet.getString("DepartmentName"));
				return department;

			}
			return null;
		} finally {
			connection.close();
		}
	}

//	Question 4: check data exists – check department name exists
//	Tạo method để check department name có tồn tại hay không?
//	Gợi ý:
//	Trên backend sẽ viết method
//	isDepartmentNameExists(String name) và return ra boolean
//	Nếu tìm thấy department đã có name = name parameter thì sẽ return true
//	Nếu không tìm thấy thì sẽ return ra false
//	Nếu có lỗi sẽ throw Exception lên front-end để in ra
//	Trên front-end sẽ gọi class DepartmentDao và demo method này

	public boolean isDepartmentNameExists(String name)
			throws ExeceptionNameDepartment, ClassNotFoundException, SQLException {

		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * \r\n" + "FROM testingsystem.department \r\n" + "WHERE DepartmentName = ? ";
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

//	Question 5: create data – create department
//	Tạo method để người dùng có thể tạo được department
//	Gợi ý:
//	Trên backend sẽ viết method void createDepartment (String name)
//	Check xem đã có department nào có tên như parameter
//	chưa (sử dụng method ở Question 6 để check)
//	Nếu tìm đã có department có tên như parameter
//	thì throw ra Exception "Department Name is Exists!"
//	Nếu không tìm thấy thì sẽ create department
//	Nếu có lỗi sẽ throw Exception lên front-end để in ra
//	Trên front-end sẽ gọi class DepartmentDao và demo method
//	này (dùng scanner để nhập thông tin của department muốn create)


	/**
	 * This method is: tao moi phong ban
	 * 
	 * @Description: .
	 * @author: My Nguyen
	 * @create_date: Oct 21, 2020
	 * @version: 1.0
	 * @modifer: My Nguyen
	 * @modifer_date: Oct 21, 2020
	 * @param name
	 * @return
	 * @throws ExeceptionNameDepartment :bat loi trung ten
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public int createDepartment(String name)
			throws ExeceptionNameDepartment, ClassNotFoundException, SQLException, Exception {
		try {

			if (isDepartmentNameExists(name)) {
				throw new ExeceptionNameDepartment("Department Name is Exists!");
			} else {
				// Step 2: get connect
				connection = jdbcUltils.connect();

				// Step 3: Create a statement object
				String sql = "INSERT INTO Department  ( DepartmentName ) " + " VALUES   ( ? ) ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// set parameter
				preparedStatement.setString(1, name);

				// Step 4: Execute Query

				int effectedRecodAmount = preparedStatement.executeUpdate();

				// Step 5: Handling result
				System.out.println("Effect Amount" + effectedRecodAmount);

				return effectedRecodAmount;
			}
		} finally {
			connection.close();
		}
	}

//	Question 6: update data – update department
//	Tạo method để người dùng có thể update được department name
//	Gợi ý:
//	Trên backend sẽ viết method void updateDepartmentName (int id, String newName)
//	Check xem đã có department nào có id như id
//	parameter chưa (Viết thêm method như Question 6 để
//	check, tên method là isDepartmentIdExists(int id))
//	Nếu không tìm thấy department có id = id
//	parameter thì sẽ throw ra Exception có message
//	"Cannot find department which has id = " + id
//	Nếu tìm thấy department có id = id parameter thì
//	sẽ check xem tên mới của department có bị
//	trùng không (sử dụng method ở Question 6 để check)
//	Nếu tìm đã có department có tên như parameter
//	thì throw ra Exception "Department Name is Exists!"

	public boolean isDepartmentIdExists(int id) throws ExeceptionNameDepartment, ClassNotFoundException, SQLException {
		try {

			// step 2: get connect
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
		} finally {
			connection.close();
		}
	}

	public int updateDepartmentName(int id, String newName) throws Exception {
		try {

			if (!isDepartmentIdExists(id)) {
				throw new ExeceptionIdDepartment("Cannot find department which has id = " + id);
			}

			if (isDepartmentNameExists(newName)) {
				throw new ExeceptionNameDepartment("Department Name is Exists!");
			}

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "UPDATE department\r\n" + "SET DepartmentName = ? \r\n" + "WHERE DepartmentID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			System.out.println("So hang duoc update thanh cong: " + effectedRecodAmount);

			return effectedRecodAmount;
		} finally {
			connection.close();
		}
	}

//	Question 7:
//		Tạo method để người dùng có thể xóa được department theo id mà user nhập vào
//		Gợi ý:
//		Trên backend sẽ viết method void deleteDepartment (int id)
//		Check xem đã có department nào có id như id
//		parameter chưa (sử dụng method ở Question 6 để
//		check)
//		Nếu không tìm thấy department có id = id
//		parameter thì sẽ throw ra Exception có message
//		"Cannot find department which has id = " + id
//		Nếu tìm thấy thì sẽ delete department đó
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này (dùng scanner để nhập vào id của department muốn delete)

	public int deleteDepartment(int id)
			throws ClassNotFoundException, SQLException, ExeceptionIdDepartment, ExeceptionNameDepartment {
		try {

			if (!isDepartmentIdExists(id)) {
				throw new ExeceptionIdDepartment("Cannot find department which has id = " + id);
			}

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = "DELETE\r\n" + "FROM department\r\n" + "WHERE DepartmentID = ? ";
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
}
