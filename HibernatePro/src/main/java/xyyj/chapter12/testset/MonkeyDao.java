package xyyj.chapter12.testset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.chainsaw.Main;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import xyyj.dbutils.AbstractDao;

public class MonkeyDao extends AbstractDao {
	public MonkeyDao() {
	}
	
	public Monkey loadMonkey(long id) {
		Session session = getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Monkey monkey = (Monkey) session.get(Monkey.class, new Long(id));
			Hibernate.initialize(monkey.getImages());
			tx.commit();
			
			return monkey;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	private void printMonkey(Monkey monkey) {
		System.out.println(monkey.getImages().getClass().getName());
		
		Iterator<String> it = monkey.getImages().iterator();
		while (it.hasNext()) {
			String fileName = (String) it.next();
			System.out.println(fileName);
		}
	}
	
	public static void main(String[] args) {
		MonkeyDao dao = new MonkeyDao();
		
		Set<String> images = new HashSet<String>();
		images.add("image1.jpg");
		images.add("image2.jpg");
		images.add("image3.jpg");
		images.add("image4.jpg");
		
		Monkey monkey = new Monkey("Tom", 21, images);
		dao.saveOrUpdate(monkey);
		
		monkey = dao.loadMonkey(1);
		dao.printMonkey(monkey);
		
	}
}
