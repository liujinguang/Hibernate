package xyyj.chapter06;

import static org.junit.Assert.*;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatchOpTest {
    MonkeyTeamDao dao = new MonkeyTeamDao();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 6.5.1.1: insert items batchly
     */
    @Test
    public void prepareData() {
        Session session = dao.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Team team = new Team("Bull");
            session.save(team);

            for (int i = 1; i < 500; i++) {
                // int i = 1;
                System.out.println("============" + i + "============");
                Monkey monkey = new Monkey("Monkey" + i, i);
                monkey.setTeam(team);
                session.save(monkey);

                if (i % 20 == 0) {
                    // tx.commit();
                    session.flush(); // flush the cache and insert data into
                                     // database
                    session.clear(); // clear the objects cached in the session
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 6.5.1.2
     */
    @Test
    public void testUpdateBatchly() {
        Session session = dao.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ScrollableResults monkeys = session.createQuery("From Monkey")
                    .scroll(ScrollMode.FORWARD_ONLY);

            int count = 0;

            while (monkeys.next()) {
                Monkey monkey = (Monkey) monkeys.get(0);
                monkey.setAge(monkey.getAge() + 1);

                if (++count % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 6.5.2
     */
    @Test
    public void TestStatelessSession() {
        StatelessSession session = dao.getStatelessSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ScrollableResults monkeys = session.getNamedQuery("GetMonkeys")
                    .scroll(ScrollMode.FORWARD_ONLY);

            while (monkeys.next()) {
                Monkey monkey = (Monkey) monkeys.get(0);
                monkey.setAge(monkey.getAge() + 1);
                System.out.println(monkey);
                session.update(monkey);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
