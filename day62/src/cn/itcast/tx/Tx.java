package cn.itcast.tx;


import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.utils.HibernateUtil;

public class Tx {

	public void tx(ProceedingJoinPoint pjp) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			pjp.proceed();
			tx.commit();
		} catch (Throwable t) {
			tx.rollback();
			t.printStackTrace();
		}
	}
}
