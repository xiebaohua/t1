package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory ;
	static{
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
	
	public static void main(String[] args) {
		Session session = getCurrentSession();
	}
}
