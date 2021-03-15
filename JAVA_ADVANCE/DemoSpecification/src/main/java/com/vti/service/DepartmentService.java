package com.vti.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.filter.DepartmentFilter;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.DepartmentSpecificationBuilder;

//Nhiem vu cua service la build ra 1 lenh where, service truyen vao 2 tham so la filter va search

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments(DepartmentFilter filter, String search) {

		DepartmentSpecificationBuilder specification = new DepartmentSpecificationBuilder(filter, search);
		return repository.findAll(specification.build());
	}

//	private Specification<Department> greaterThanByID(int id) {
//		return new Specification<Department>() {
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) {
//
//				return criteriaBuilder.greaterThan(root.get("id"), id);
//				// Voi root.get("id") la id duoc lay ra. , id la id nguoi dung nhap vao
//			}
//		};
//	}
//
//	// Ham Lessthan
//	private Specification<Department> lessThanByID(int id) {
//		return new Specification<Department>() {
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) {
//
//				return criteriaBuilder.lessThan(root.get("id"), id);
//			}
//		};
//	}
//
//	// Ham search
//
//	private Specification<Department> searchByName(String name) {
//		return new Specification<Department>() {
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) {
//
//				return criteriaBuilder.like(root.get("name"), "%" + name + "%");
//			}
//		};
//	}

	// Ham Greater than

}
