package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Department;

//Để làm việc với specification implement JpaSpecificationExecutor
public interface IDepartmentRepository extends JpaRepository<Department, Short>, JpaSpecificationExecutor<Department> {

	public Department findByName(String name);

	//public boolean existsByName(String name);
}
