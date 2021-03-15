package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.entity.DetailDepartment;
import com.vti.entity.Group;

public class DetailDepartmentRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DetailDepartment> getDetailDepartment() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDetailDepartment(DetailDepartment detailDepartment) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(detailDepartment);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}