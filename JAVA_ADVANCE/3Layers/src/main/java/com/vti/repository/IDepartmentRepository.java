package com.vti.repository;

import java.util.List;

import com.vti.Utils.Paging;
import com.vti.Utils.Sorting;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;

public interface IDepartmentRepository {
	List<Department> getAllDepartment(Paging paging, Sorting sort, FilterDepartment filter, String search);

	Department getDepartmentById(short id);

	Department getDepartmentByName(String name);

	void createDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(short id);

	boolean isDepartmentExistById(short id);

	boolean isDepartmentExistByName(String name);

}
