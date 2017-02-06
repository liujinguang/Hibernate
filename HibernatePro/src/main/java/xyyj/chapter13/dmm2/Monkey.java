package xyyj.chapter13.dmm2;

import java.util.Set;
import java.util.HashSet;

public class Monkey {
	private Long id;
	private String name;
	private Set<Learning> learnings = new HashSet<Learning>();

	public Monkey(String name, Set<Learning> learnings) {
		this.name = name;
		this.learnings = learnings;
	}

	/** default constructor */
	public Monkey() {
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

	public Set<Learning> getLearnings() {
		return this.learnings;
	}

	public void setLearnings(Set<Learning> learnings) {
		this.learnings = learnings;
	}

}
