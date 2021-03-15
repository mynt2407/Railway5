package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.filter.DepartmentFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DepartmentSpecificationBuilder {

	private DepartmentFilter filter;
	private String search;

	@SuppressWarnings("deprecation")
	public Specification<Department> build() {
		
		//Specification tuong duong voi 1 cau where

		SearchCriteria searchCriteria = new SearchCriteria("name", "Like", search);

		SearchCriteria minIDCriteria = new SearchCriteria("id", ">",  filter.getMinID());

		SearchCriteria maxIDCriteria = new SearchCriteria("id", "<", filter.getMaxID());

		Specification<Department> where = null;

		// search by name
		if (!StringUtils.isEmpty(search)) {
			where = new DepartmentSpecification(searchCriteria);
		}

		// filter
		// Phai check khac khong de danh dau nguoi dung nhap vao. Khoi tao mac dinh ban dau int =0
		if (filter.getMaxID() != 0) {
			if (where != null) {
				// "and" la where1 + where2 (lay ca filter va search. Co the dung "or" tuy
				// logic)
				where = where.and(new DepartmentSpecification(maxIDCriteria));
			} else {
				where = new DepartmentSpecification(maxIDCriteria);
			}

		}

		// filter
		if (filter.getMinID() != 0) {
			if (where != null) {
				where = where.and(new DepartmentSpecification(minIDCriteria));
			} else {
				where = new DepartmentSpecification(minIDCriteria);
			}
		}

		return where;
	}
}
