package xyyj.chapter05.bidirection;

import java.util.HashSet;
import java.util.Set;

public class Team {
	public Team() {
		
	}
	
	public Team(String name) {
		this.name = name;
	}
	
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
	
	@Override
	public String toString() {
		return "[ID=" + id + ", name=" + name + "]";
	}

	private Long id;
	private String name;
	private Set<Monkey> monkeys = new HashSet<Monkey>();
}
