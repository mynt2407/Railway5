package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.entity.Address;
import com.vti.entity.Group;

public class AddressRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

	public AddressRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddress() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAddress(Address address) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(address);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}