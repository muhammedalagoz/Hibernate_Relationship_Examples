package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory hibernateSessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			hibernateSessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return hibernateSessionFactory;
	}
	
	public static void closeSessionFactory() {
        if (hibernateSessionFactory != null)
            hibernateSessionFactory.close();        
    }
}