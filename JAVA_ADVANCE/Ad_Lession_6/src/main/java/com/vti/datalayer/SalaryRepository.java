package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.github.fluent.hibernate.internal.util.InternalUtils.HibernateUtils;
import com.vti.entity.Position;
import com.vti.entity.Salary;

public class SalaryRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

	public SalaryRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalary() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary salary) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(salary);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}