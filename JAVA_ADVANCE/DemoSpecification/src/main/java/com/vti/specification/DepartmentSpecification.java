package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class DepartmentSpecification implements Specification<Department> {

	private static final long serialVersionUID = 1L;

	private SearchCriteria criteria;
	
	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getOperation().equalsIgnoreCase("Like")) {
			return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
			
		} else if (criteria.getOperation().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
			
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		}

		return null;
	}

}
