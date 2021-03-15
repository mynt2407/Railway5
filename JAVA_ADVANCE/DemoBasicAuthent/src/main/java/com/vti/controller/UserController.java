package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.IUserService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/users")
@PreAuthorize("hasAnyAuthority('Admin')")
public class UserController {

	@Autowired
	private IUserService userservice;
	
	@GetMapping
	public ResponseEntity<?> getAllUser(){
		
		//check xem user da dang nhap chua
		//getContext: co the goi duoc o Controller, Service, Repository
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//AnonymousAuthenticationToken : chua dang nhap
		//if (!(authentication instanceof AnonymousAuthenticationToken)) {
		//	System.out.println( authentication.getName());
		//}
		
		return new ResponseEntity<>(userservice.getAllUsers(), HttpStatus.OK);
	}
}
