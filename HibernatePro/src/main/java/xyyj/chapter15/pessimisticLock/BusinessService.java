package xyyj.chapter15.pessimisticLock;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class BusinessService extends Thread {
	public static SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration().configure();
//			config.addClass(Monkey.class);

			sessionFactory = config.buildSessionFactory();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private Log log;

	public BusinessService(String name, Log log) {
		super(name);
		this.log = log;
	}

	public void run() {
		try {
			vote();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void vote() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			log.write(getName() + ":开始事务");
			Thread.sleep(500);

			Monkey monkey = (Monkey) session.get(Monkey.class, new Long(1), LockMode.UPGRADE);
//			Monkey monkey = (Monkey) session.get(Monkey.class, new Long(1));
			log.write(getName() + ":查询到智多星的票数为" + monkey.getCount());
			Thread.sleep(500);

			monkey.setCount(monkey.getCount() + 1);
			log.write(getName() + ":把智多星的票数改为" + monkey.getCount());

			log.write(getName() + ":提交事务");
			tx.commit();

			Thread.sleep(500);

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public static void main(String args[]) throws Exception {
		Log log = new Log();
		Thread thread1 = new BusinessService("猴子甲投票事务", log);
		Thread thread2 = new BusinessService("猴子乙投票事务", log);

		thread1.start();
		thread2.start();

		while (thread1.isAlive() || thread2.isAlive()) {
			Thread.sleep(100);
		}
		log.print();
		sessionFactory.close();
	}
}

class Log {
	private ArrayList<String> logs = new ArrayList<String>();

	synchronized void write(String text) {
		logs.add(text);
	}

	public void print() {
		for (Iterator<String> it = logs.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
