package xyyj.chapter07;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xyyj.dbutils.AbstractDao;

public class TestMonkeyTeam {
    private static AbstractDao dao = new MonkeyTeamDao();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLoadTeam() {
        Session session = dao.getSession();
        Transaction tx = null;
        Team team = null;
        try {
            tx = session.beginTransaction();

            System.out.println("loadTeam():executing session.load()");
            team = (Team) session.load(Team.class, new Long(1));

//            System.out.println("loadTeam():executing team.getName()");
//            team.getName();
//            if (Hibernate.isInitialized(team)) {
//                Hibernate.initialize(team);
//            }

//            System.out
//                    .println("loadTeam():executing team.getMonkeys().iterator()");
//            Iterator<Monkey> monkeyIterator = team.getMonkeys().iterator();

            tx.commit();

        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        
        System.out.println(team);
        Set<Monkey> monkeys = team.getMonkeys();
        for (Monkey monkey : monkeys) {
            System.out.println(monkey);
        }
    }
    
    @Test
    public void testHQLQuery() {
        Session session = dao.getSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Monkey as m where m.name=monkeyName and m.age=monkeyAge");
            query.setString("monkeyName", "Tom");
            query.setInteger("monkeyAge", 21);
            
            List<Monkey> results = query.list();
            
            tx.commit();
            
            for (Monkey monkey :  results) {
                System.out.println(monkey);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void testQBCQuery() {
        Session session = dao.getSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Monkey.class);
            Criterion criterion1 = Restrictions.like("name", "T%");
//            Criterion criterion2 = Restrictions.eq("age", new Integer(21));
            
            criteria.add(criterion1);
//            criteria.add(criterion2);
            
            List<Monkey> results = criteria.list();
            
            tx.commit();
            
            for (Monkey monkey :  results) {
                System.out.println(monkey);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    @Test
    public void testSQLQuery() {
        Session session = dao.getSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
            Query query = session
                    .createSQLQuery("select * from monkeys where name like :monkeyName")
                    .setString("monkeyName", "T%");
            
//            criteria.add(criterion1);
//            criteria.add(criterion2);
            
            List<Monkey> results = query.list();
            
            tx.commit();
            
            for (Monkey monkey :  results) {
                System.out.println(monkey);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
