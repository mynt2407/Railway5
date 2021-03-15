package com.vti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.UserDTO;
import com.vti.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/Users")
@Validated

public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping()
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO dto) {

		// create User
		service.createUser(dto.toEntity());
		return new ResponseEntity<>("We sent a email. Please check email to active account", HttpStatus.OK);
	}

	//Sau khi gui xac nhan den email. Khi nguoi dung bam vao link thi se chuyen trang thai cua User sang dang da active
	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {
		service.activeUser(token);
		return new ResponseEntity<>("Active success!!!", HttpStatus.OK);
	}

}
