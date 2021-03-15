package com.vti.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.vti.Utils.Paging;
import com.vti.Utils.Sorting;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

	com.vti.Utils.HibernateUtils hibernateUtils;

	public DepartmentRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Department> getAllDepartment(Paging paging, Sorting sort, FilterDepartment filter, String search) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria criteria = session.createCriteria(Department.class);

			// Query<Department> query = session.createQuery("FROM Department");

			//search
			if (!StringUtils.isEmpty(search)) {
				Criterion searchByName = Restrictions.ilike("name", "%" + search + "%" );
				//Criterion searchByID = Restrictions.ilike("id", search);
				
				criteria.add(searchByName);
			}
			
			//filter
			//min member
			if (null != filter.getMinMember()) {
				criteria.add(Restrictions.gt("totalMember", filter.getMinMember().shortValue()));
			}
			//max member
			if (null != filter.getMaxMember()) {
				criteria.add(Restrictions.lt("totalMember", filter.getMaxMember().shortValue()));
			}
			
			// sorting
			criteria.addOrder(sort.getSortType().equals("ASC") ? Order.asc(sort.getSortField())
					: Order.desc(sort.getSortField()));

			// paging
			criteria.setFirstResult((paging.getPageNumber() - 1) * paging.getPageSize());
			criteria.setMaxResults(paging.getPageSize());

			return criteria.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get Department by Id
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get hql query

			Query<Department> query = session.createQuery("FROM Department WHERE name =: nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Department department = query.uniqueResult();
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Cach 1: update by Id
	public void updateDepartment(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get parameter
			Department department = session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	// Cach 2: update all group
	public void updateDepartment(Department department) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group
			Department department = session.load(Department.class, id);

			// update
			session.delete(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistById(short id) {
		// get group
		Department department = getDepartmentById(id);
		// return result
		if (department == null) {
			return false;
		}
		return true;
	}

	public boolean isDepartmentExistByName(String name) {
		// get group
		Department department = getDepartmentByName(name);
		// return result
		if (department == null) {
			return false;
		}
		return true;
	}

}