package com.hbma.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	
	private static SessionFactory factory;
	
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		if(factory == null){
			factory = buildSessionFactory();
		}
		return factory;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}

}
