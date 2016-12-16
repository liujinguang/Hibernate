package xyyj.chapter02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BusinessService {
	public static SessionFactory sessionFactory;
	
	static {
		try {
			//the hibernate.properties must be put in the classpath directory.
//			Properties properties = new Properties();
			
//			FileInputStream in;
//			try {
//				in = new FileInputStream(BusinessService.class.getResource("hibernate.properties").getPath());
//				
//				properties.load(in);
//				in.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO: handle exception
//			}

			
			Configuration cfg = new Configuration();
//			cfg.addProperties(properties);
			cfg.addClass(Monkey.class);
			
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
