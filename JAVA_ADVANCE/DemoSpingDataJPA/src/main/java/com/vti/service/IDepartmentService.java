package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vti.entity.Department;

public interface IDepartmentService {


	public Page<Department> getAllDepartments(int pageNumber, int pageSize, String sortType, String sortField);

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);
}
