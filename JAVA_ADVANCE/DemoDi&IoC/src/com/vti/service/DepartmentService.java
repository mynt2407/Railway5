package com.vti.service;

import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.IAccountRepository;

public class DepartmentService {
	private IDepartmentService departmentService;
	private IAccountRepository accountRepository;

	public DepartmentService(DepartmentRepository departmentRepository, AccountRepository accountRepository) {

	this.accountRepository = accountRepository;
	this.departmentService = departmentService;
			}

}
