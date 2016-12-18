package xyyj.chapter05.unidirection;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyyj.chapter05.unidirection.Team;

public class MonkeyTest {
	private static MonkeyTeamDao dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao = new MonkeyTeamDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveTeamAndMonkey() {
//		Team team = new Team();
		Team team = new Team("Dragon");
		dao.saveOrUpdate(team);
		
//		Monkey monkey1 = new Monkey("Xiaoxiao", team);
		dao.saveOrUpdate(new Monkey("Xiaoxiao", team));
		dao.saveOrUpdate(new Monkey("Xiaoben", team));
		
		List<Monkey> list = dao.findMonkeyByTeam(team);
		for (Monkey monkey : list) {
			System.out.println(monkey);
		}
	}
	
	@Test
	public void saveTeamAndMonkeyCascade() {
		Team team = new Team("Dragon1");
//		dao.saveOrUpdate(team);
		
		Monkey monkey1 = new Monkey("Xiaoxiao1", team);
		dao.saveOrUpdate(monkey1);
	}
	
	@Test
	public void getMonkey() {
		Monkey monkey = (Monkey)dao.getById(Monkey.class, 1);
		System.out.println(monkey);
		System.out.println(monkey.getTeam());
	}

}
