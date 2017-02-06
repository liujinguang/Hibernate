package xyyj.chapter13.dmm1;

import java.util.Set;
import java.util.HashSet;

public class Teacher {
	private Long id;
	private String name;
	private Set<Monkey> monkeys = new HashSet<Monkey>();

	/** full constructor */
	public Teacher(String name) {
		this.name = name;
	}

	/** default constructor */
	public Teacher() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Monkey> getMonkeys() {
		return this.monkeys;
	}

	public void setMonkeys(Set<Monkey> monkeys) {
		this.monkeys = monkeys;
	}

}
