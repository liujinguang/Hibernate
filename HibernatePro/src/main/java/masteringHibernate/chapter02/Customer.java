package masteringHibernate.chapter02;

import java.util.Set;
import java.util.HashSet;

public class Customer {
	private Long id;
	private String name;
	private int age;
	private Set<Order> orders = new HashSet<Order>();

	/** 完整的构造方法 */
	public Customer(String name, int age, Set<Order> orders) {
		this.name = name;
		this.age = age;
		this.orders = orders;
	}

	/** 默认构造方法 */
	public Customer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}

/****************************************************
 * 作者：孙卫琴 * 来源：<<精通Hibernate：Java对象持久化技术详解>> * 技术支持网址：www.javathinker.org *
 ***************************************************/
