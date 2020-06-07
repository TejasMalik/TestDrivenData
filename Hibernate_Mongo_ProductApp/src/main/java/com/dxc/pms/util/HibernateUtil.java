package com.dxc.pms.util;

import org.hibernate.SessionFactory;
import org.hibernate.ogm.cfg.OgmConfiguration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		
		OgmConfiguration configuration = new OgmConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
		
	}
	
	
}
