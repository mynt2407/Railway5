package com.vti.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	List<User> getListUser() throws ClassNotFoundException, SQLException;

	User getUserById(int id) throws Exception;

	boolean isUserNameExists(String name) throws  ClassNotFoundException, SQLException;

	int createUser(String userName, String password, String firstName, String lastName)
			throws  ClassNotFoundException, SQLException, Exception;

	boolean isUserIdExists(int id)
			throws ClassNotFoundException, SQLException;

	int updateUserName(int id, String password, String firstName, String lastName) throws Exception;

	int deleteAccount(int id) throws ClassNotFoundException, SQLException ;

	User login(String username, String password) throws Exception;
}
