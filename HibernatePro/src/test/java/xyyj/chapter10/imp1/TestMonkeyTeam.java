package xyyj.chapter10.imp1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMonkeyTeam {
	private static MonkeyTeamDao dao = new MonkeyTeamDao();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Monkey> monkeys = dao.findAllMonkeys();
		for (Monkey m : monkeys) {
			System.out.println(m);
		}
		
		Team team = dao.loadTeam(1);
		Set<Monkey> result = team.getMonkeys();
		
		printAllMonkeys(result.iterator());
//		for (Monkey m : result) {
//			System.out.println(m);
//		}
	}
	
	private void printAllMonkeys(Iterator<Monkey> it) {
		while (it.hasNext()) {
			Monkey m = it.next();
			System.out.println(m);
		}
	}

}
