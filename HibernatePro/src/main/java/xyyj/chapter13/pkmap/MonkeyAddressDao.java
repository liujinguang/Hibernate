package xyyj.chapter13.pkmap;

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
			Hibernate.initialize(monkey.getAddress());
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
		Address address = monkey.getAddress();
		System.out.println("Home Address of " + monkey.getName() + " is: " + address.getProvince() + " "
				+ address.getCity() + " " + address.getStreet());


		if (address.getMonkey() == null)
			System.out.println("Can not naviagte from homeAddress to Monkey.");

	}

	public static void main(String args[]) {
		MonkeyAddressDao dao = new MonkeyAddressDao();

		Monkey monkey = new Monkey();
		Address address = new Address("province1", "city1", "street1", "100001", monkey);
		monkey.setName("Tom");
		monkey.setAddress(address);

		dao.saveOrUpdate(monkey);
		monkey = dao.loadMonkey(monkey.getId());
		dao.printMonkey(monkey);
	}
}
