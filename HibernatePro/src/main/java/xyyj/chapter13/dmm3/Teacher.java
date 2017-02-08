package xyyj.chapter13.dmm3;

import java.util.Set;
import java.util.HashSet;

public class Teacher {
	private Long id;
	private String name;
	private Set<Learning> learnings = new HashSet<Learning>();

	/** full constructor */
	public Teacher(String name, Set<Learning> learnings) {
		this.name = name;
		this.learnings = learnings;
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

	public Set<Learning> getLearnings() {
		return this.learnings;
	}

	public void setLearnings(Set<Learning> learnings) {
		this.learnings = learnings;
	}

}
