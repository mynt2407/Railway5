package com.vti.controller;

import java.util.List;

import com.vti.service.DepartmentService;
import com.vti.service.IDepartmentService;

public class DepartmentController {
	private IDepartmentService service;
	
	public DepartmentController(DepartmentService departmentService) {
		this.service = service;
	}
	public List<String> getAllDepartments() {
		return service.getAllDepartments();
	}
}
