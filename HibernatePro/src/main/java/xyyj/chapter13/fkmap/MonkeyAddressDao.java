package xyyj.chapter13.fkmap;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import xyyj.dbutils.AbstractDao;

public class MonkeyAddressDao extends AbstractDao {
	public MonkeyAddressDao() {
		// TODO Auto-generated constructor stub
	}

	public Monkey loadMonkey(Long id) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Monkey monkey = (Monkey) session.get(Monkey.class, id);
			Hibernate.initialize(monkey.getHomeAddress());
			Hibernate.initialize(monkey.getComAddress());
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

	public void printMonkey(Monkey monkey) {
		Address homeAddress = monkey.getHomeAddress();
		Address comAddress = monkey.getComAddress();
		System.out.println("Home Address of " + monkey.getName() + " is: " + homeAddress.getProvince() + " "
				+ homeAddress.getCity() + " " + homeAddress.getStreet());

		System.out.println("Company Address of " + monkey.getName() + " is: " + comAddress.getProvince() + " "
				+ comAddress.getCity() + " " + comAddress.getStreet());

		if (homeAddress.getMonkey() == null)
			System.out.println("Can not naviagte from homeAddress to Monkey.");

		if (comAddress.getMonkey() == null)
			System.out.println("Can not naviagte from comAddress to Monkey.");

	}

	public static void main(String args[]) {
		MonkeyAddressDao dao = new MonkeyAddressDao();

		Monkey monkey = new Monkey();
		Address homeAddress = new Address("province1", "city1", "street1", "100001", monkey);
		Address comAddress = new Address("province2", "city2", "street2", "200002", monkey);
		monkey.setName("Tom");
		monkey.setHomeAddress(homeAddress);
		monkey.setComAddress(comAddress);

		dao.saveOrUpdate(monkey);
		monkey = dao.loadMonkey(monkey.getId());
		dao.printMonkey(monkey);
	}
}
