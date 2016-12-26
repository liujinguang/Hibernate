package xyyj.chapter08;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xyyj.dbutils.AbstractDao;

public class TestMonkey {
    private static AbstractDao dao = new MonkeyTeamDao();
    private static Logger rootLogger = Logger.getLogger("rootLogger");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveMonkey() {
        Session session = dao.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Monkey monkey = new Monkey();
            Address homeAddress = new Address("province1", "city1", "street1",
                    "100001", monkey);
            Address comAddress = new Address("province2", "city2", "street2",
                    "200002", monkey);
            monkey.setName("Tom");
            monkey.setHomeAddress(homeAddress);
            monkey.setComAddress(comAddress);
            rootLogger.info("save the monkey");
            session.save(monkey);
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

    @Test
    public void testSaveAddressSeparately() {
        Session session = dao.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Address address = new Address("province1", "city1", "street1",
                    "100001", null);
            session.save(address);

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
    public void testSaveMonkeyWithNoAddress() {
        Session session = dao.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Monkey monkey = new Monkey();
            monkey.setName("John");

            session.save(monkey);
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

    public Monkey findMonkey(long monkey_id) {
        Session session = dao.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Monkey monkey = (Monkey) session.get(Monkey.class, new Long(
                    monkey_id));
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

    public void printMonkeyAddress(Monkey monkey) {
        Address homeAddress = monkey.getHomeAddress();
        Address comAddress = monkey.getComAddress();
        if (homeAddress == null)
            System.out.println("Home Address of " + monkey.getName()
                    + " is null.");
        else
            System.out.println("Home Address of " + monkey.getName() + " is: "
                    + homeAddress.getProvince() + " " + homeAddress.getCity()
                    + " " + homeAddress.getStreet());

        if (comAddress == null)
            System.out.println("Company Address of " + monkey.getName()
                    + " is null.");
        else
            System.out.println("Company Address of " + monkey.getName()
                    + " is: " + comAddress.getProvince() + " "
                    + comAddress.getCity() + " " + comAddress.getStreet());
    }

    @Test
    public void testGetMonkey() {
        Monkey monkey = findMonkey(1);
        printMonkeyAddress(monkey);
    }

    @Test
    public void deleteMonkey(Monkey monkey) {
        Session session = dao.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.delete(monkey);
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
