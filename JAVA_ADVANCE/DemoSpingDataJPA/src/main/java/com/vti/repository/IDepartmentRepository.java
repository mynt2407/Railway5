package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short> {
	Department findByName(String name);

	List<Department> findAllByTotalMember(Short totalMember);
}
