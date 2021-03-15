package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vti.entity.User;
import com.vti.repository.UserRepository;

public class UserService implements IUserService{

	@Autowired
	private UserRepository repository;
	
	//get User By username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

}
