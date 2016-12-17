package xyyj.dbutils;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDao {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration()
							 .configure()
							 .buildSessionFactory();
	}
	
    public static void saveOrUpdate(Object object) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.saveOrUpdate(object);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();

                throw e;
            }
        } finally {
            session.close();
        }
        
    }

    public static void delete(Object obj) {
    	Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.delete(obj);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();

                throw e;
            }
        } finally {
            session.close();
        }
    }

    public Object getById(Class clazz, int id) {
    	Session session = sessionFactory.openSession();
        Transaction tx = null;
        Object object = null;

        try {
            tx = session.beginTransaction();

            object = session.get(clazz, id);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();

                throw e;
            }
        } finally {
            session.close();
        }

        return object;
    }
    
//    public boolean isValidUser(String user, String password) {
//    	List<Admin> list = findAll();
//    	
//    	for (Admin admin : list) {
//    		if (admin.getName().equals(user) && admin.getPassword().equals(password)) {
//    			return true;
//    		}
//    	}
//    	
//    	return false;
//    }

    @SuppressWarnings("unchecked")
    public List findAll(Class clazz) {
    	Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //Method 1:
            //List<Admin> list = (List<Admin>) session.createQuery("FROM Admin").list();

            
            //Method 2: orientation object
            Criteria criteria = session.createCriteria(clazz);
            
            //add filter
            //criteria.add(Restrictions.eq("id", 5));
            //criteria.addOrder(Order.asc("id"));
            
            List list = criteria.list();
            
            tx.commit();

            return list;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();

                throw e;
            }
        } finally {
            session.close();
        }
        
        return null;
    }

}