package xyyj.chapter12.testmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Map<String, String> images = monkey.getImages();
		Set<String> keys = images.keySet();

		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String fileName = images.get(key);
			System.out.println(monkey.getName() + " " + key + " " + fileName);
		}
	}

	public static void main(String[] args) {
		MonkeyDao dao = new MonkeyDao();
		Map<String, String> images = new HashMap<String, String>();
		images.put("image1", "image1.jpg");
		images.put("image4", "image4.jpg");
		images.put("image2", "image2.jpg");
		images.put("imageTwo", "image2.jpg");
		images.put("image5", "image5.jpg");

		Monkey monkey = new Monkey("Tom", 21, images);
		dao.saveOrUpdate(monkey);

		monkey = dao.loadMonkey(1);
		dao.printMonkey(monkey);

	}
}
