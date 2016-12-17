package xyyj.chapter03;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BusinessService {
	public static SessionFactory sessionFactory;
	
	static {
		try {
			Configuration cfg = new Configuration()
					.configure(); //加载hibernate.cfg.xml文件中配置信息
			sessionFactory = cfg.buildSessionFactory();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<Monkey> findAllMonkeys() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Monkey as m order by m.name asc");
			List<Monkey> list = query.list();
			tx.commit();
			
			return list;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public Monkey getMonkeyById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Monkey monkey = null;
		
		try {
			tx = session.beginTransaction();
			monkey = (Monkey)session.get(Monkey.class, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return monkey;
	}
	
	public void saveMonkey(Monkey monkey) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(monkey);
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
	
	public void updateMonkey(Monkey monkey) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(monkey);
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
	
	public void deleteMonkey(Monkey monkey) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.delete(monkey);
			
			tx.commit();			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

}
