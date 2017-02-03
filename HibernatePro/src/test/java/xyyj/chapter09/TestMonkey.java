package xyyj.chapter09;

//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xyyj.dbutils.AbstractDao;

public class TestMonkey {
//	private MonkeyDao dao;// = new MonkeyDao();
    //private static Logger rootLogger = Logger.getLogger("rootLogger");
    
	@Before
	public void setUp() throws Exception {
//		dao = new MonkeyDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveMonkey() {
		MonkeyDao dao = new MonkeyDao();
		Session session = dao.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Monkey monkey = new Monkey();
			Address homeAddress = new Address("homeProvince", "homeCity", "homeStreet", "100001");
			Address comAddress = new Address("comAddress", "comCity", "comStreet", "200002");
			monkey.setName("Tom");
			monkey.setHomeAddress(homeAddress);
			monkey.setComAddress(comAddress);
			monkey.setPhone(new Integer(55556666));
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

}
