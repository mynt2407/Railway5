package com.vti.container;

import com.vti.controller.DepartmentController;
import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.service.DepartmentService;

public class DIContainer {

	//Component là thành phần của DI Container hay là 1 class
	public DepartmentController initController() {
		DepartmentService departmentService= initDepartmentService();
		//bean là instance
		return new DepartmentController(departmentService);
	}

	public DepartmentService initDepartmentService() {
		DepartmentRepository departmentRepository = initDepartmentRepository();
		AccountRepository accountRepository = initAccountRepository();
		
		return new DepartmentService(departmentRepository, accountRepository);
	}
	
	public DepartmentRepository initDepartmentRepository() {
		return new DepartmentRepository();
	}
	public AccountRepository initAccountRepository() {
		return new AccountRepository();
	}
}
