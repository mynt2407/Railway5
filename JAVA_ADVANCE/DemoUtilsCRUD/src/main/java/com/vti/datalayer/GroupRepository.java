package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.github.fluent.hibernate.internal.util.InternalUtils.HibernateUtils;
import com.vti.entity.Group;

public class GroupRepository {
	com.vti.Utils.HibernateUtils hibernateUtils;

 public GroupRepository() {
	
	hibernateUtils = com.vti.Utils.HibernateUtils.getInstance();
}
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroup() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Group getGroupById(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get Department by Id
			Group group = session.get(Group.class, id);
			return group;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Group getGroupByName(String name) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get hql query

			Query<Group> query = session.createQuery("FROM Group WHERE name =: nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);
			// get result
			Group group = query.uniqueResult();
			return group;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createGroup(Group group) {
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(group);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Cach 1: update by Id
	public void updateGroup(short id, String newName) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get parameter
			Group group = session.load(Group.class, id);

			// update
			group.setName(newName);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	// Cach 2: update all group
	public void updateGroup(Group group) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteGroup(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group
			Group group = session.load(Group.class, id);

			// update
			session.delete(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isGroupExistById(short id) {
		// get group
		Group group = getGroupById(id);
		// return result
		if (group == null) {
			return false;
		}
		return true;
	}

	public boolean isGroupExistByName(String name) {
		// get group
		Group group = getGroupByName(name);
		// return result
		if (group == null) {
			return false;
		}
		return true;
	}

}