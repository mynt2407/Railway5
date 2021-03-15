package com.vti.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.vti.entity.Department;
import com.vti.filter.DepartmentFilter;

public interface IDepartmentService {
	public List<Department> getAllDepartments(DepartmentFilter filter, @ RequestParam String search);
}
