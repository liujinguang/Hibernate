package xyyj.chapter10.imp2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import xyyj.dbutils.AbstractDao;

public class MonkeyTeamDao extends AbstractDao {
	public MonkeyTeamDao() {
	}

	public List<Monkey> findAllJMonkeys() {
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Monkey> results = session.createQuery("from JMonkey").list();
			tx.commit();

			return results;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Monkey> findAllMonkeys() {
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Monkey> results = session.createQuery("from Monkey").list();
			tx.commit();

			return results;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public Team loadTeam(long id) {
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Team team = (Team) session.get(Team.class, new Long(id));
			Hibernate.initialize(team.getMonkeys());
			tx.commit();

			return team;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

	}

	private void printAllMonkeys(Iterator<Monkey> it) {
		while (it.hasNext()) {
			Monkey m = it.next();
			System.out.println(m);
		}
	}
	// public void saveMonkey() {
	// Session session = getSession();
	// Transaction tx = null;
	//
	// try {
	// tx = session.beginTransaction();
	// JMonkey monkey = new Jm
	// Team team = (Team)session.get(Team.class, new Long(id));
	// Hibernate.initialize(team.getMonkeys());
	// tx.commit();
	//
	// return team;
	// } catch (RuntimeException e) {
	// if (tx != null) {
	// tx.rollback();
	// }
	// throw e;
	// } finally {
	// session.close();
	// }
	// }

	public static void main(String[] args) {
		MonkeyTeamDao dao = new MonkeyTeamDao();
		List<Monkey> jMonkeys = dao.findAllJMonkeys();
		
		dao.printAllMonkeys(jMonkeys.iterator());
		
//		Monkey monkey = new JMonkey("Mary", "yellow", dao.loadTeam(1));
//		dao.saveOrUpdate(monkey);
		
		List<Monkey> monkeys = dao.findAllMonkeys();
		dao.printAllMonkeys(monkeys.iterator());
	}
}
