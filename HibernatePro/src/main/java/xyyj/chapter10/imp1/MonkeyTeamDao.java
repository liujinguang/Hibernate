package xyyj.chapter10.imp1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.functors.IfClosure;
import org.hibernate.Session;
import org.hibernate.Transaction;

import xyyj.dbutils.AbstractDao;

public class MonkeyTeamDao extends AbstractDao {
	public MonkeyTeamDao() {
	}

	public List<Monkey> findAllMonkeys() {
		Session session = getSession();
		Transaction tx = null;
		List<Monkey> results = new ArrayList<Monkey>();

		try {
			tx = session.beginTransaction();
			List<Monkey> jMonkeys = session.createQuery("from JMonkey").list();
			results.addAll(jMonkeys);

			List<Monkey> cMonkeys = session.createQuery("from CMonkey").list();
			results.addAll(cMonkeys);

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
			if (team != null) {

				List<Monkey> jMonkeys = session.createQuery("from JMonkey j where j.team.id=" + id).list();
				team.getMonkeys().addAll(jMonkeys);

				List<Monkey> cMonkeys = session.createQuery("from CMonkey c where c.team.id=" + id).list();
				team.getMonkeys().addAll(cMonkeys);
			}
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
}
