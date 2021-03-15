package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;

public class GroupAccountRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

	public GroupAccountRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<GroupAccount> getAllGroupAccount() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<GroupAccount> query = session.createQuery("FROM GroupAccount");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createGroupAccount(GroupAccount GroupAccount) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(GroupAccount);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}