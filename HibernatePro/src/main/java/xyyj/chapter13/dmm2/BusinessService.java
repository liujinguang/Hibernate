package xyyj.chapter13.dmm2;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class BusinessService {
	public static SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
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

	public void saveTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(teacher);
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

	public Monkey loadMonkey(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Monkey monkey = (Monkey) session.get(Monkey.class, id);

			Set<Learning> learnings = monkey.getLearnings();
			Iterator<Learning> it = learnings.iterator(); // 初始化Learnings
			while (it.hasNext()) {
				Learning learning = (Learning) it.next();
				Hibernate.initialize(learning.getTeacher()); // 初始化Teacher
			}
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

	public void printMonkey(Monkey monkey) {
		System.out.println("名字:" + monkey.getName());

		Set<Learning> learnings = monkey.getLearnings();
		Iterator<Learning> it = learnings.iterator();
		while (it.hasNext()) {
			Learning learning = it.next();
			System.out.println("-----------------------");
			System.out.println("老师:" + learning.getTeacher().getName());
			System.out.println("功夫:" + learning.getGongfu());
		}

	}

	public void test() {

		Teacher teacher1 = new Teacher("二郎神", null);
		Teacher teacher2 = new Teacher("红孩儿", null);
		saveTeacher(teacher1);
		saveTeacher(teacher2);

		Monkey monkey = new Monkey();
		monkey.setName("智多星");
		Learning learning1 = new Learning(teacher1, monkey, "七十三变");
		Learning learning2 = new Learning(teacher2, monkey, "三昧真火");

		monkey.getLearnings().add(learning1);
		monkey.getLearnings().add(learning2);
		saveMonkey(monkey);

		monkey = loadMonkey(monkey.getId());
		printMonkey(monkey);

	}

	public static void main(String args[]) {
		new BusinessService().test();
		sessionFactory.close();
	}
}
