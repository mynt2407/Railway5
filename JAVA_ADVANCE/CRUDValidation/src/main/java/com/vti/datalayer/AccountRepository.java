package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;

public class AccountRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

	public AccountRepository() {

		hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByEmail(String email) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get hql query

			Query<Account> query = session.createQuery("FROM Account WHERE email =: emailParameter");

			// set parameter
			query.setParameter("emailParameter", email);
			// get result
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistByEmail(String email) {
		// get group
		Account account = getAccountByEmail(email);
		// return result
		if (account == null) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByUserName(String username) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get hql query

			Query<Account> query = session.createQuery("FROM Account WHERE userName =: unameParameter");

			// set parameter
			query.setParameter("unameParameter", username);
			// get result
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistByUserName(String username) {
		// get group
		Account account = getAccountByUserName(username);
		// return result
		if (account == null) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Account getAccountById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get hql query

			Query<Account> query = session.createQuery("FROM Account WHERE id =: idParameter");

			// set parameter
			query.setParameter("idParameter", id);
			// get result
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistById(short id) {
		// get group
		Account account = getAccountById(id);
		// return result
		if (account == null) {
			return false;
		}
		return true;
	}
	
	public void updateAccount(Account account) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}