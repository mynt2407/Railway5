package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Utils.Paging;
import com.vti.Utils.Sorting;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	@Override
	public List<Department> getAllDepartment(Paging paging, Sorting sort, FilterDepartment filter,  String search) {
		return repository.getAllDepartment(paging,sort, filter,  search );
	}

	@Override
	public Department getDepartmentById(short id) {
		return repository.getDepartmentById(id);
	}

	@Override
	public Department getDepartmentByName(String name) {
		return repository.getDepartmentByName(name);
	}

	@Override
	public void createDepartment(Department department) {
		repository.createDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		repository.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(short id) {
		repository.deleteDepartment(id);
	}

	@Override
	public boolean isDepartmentExistById(short id) {
		return repository.isDepartmentExistById(id);
	}

	@Override
	public boolean isDepartmentExistByName(String name) {
		return repository.isDepartmentExistByName(name);
	}

}
