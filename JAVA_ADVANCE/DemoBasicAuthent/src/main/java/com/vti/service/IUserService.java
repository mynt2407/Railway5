package com.vti.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.User;

//UserDetailsService: co san cua Spring, khi lam login phai extend thang nay
public interface IUserService extends UserDetailsService {
	List<User> getAllUsers();
}
