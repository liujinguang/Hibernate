package xyyj.chapter04;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BusinessService {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration()
							 .configure()
							 .buildSessionFactory();
	}
	
	public List findAll(Class clazz) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List list = null;
		
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from " + clazz.getSimpleName()).list();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public void saveObject(Object object) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void deleteAll(Class clazz) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("delete from " + clazz.getSimpleName());
			query.executeUpdate();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			throw e;
		} finally {
			session.close();
		}
	}
}
