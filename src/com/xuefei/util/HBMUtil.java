package com.xuefei.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HBMUtil {
	
	private static SessionFactory sf;
	private static Transaction t;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession() {		
		Session session=sf.openSession();
		t=session.beginTransaction();
		return session;
	}
	public static void closeSession(Session session) {
		t.commit();
		session.close();
	}
}
