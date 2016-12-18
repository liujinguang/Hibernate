package xyyj.chapter05.unidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import xyyj.dbutils.AbstractDao;

public class MonkeyTeamDao extends AbstractDao {
	public List findMonkeyByTeam(Team team) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List monkeys = session.createQuery("from Monkey as m where m.team.id=" + team.getId()).list();
			tx.commit();

			return monkeys;
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
