package xyyj.chapter10.imp2;

import java.util.HashSet;
import java.util.Set;

public class Team {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Monkey> getMonkeys() {
		return monkeys;
	}

	public void setMonkeys(Set<Monkey> monkeys) {
		this.monkeys = monkeys;
	}

	public Team(String name, Set<Monkey> monkeys) {
		this.name = name;
		this.monkeys = monkeys;
	}
	
	public Team() {
		
	}
	
	public Team(Set<Monkey> monkeys) {
		this.monkeys = monkeys;
	}

	public Long id;
	private String name;
	private Set<Monkey> monkeys = new HashSet<Monkey>();
}
