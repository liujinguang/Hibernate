package xyyj.chapter05.bidirection;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import xyyj.chapter05.unidirection.MonkeyTeamDao;

public class MonkeyTeamTest {
	private static MonkeyTeamDao dao = null;
	private Long idOfTeam;
	private Long idOfMonkey;

	@Before
	public void setUp() throws Exception {
		dao = new MonkeyTeamDao();
	}

	@Test
	public void saveTeamAndMonkeyWithCascade() {
		Team team = new Team("Bull");
		Monkey monkey = new Monkey("TOM");

		team.getMonkeys().add(monkey);
		monkey.setTeam(team);

		dao.saveOrUpdate(team);
	}

	@Test
	public void printTeamAndMonkey() {
		Team team = (Team) dao.getById(Team.class, 1);
		System.out.println(team);

		Set<Monkey> monkeys = team.getMonkeys();
		for (Monkey monkey : monkeys) {
			System.out.println(monkey);
		}
	}

	private void saveTeamAndMonkeySeprately() {
		Team team = new Team("Dream");
		Monkey monkey = new Monkey("Jack");
		dao.saveOrUpdate(team);
		dao.saveOrUpdate(monkey);

		idOfTeam = team.getId();
		idOfMonkey = monkey.getId();
	}

	private void associateTeamAndMonkey() {
		Session session = dao.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Team team = (Team) session.load(Team.class, idOfTeam);
			Monkey monkey = (Monkey) session.load(Monkey.class, idOfMonkey);

			team.getMonkeys().add(monkey);
			// monkey.setTeam(team);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Test
	public void TestInverse() {
		saveTeamAndMonkeySeprately();
		associateTeamAndMonkey();
	}

	@Test
	public void testDeleteCascade() {
		// cascade="delete"
		saveTeamAndMonkeySeprately();
		dao.delete(dao.getById(Team.class, idOfTeam));
	}

	@Test
	public void testDeleteAllDeleteOrphan() {
		// cascade="all-delete-orphan"
		saveTeamAndMonkeySeprately();
//		Monkey monkey = (Monkey) dao.getById(Monkey.class, idOfMonkey);
//		monkey.setTeam(null);
//		Team team = (Team) dao.getById(Team.class, idOfTeam);
//		team.getMonkeys().remove(monkey);
//		dao.delete(team);
		removeMonkeyFromTeam(idOfTeam);
	}

	public void removeMonkeyFromTeam(Long teamId) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Team team = (Team) session.load(Team.class, teamId);
			Monkey monkey = (Monkey) session.load(Monkey.class, idOfMonkey);

			// 解除team和Monkey的关联关系
			team.getMonkeys().remove(monkey);
			monkey.setTeam(null);
			
			session.delete(team);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
