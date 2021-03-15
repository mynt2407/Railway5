package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.AccountDtoCreate;
import com.vti.entity.Account;
import com.vti.service.AccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Validated

public class AccountController {
	AccountService service;

	public AccountController() {
		service = new AccountService();
	}

	@GetMapping
	public ResponseEntity<?> getAllAccount() {
		// get data
		List<Account> entities = service.getAllAccount();

		List<AccountDto> dtos = new ArrayList<>();

		// convert entity to dto
		for (Account entity : entities) {
			dtos.add(entity.getEmail());
			dtos.add(entity.getFullName());
		}
		return new ResponseEntity<List<AccountDto>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") @Min(1) short id) {
		return new ResponseEntity<String>("Sale", HttpStatus.OK);
	}

	// Cách 1: @Validated(OnCreate.class)
	// Cách 2: Valid thằng AccountDtoCreate
	@PostMapping
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountDtoCreate dto) {

		System.out.println(dto);

		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}

	// @Validated(OnUpdate.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@Valid @PathVariable(name = "id") short id, @RequestBody AccountDto dto) {

		System.out.println(dto);

		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

}
