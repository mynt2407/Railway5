package com.vti.Utils;

import javax.naming.ConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class HibernateUtils {

	private static HibernateUtils hibernateUtils;
	private Configuration configuration;
	private SessionFactory sessionFactory;

	/* Contructor for class hibernateUtil. Dang private */

	private HibernateUtils() {
		configure();
	}

	/* Method Singleton to get object HibernateUtils */

	@SuppressWarnings("unused")
	public static HibernateUtils getInstance() {
		if (hibernateUtils == null) {
			hibernateUtils = new HibernateUtils();
		}
		return hibernateUtils;

	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// auto scan entity
		EntityScanner.scanPackages("com.vti.entity").addTo(configuration);
	}

	public SessionFactory buildSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	public void closeFactory() {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();

	}

}
