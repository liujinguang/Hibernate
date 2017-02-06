package xyyj.chapter13.dmm1;

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

	public Monkey loadMonkey(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Monkey monkey = (Monkey) session.get(Monkey.class, id);
			Hibernate.initialize(monkey.getTeachers());
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
		Set teachers = monkey.getTeachers();
		Iterator it = teachers.iterator();
		while (it.hasNext()) {
			Teacher teacher = (Teacher) it.next();
			System.out.println(monkey.getName() + " " + teacher.getName());
		}

	}

	public void test() {
		Teacher teacher1 = new Teacher("二郎神");
		Teacher teacher2 = new Teacher("红孩儿");

		Monkey monkey1 = new Monkey();
		monkey1.setName("智多星");
		monkey1.getTeachers().add(teacher1);
		monkey1.getTeachers().add(teacher2);
		teacher1.getMonkeys().add(monkey1);
		teacher2.getMonkeys().add(monkey1);

		Monkey monkey2 = new Monkey();
		monkey2.setName("老顽童");
		monkey2.getTeachers().add(teacher1);
		teacher1.getMonkeys().add(monkey2);

		saveMonkey(monkey1);
		saveMonkey(monkey2);

		monkey1 = loadMonkey(monkey1.getId());
		printMonkey(monkey1);

	}

	public static void main(String args[]) {
		new BusinessService().test();
		sessionFactory.close();
	}
}
