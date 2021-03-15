package com.vti.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.datalayer.IUserRepository;
import com.vti.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService {
	private IUserRepository repository;

	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		repository = new UserRepository();
	}

	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		return repository.getListUser();
	}

	@Override
	public User getUserById(int id) throws Exception {
		return repository.getUserById(id);
	}

	@Override
	public boolean isUserNameExists(String name) throws ClassNotFoundException, SQLException {
		return repository.isUserNameExists(name);
	}

	@Override
	public int createUser(String userName, String password, String firstName, String lastName)
			throws ClassNotFoundException, SQLException, Exception {
		return repository.createUser(userName, password, firstName, lastName);
	}

	@Override
	public boolean isUserIdExists(int id) throws ClassNotFoundException, SQLException {
		return repository.isUserIdExists(id);
	}

	@Override
	public int updateUserName(int id, String password, String firstName, String lastName) throws Exception {
		return repository.updateUserName(id, password, firstName, lastName);
	}

	@Override
	public int deleteAccount(int id) throws ClassNotFoundException, SQLException {
		return repository.deleteAccount(id);
	}

	@Override
	public User login(String username, String password) throws Exception {
		return repository.login(username, password);
	}

}
